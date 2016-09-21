package com.bagasus.service;

import java.io.Serializable;

/**
 * Created by thainguy on 9/21/2016.
 */
public class SmsResult implements Serializable{
    protected String message;
    protected Long result;

    public SmsResult(){}

    public SmsResult(long result, String message){
        this.result = result;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
