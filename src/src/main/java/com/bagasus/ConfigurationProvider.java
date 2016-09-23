package com.bagasus;

import com.bagasus.model.SiteConfiguration;
import com.typesafe.config.Config;

/**
 * Created by thainguy on 9/21/2016.
 */
public class ConfigurationProvider {
    private Config config;
    private SiteConfiguration siteConfiguration;

    private static ConfigurationProvider instance;

    private ConfigurationProvider(){
        this.siteConfiguration = new SiteConfiguration();
    }

    public static ConfigurationProvider Instance(){
        if(instance == null){
            instance = new ConfigurationProvider();
        }

        return instance;
    }

    public void initialize(){
        siteConfiguration.setVerifyTokenPath(getString("bagasus.token_path"));
        siteConfiguration.setLogPath(getString("bagasus.log_path"));
        siteConfiguration.setRoleToBeVerified(Integer.parseInt(getString("bagasus.role")));
        siteConfiguration.setAppId(getString("bagasus.app_id"));
        siteConfiguration.setEnableVietel("true".equals(getString("bagasus.sms.viettel.enable")));
        siteConfiguration.setEnableVina("true".equals(getString("bagasus.sms.vina.enable")));
        siteConfiguration.setEnableMobile("true".equals(getString("bagasus.sms.mobi.enable")));
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public SiteConfiguration getSiteConfiguration() {
        return siteConfiguration;
    }

    public void setSiteConfiguration(SiteConfiguration siteConfiguration) {
        this.siteConfiguration = siteConfiguration;
    }

    public String getString(String path){
        return config.getString(path);
    }
}
