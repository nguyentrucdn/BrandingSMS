package com.bagasus.service;

import com.bagasus.ConfigurationProvider;
import com.bagasus.model.SmsResult;
import com.bagasus.model.ViettelConfig;
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

    private String command = "bulksms";

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
        ViettelConfig config = ConfigurationProvider.Instance().getSiteConfiguration().getViettelConfig();
        CcApi_Service serviceApi = new CcApi_Service();
        CcApi api = serviceApi.getCcApiPort();
        Result result = api.wsCpMt(config.getUser(), config.getPass(), config.getCpc(), "1", "84976969454", number, config.getBrand(), command, message, "0");
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
        String[] header = ConfigurationProvider.Instance().getSiteConfiguration().getViettelConfig().getHeader();
        for (String head: header) {
            if(stdNumber.startsWith(head)){
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void initialize(){
        smsRegistry.register(this);
    }
}
