package com.bagasus.api;

import com.bagasus.service.GenericSmsService;
import com.bagasus.service.SercurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thainguy on 8/9/2016.
 */
@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private GenericSmsService smsService;

    @Autowired
    private SercurityService sercurityService;

    @RequestMapping("/test")
    public String greeting(@RequestParam(value="name")String name){
        return "hello " + name;
    }

    @RequestMapping("send")
    public String send(@RequestHeader("token") String token, @RequestParam(value="phone")String phone, @RequestParam(value="message") String message){
        if(sercurityService.verifyToken(token)){
            smsService.send(phone, message);
        }

        return phone + " - " + message;
    }

    public String configure(){
        return "OK";
    }
}
