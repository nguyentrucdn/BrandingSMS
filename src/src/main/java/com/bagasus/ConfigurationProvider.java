package com.bagasus;

import com.bagasus.model.*;
import com.bagasus.model.external.AppToken;
import com.bagasus.model.external.SiteConfigurationExternal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.typesafe.config.Config;

public class ConfigurationProvider {
    private String clientName;
    private String secret;
    private String loginUrl;
    private String configUrl;
    private Config config;
    private SiteConfiguration siteConfiguration;
    private Gson gson;
    private String accessToken;
    private String appName;

    private static ConfigurationProvider instance;

    private ConfigurationProvider(){
        this.siteConfiguration = new SiteConfiguration();
        this.siteConfiguration.setViettelConfig(new ViettelConfig());
        this.siteConfiguration.setVnptConfig(new VnptConfig());
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
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
        siteConfiguration.setEnableVietel("true".equals(getString("bagasus.sms.viettel.enable")));
        siteConfiguration.setEnableVina("true".equals(getString("bagasus.sms.vina.enable")));
        siteConfiguration.setEnableMobile("true".equals(getString("bagasus.sms.mobi.enable")));

        ViettelConfig viettelConfig = siteConfiguration.getViettelConfig();
        viettelConfig.setUser(getString("bagasus.sms.viettel.user"));
        viettelConfig.setPass(getString("bagasus.sms.viettel.pass"));
        viettelConfig.setBrand(getString("bagasus.sms.viettel.brand"));
        viettelConfig.setCpc(getString("bagasus.sms.viettel.cpc"));
        viettelConfig.setHeader(getString("bagasus.sms.viettel.header").split(","));

        configUrl = getString("bagasus.config_get");
        clientName = getString("bagasus.client_name");
        secret = getString("bagasus.secret");
        loginUrl = getString("bagasus.login_path");

        AppToken token = getToken();
        accessToken = token.getToken().getAccessToken();
        appName = token.getAppName();

        updateSiteConfigurationFromExternal();
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public SiteConfiguration getSiteConfiguration() {
        return siteConfiguration;
    }

    public String getString(String path){
        return config.getString(path);
    }

    public Gson getGson(){
        return gson;
    }

    public void updateConfig(SiteConfigurationExternal configurationExternal){
        siteConfiguration.setVerifyTokenPath(configurationExternal.getVerifyTokenPath());
        siteConfiguration.setLogPath(configurationExternal.getLogPath());
        siteConfiguration.setRoleToBeVerified(configurationExternal.getRoleToBeVerified());
        siteConfiguration.setEnableVietel(configurationExternal.getEnableVietel());
        siteConfiguration.setEnableVina(configurationExternal.getEnableVina());
        siteConfiguration.setEnableMobile(configurationExternal.getEnableMobile());

        ViettelConfig viettelConfig = siteConfiguration.getViettelConfig();
        viettelConfig.setUser(configurationExternal.getVietelConfig().getUserName());
        viettelConfig.setPass(configurationExternal.getVietelConfig().getPassWord());
        viettelConfig.setBrand(configurationExternal.getVietelConfig().getBrandName());
        viettelConfig.setCpc(configurationExternal.getVietelConfig().getCpCode());
    }

    private AppToken getToken(){
        RestResult result = RestHelper.login(loginUrl, clientName, secret);
        return gson.fromJson(result.getMessage(), AppToken.class);
    }

    private void updateSiteConfigurationFromExternal(){
        RestResult result = RestHelper.getSiteConfig(configUrl, "BEARER " + accessToken, appName);
        SiteConfigurationExternal siteConfigurationExternal = gson.fromJson(result.getMessage(), SiteConfigurationExternal.class);
        updateConfig(siteConfigurationExternal);
    }
}
