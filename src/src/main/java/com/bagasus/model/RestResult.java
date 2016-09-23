package com.bagasus.model;

import java.io.Serializable;

/**
 * Created by thainguy on 9/22/2016.
 */
public class RestResult implements Serializable{
    private int error;
    private String message;

    public RestResult(){}

    public RestResult(int error, String message){
        this.error = error;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
