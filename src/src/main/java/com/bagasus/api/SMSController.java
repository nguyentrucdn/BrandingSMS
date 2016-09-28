package com.bagasus.api;

import com.bagasus.ConfigurationProvider;
import com.bagasus.model.RestResult;
import com.bagasus.model.external.SiteConfigurationExternal;
import com.bagasus.service.SercurityService;
import com.bagasus.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    @Qualifier("genericSmsServie")
    private SmsService smsService;

    @Autowired
    private SercurityService sercurityService;

    @RequestMapping("/test")
    public String greeting(@RequestParam(value="name")String name){
        return "hello " + name;
    }

    @RequestMapping("send")
    public RestResult send(@RequestHeader("Authentication") String token, @RequestHeader("YCAppId") String appId, @RequestParam(value="phone")String phone, @RequestParam(value="message") String message){
        int verifyToken = sercurityService.verifyToken(token, appId);
        if(verifyToken == 0){
            smsService.send(phone, message);
            return createResult(0, "");
        }
        return createResult(verifyToken, "");
    }

    @RequestMapping( value = "configure", method = RequestMethod.POST)
    public RestResult configure(@RequestHeader("Authentication") String token, @RequestHeader("YCAppId") String appId, @RequestBody SiteConfigurationExternal configuration){
        int verifyToken = sercurityService.verifyToken(token, appId);
        if(verifyToken == 0){
            ConfigurationProvider.Instance().updateConfig(configuration);
            return createResult(0, "");
        }
        return createResult(verifyToken, "");
    }

    @RequestMapping( value = "configure", method = RequestMethod.GET)
    public RestResult getConfigure(@RequestHeader("Authentication") String token, @RequestHeader("YCAppId") String appId){
        int verifyToken = sercurityService.verifyToken(token, appId);
        if(verifyToken == 0){
            return createResult(0, ConfigurationProvider.Instance().getGson().toJson(
                    ConfigurationProvider.Instance().getSiteConfiguration()));
        }
        return createResult(verifyToken, "");
    }

    private RestResult createResult(int error, String message){
        RestResult result = new RestResult();
        result.setError(error);
        result.setMessage(message);
        return result;
    }

}
