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

    private Hashtable<String, SmsService> smsServies = new Hashtable<>();

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
        SmsResult result = null;
        int retryCount = 0;
        do {
            try {
                return service.send(number, message);
            } catch(Exception e){
                result = new SmsResult(400, e.getMessage());
            }
            retryCount ++;
            try {
                Thread.sleep(20 * 1000); // Sleep 20s
            } catch (InterruptedException e) {
            }
        } while (retryCount < 3);

        return result;
    }

    @Override
    public boolean isMatch(String number) {
        return false;
    }

    @Override
    public void register(SmsService service) {
        smsServies.put(service.getIdentity(), service);
    }

    protected SmsService getSmsService(String phone){
        for (SmsService service: smsServies.values()) {
            if(service.isEnable() && service.isMatch(phone)){
                return service;
            }
        }
        return smsServies.get("viettel");
    }
}
