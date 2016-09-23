package com.bagasus.service;

import com.bagasus.model.SmsResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by thainguy on 9/21/2016.
 */
@Service("genericSmsServie")
public class GenericSmsService implements SmsService, SmsRegistry {

    private Dictionary<String, SmsService> smsServies = new Hashtable<>();

    @Override
    public boolean isEnable() {
        return true;
    }

    @Override
    public void setEnable(boolean isEnable) {

    }

    @Override
    public String getIdentity() {
        return "generic";
    }

    @Override
    @Async
    public SmsResult send(String number, String message) {
        SmsService service = getSmsService(number);
        return service.send(number, message);
    }

    @Override
    public void register(SmsService service) {
        smsServies.put(service.getIdentity(), service);
    }

    protected SmsService getSmsService(String phone){
        return smsServies.get("viettel");
    }
}
