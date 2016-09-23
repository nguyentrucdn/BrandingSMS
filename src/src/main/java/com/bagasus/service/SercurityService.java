package com.bagasus.service;

import com.bagasus.ConfigurationProvider;
import com.bagasus.model.RestResult;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by thainguy on 9/21/2016.
 */
@Service
public class SercurityService {

    private String verifyTokenURL;
    private String role;
    private String appId;

    public boolean verifyToken(String token){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token", token);
        headers.add("appId", appId);

        HttpEntity<String> entity = new HttpEntity<String>("{\"role\":33554432}", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RestResult> result = restTemplate.exchange(verifyTokenURL, HttpMethod.POST, entity, RestResult.class);
        return result.getBody().getError() == 0;
    }

    @PostConstruct
    public void initialize(){
        this.verifyTokenURL = ConfigurationProvider.Instance().getString("bagasus.token_path");
        this.role = ConfigurationProvider.Instance().getString("bagasus.role");
        this.appId = ConfigurationProvider.Instance().getString("bagasus.app_id");
    }
}
