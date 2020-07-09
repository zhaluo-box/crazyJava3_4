package com.example.javademo.sftp.utils;

import com.jcraft.jsch.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;

/**
 * 设置范例
 *  sftp:
 *   yun01:
 *     username: root
 *     password: zhaluobox
 *     prot: 22
 *     host: 192.168.13.129
 *     timeout: 5000
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "sftp")
@Slf4j
public class SftpConfigProperties {

    private static HashMap<String, HashMap<String, String>> sftpProperties;

    /**
     * 默认连接数为5S
     */
    private static Integer defaultTimeOut = 5000;

    /**
     * 默认连接端口为22
     */
    private static Integer defaultPort = 22;

    static class PropertiesConstants {

        static final String USERNAME = "username";
        static final String PASSWORD = "password";
        static final String PORT = "port";
        static final String HOST = "host";
        static final String TIMEOUT = "timeout";

    }

    /**
     * 获取连接.
     *
     * @param hostNameKey 连接的主机名.
     * @return 连接.
     * @throws JSchException 连接异常.
     */
    public static ChannelSftp getChannel(String hostNameKey) throws JSchException {
        final HashMap<String, String> properties = sftpProperties.get( hostNameKey );
        if (CollectionUtils.isEmpty( properties )) {
            log.info( "sftp connection fail !!" );
            log.info( "请检查sftp配置与hostNameKey : {} ", hostNameKey );
            return null;
        }
        final String host = properties.get( PropertiesConstants.HOST );
        final String port = properties.get( PropertiesConstants.PORT );
        final String password = properties.get( PropertiesConstants.PASSWORD );
        final String username = properties.get( PropertiesConstants.USERNAME );
        final String timeout = properties.get( PropertiesConstants.TIMEOUT );
        // 如果端口不为空,则将设定的端口赋予默认端口
        if (!StringUtils.isBlank( port )) {
            defaultPort = Integer.valueOf( port );
        }
        // 如果连接时间不为空,则将设定的连接时间赋予默认时间;
        if (!StringUtils.isBlank( timeout )) {
            defaultTimeOut = Integer.valueOf( timeout );
        }
        // 创建JSch对象
        JSch jsch = new JSch();
        // 根据用户名，主机ip，端口获取一个Session对象
        final Session session = jsch.getSession( username, host, defaultPort );
        log.debug( "Session created." );
        if (!StringUtils.isBlank( password )) {
            session.setPassword( password ); // 设置密码
        }
        // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig( "StrictHostKeyChecking", "no" );
        session.setTimeout( defaultTimeOut ); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        log.info( "Session connected!" );
        log.info( "Opening Channel!" );
        Channel channel = session.openChannel( "sftp" ); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        log.info( "Connected successfully to ftpHost = {} ,as ftpUserName = {} ", host, username );
        return (ChannelSftp) channel;
    }

}

