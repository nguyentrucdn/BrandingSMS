package com.bagasus.service;

import com.bagasus.ConfigurationProvider;
import com.bagasus.model.RestResult;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by thainguy on 9/21/2016.
 */
@Service
public class SercurityService {

    public boolean verifyToken(String token){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token", token);
        headers.add("appId", ConfigurationProvider.Instance().getSiteConfiguration().getAppId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("role", ConfigurationProvider.Instance().getSiteConfiguration().getRoleToBeVerified());

        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toJSONString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestResult> result = restTemplate.exchange(ConfigurationProvider.Instance().getSiteConfiguration().getVerifyTokenPath(), HttpMethod.POST, entity, RestResult.class);
        return result.getBody().getError() == 0;
    }
}
