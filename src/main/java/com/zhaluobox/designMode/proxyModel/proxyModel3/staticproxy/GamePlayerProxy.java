package com.zhaluobox.designMode.proxyModel.proxyModel3.staticproxy;

/**
 * 游戏代练
 *
 * @author 扎罗
 * @version 1.0.0
 * @Date 2020-9-23 10:28
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer gamePlayer;

    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login( user, password );
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upGrade() {
        this.gamePlayer.upGrade();
    }
}
