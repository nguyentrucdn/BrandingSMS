package com.bagasus.model;

import java.io.Serializable;

/**
 * Created by thainguy on 9/22/2016.
 */
public class SiteConfiguration implements Serializable {
    private boolean enableVietel = true;
    private boolean enableVina = true;
    private boolean enableMobile = false;
    private String verifyTokenPath = "https://yeahbo-oauth-dot-yeahbo-carrier.appspot.com/_ah/api/oauth/token/verify";
    private String logPath = "https://yeahbo-collector-dot-yeahbo-carrier.appspot.com/_ah/api/agent/log/entry/put";
    private int roleToBeVerified = 33554432;
    private String appId;

    public boolean isEnableVietel() {
        return enableVietel;
    }

    public void setEnableVietel(boolean enableVietel) {
        this.enableVietel = enableVietel;
    }

    public boolean isEnableVina() {
        return enableVina;
    }

    public void setEnableVina(boolean enableVina) {
        this.enableVina = enableVina;
    }

    public boolean isEnableMobile() {
        return enableMobile;
    }

    public void setEnableMobile(boolean enableMobile) {
        this.enableMobile = enableMobile;
    }

    public String getVerifyTokenPath() {
        return verifyTokenPath;
    }

    public void setVerifyTokenPath(String verifyTokenPath) {
        this.verifyTokenPath = verifyTokenPath;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public int getRoleToBeVerified() {
        return roleToBeVerified;
    }

    public void setRoleToBeVerified(int roleToBeVerified) {
        this.roleToBeVerified = roleToBeVerified;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
