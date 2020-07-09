package com.example.javademo.sftp.utils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.jcraft.jsch.ChannelSftp.LsEntrySelector.BREAK;
import static com.jcraft.jsch.ChannelSftp.LsEntrySelector.CONTINUE;

@Service
@Slf4j
public class SftpDownload {

    public void downloadFile() {
        try {
            final ChannelSftp yun = SftpConfigProperties.getChannel( "yun01" );
            ChannelSftp.LsEntrySelector selector = (lsEntry) -> {
                final String yesterdayDate = this.getYesterdayDate( "yyyyMMdd" );
                final String newDate = getDate( "yyyyMMdd" );
                if (lsEntry.getFilename().startsWith( "451111912160001_" + yesterdayDate + "_" + newDate )) {
                    try {
                        yun.get( "/opt/sftp/yun01/"+lsEntry.getFilename(),"D:\\test" );
                    } catch (SftpException e) {
                        log.info( "Sftp 文件下载异常 : {}", e );
                    }
                    return BREAK;
                }
                return CONTINUE;
            };
            assert yun != null;
            yun.ls( "/opt/sftp/yun01", selector );
        } catch (JSchException e) {
            log.info( "文件下载失败!!!" );
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }

    /**
     * 日期格式为：yyyy-MM-dd.
     *
     * @return String
     */
    public String getYesterdayDate(String format) {
        Calendar cal = Calendar.getInstance();
        cal.add( Calendar.DATE, -1 );
        Date time = cal.getTime();
        String formatDate = new SimpleDateFormat( format ).format( time );
        return formatDate;
    }

    private String getDate(String format) {
        final Date date = new Date();
        return new SimpleDateFormat( format ).format( date );
    }
}
