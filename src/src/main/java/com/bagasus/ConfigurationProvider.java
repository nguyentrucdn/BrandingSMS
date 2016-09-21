package com.bagasus;

import com.typesafe.config.Config;

/**
 * Created by thainguy on 9/21/2016.
 */
public class ConfigurationProvider {
    private Config config;

    private static ConfigurationProvider instance;

    private ConfigurationProvider(){}

    public static ConfigurationProvider Instance(){
        if(instance == null){
            instance = new ConfigurationProvider();
        }

        return instance;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public String getString(String path){
        return config.getString(path);
    }
}
