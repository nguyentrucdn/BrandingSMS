package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thainguy on 8/9/2016.
 */
@RestController
@RequestMapping("/sms")
public class SMSController {

    @RequestMapping("/test")
    public String greeting(@RequestParam(value="name")String name){
        return "hello " + name;
    }

    @RequestMapping("send")
    public String send(@RequestParam(value="phone")String phone, @RequestParam(value="message") String message){
        return phone + " - " + message;
    }
}
