
package com.bagasus.model.external;

import java.util.HashMap;
import java.util.Map;

public class VietelConfig {

    private String userName;
    private String passWord;
    private String cpCode;
    private String brandName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     *     The userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return
     *     The passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 
     * @param passWord
     *     The passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 
     * @return
     *     The cpCode
     */
    public String getCpCode() {
        return cpCode;
    }

    /**
     * 
     * @param cpCode
     *     The cpCode
     */
    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    /**
     * 
     * @return
     *     The brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 
     * @param brandName
     *     The brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
