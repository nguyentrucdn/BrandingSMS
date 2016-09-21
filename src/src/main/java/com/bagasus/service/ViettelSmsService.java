package com.bagasus.service;

import com.bagasus.ConfigurationProvider;
import com.bagasus.sms.viettel.CcApi;
import com.bagasus.sms.viettel.CcApi_Service;
import com.bagasus.sms.viettel.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by thainguy on 9/21/2016.
 */
@Service
public class ViettelSmsService implements SmsService {

    private String user;
    private String pass;
    private String cpc;
    private String brand;
    private boolean isEnable;

    @Autowired
    private SmsRegistry smsRegistry;

    @Override
    public boolean isEnable() {
        return isEnable;
    }

    @Override
    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String getIdentity() {
        return "viettel";
    }

    @Override
    public SmsResult send(String number, String message) {
        CcApi_Service serviceApi = new CcApi_Service();
        CcApi api = serviceApi.getCcApiPort();
        Result result = api.wsCpMt(user, pass, cpc, "1", "84976969454", number, brand, "bulksms", message, "0");
        return new SmsResult(result.getResult(), result.getMessage());
    }

    @PostConstruct
    public void initialize(){
        this.user = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.user");
        this.pass = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.pass");
        this.cpc = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.cpc");
        this.brand = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.brand");
        this.isEnable = "true".equals(ConfigurationProvider.Instance().getString("bagasus.sms.viettel.enable"));

        smsRegistry.register(this);
    }
}
