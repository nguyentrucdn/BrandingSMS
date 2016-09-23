package com.bagasus.api;

import com.bagasus.ConfigurationProvider;
import com.bagasus.model.RestResult;
import com.bagasus.model.SiteConfiguration;
import com.bagasus.service.GenericSmsService;
import com.bagasus.service.SercurityService;
import com.bagasus.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thainguy on 8/9/2016.
 */
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
    public RestResult send(@RequestHeader("token") String token, @RequestParam(value="phone")String phone, @RequestParam(value="message") String message){
        if(sercurityService.verifyToken(token)){
            smsService.send(phone, message);
        }

        return new RestResult(0, "OK");
    }

    @RequestMapping( value = "configure", method = RequestMethod.POST)
    public RestResult configure(@RequestBody SiteConfiguration configuration){
        ConfigurationProvider.Instance().setSiteConfiguration(configuration);
        return new RestResult(0, "OK");
    }

    @RequestMapping( value = "configure", method = RequestMethod.GET)
    public SiteConfiguration getConfigure(){
        return ConfigurationProvider.Instance().getSiteConfiguration();
    }

}
