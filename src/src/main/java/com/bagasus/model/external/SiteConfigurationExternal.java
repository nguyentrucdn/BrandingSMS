
package com.bagasus.model.external;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiteConfigurationExternal {

    private Boolean enableVietel;
    private Boolean enableVina;
    private Boolean enableMobile;
    private String verifyTokenPath;
    private String logPath;
    private Integer roleToBeVerified;
    private VietelConfig vietelConfig;
    private VnptConfig vnptConfig;
    private List<String> vnptHeadNumbers = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The enableVietel
     */
    public Boolean getEnableVietel() {
        return enableVietel;
    }

    /**
     * 
     * @param enableVietel
     *     The enableVietel
     */
    public void setEnableVietel(Boolean enableVietel) {
        this.enableVietel = enableVietel;
    }

    /**
     * 
     * @return
     *     The enableVina
     */
    public Boolean getEnableVina() {
        return enableVina;
    }

    /**
     * 
     * @param enableVina
     *     The enableVina
     */
    public void setEnableVina(Boolean enableVina) {
        this.enableVina = enableVina;
    }

    /**
     * 
     * @return
     *     The enableMobile
     */
    public Boolean getEnableMobile() {
        return enableMobile;
    }

    /**
     * 
     * @param enableMobile
     *     The enableMobile
     */
    public void setEnableMobile(Boolean enableMobile) {
        this.enableMobile = enableMobile;
    }

    /**
     * 
     * @return
     *     The verifyTokenPath
     */
    public String getVerifyTokenPath() {
        return verifyTokenPath;
    }

    /**
     * 
     * @param verifyTokenPath
     *     The verifyTokenPath
     */
    public void setVerifyTokenPath(String verifyTokenPath) {
        this.verifyTokenPath = verifyTokenPath;
    }

    /**
     * 
     * @return
     *     The logPath
     */
    public String getLogPath() {
        return logPath;
    }

    /**
     * 
     * @param logPath
     *     The logPath
     */
    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    /**
     * 
     * @return
     *     The roleToBeVerified
     */
    public Integer getRoleToBeVerified() {
        return roleToBeVerified;
    }

    /**
     * 
     * @param roleToBeVerified
     *     The roleToBeVerified
     */
    public void setRoleToBeVerified(Integer roleToBeVerified) {
        this.roleToBeVerified = roleToBeVerified;
    }

    /**
     * 
     * @return
     *     The vietelConfig
     */
    public VietelConfig getVietelConfig() {
        return vietelConfig;
    }

    /**
     * 
     * @param vietelConfig
     *     The vietelConfig
     */
    public void setVietelConfig(VietelConfig vietelConfig) {
        this.vietelConfig = vietelConfig;
    }

    /**
     * 
     * @return
     *     The vnptConfig
     */
    public VnptConfig getVnptConfig() {
        return vnptConfig;
    }

    /**
     * 
     * @param vnptConfig
     *     The vnptConfig
     */
    public void setVnptConfig(VnptConfig vnptConfig) {
        this.vnptConfig = vnptConfig;
    }

    /**
     * 
     * @return
     *     The vnptHeadNumbers
     */
    public List<String> getVnptHeadNumbers() {
        return vnptHeadNumbers;
    }

    /**
     * 
     * @param vnptHeadNumbers
     *     The vnptHeadNumbers
     */
    public void setVnptHeadNumbers(List<String> vnptHeadNumbers) {
        this.vnptHeadNumbers = vnptHeadNumbers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
