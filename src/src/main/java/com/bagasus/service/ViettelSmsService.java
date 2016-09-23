package com.bagasus.service;

import com.bagasus.ConfigurationProvider;
import com.bagasus.model.SmsResult;
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
    private String command;
    private String[] header;

    @Autowired
    private SmsRegistry smsRegistry;

    @Override
    public boolean isEnable() {
        return ConfigurationProvider.Instance().getSiteConfiguration().isEnableVietel();
    }

    @Override
    public void setEnable(boolean isEnable) {
    }

    @Override
    public String getIdentity() {
        return "viettel";
    }

    @Override
    public SmsResult send(String number, String message) {
        CcApi_Service serviceApi = new CcApi_Service();
        CcApi api = serviceApi.getCcApiPort();
        Result result = api.wsCpMt(user, pass, cpc, "1", "84976969454", number, brand, command, message, "0");
        return new SmsResult(result.getResult(), result.getMessage());
    }

    @Override
    public boolean isMatch(String number) {
        String stdNumber = number;
        if(stdNumber.startsWith("84")){
            stdNumber.replaceFirst("84", "0");
        }
        if(stdNumber.startsWith("+84")){
            stdNumber.replace("+84", "0");
        }
        for (String head: header) {
            if(stdNumber.startsWith(head)){
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void initialize(){
        this.user = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.user");
        this.pass = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.pass");
        this.cpc = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.cpc");
        this.brand = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.brand");
        this.command = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.command");
        this.header = ConfigurationProvider.Instance().getString("bagasus.sms.viettel.header").split(",");

        smsRegistry.register(this);
    }
}
