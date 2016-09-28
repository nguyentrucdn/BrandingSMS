
package com.bagasus.model;

import java.util.HashMap;
import java.util.Map;

public class RestResult {

    private Integer error;
    private Integer subError;
    private String message;
    private String kind;
    private String etag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The error
     */
    public Integer getError() {
        return error;
    }

    /**
     * 
     * @param error
     *     The error
     */
    public void setError(Integer error) {
        this.error = error;
    }

    /**
     * 
     * @return
     *     The subError
     */
    public Integer getSubError() {
        return subError;
    }

    /**
     * 
     * @param subError
     *     The subError
     */
    public void setSubError(Integer subError) {
        this.subError = subError;
    }

    /**
     * 
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 
     * @param kind
     *     The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 
     * @return
     *     The etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * 
     * @param etag
     *     The etag
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
