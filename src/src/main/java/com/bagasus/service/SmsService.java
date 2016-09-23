package com.bagasus.service;

import com.bagasus.model.SmsResult;

/**
 * Created by thainguy on 9/21/2016.
 */
public interface SmsService {
    boolean isEnable();
    void setEnable(boolean isEnable);
    String getIdentity();
    SmsResult send(String number, String message);
    boolean isMatch(String number);
}
