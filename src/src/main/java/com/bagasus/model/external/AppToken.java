
package com.bagasus.model.external;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AppToken {

    @SerializedName("token")
    @Expose
    private Token token;
    @SerializedName("appName")
    @Expose
    private String appName;

    /**
     * 
     * @return
     *     The token
     */
    public Token getToken() {
        return token;
    }

    /**
     * 
     * @param token
     *     The token
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * 
     * @return
     *     The appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 
     * @param appName
     *     The appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

}
