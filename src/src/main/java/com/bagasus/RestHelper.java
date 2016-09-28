package com.bagasus;

import com.bagasus.model.RestResult;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by thainguy on 9/28/2016.
 */
public class RestHelper {

    private static HttpHeaders buildHeader(String token, String appName){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authentication", token);
        headers.add("YCAppId", appName);

        return headers;
    }

    private static RestTemplate buildRestTemplate(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        return restTemplate;
    }

    public static RestResult getSiteConfig(String url, String token, String appName){
        HttpHeaders headers = buildHeader(token, appName);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        RestTemplate restTemplate = buildRestTemplate();
        ResponseEntity<RestResult> restResultExternal = restTemplate.exchange(url, HttpMethod.POST, entity, RestResult.class);
        return restResultExternal.getBody();
    }

    public static RestResult verifyToken(String url, String token, String appName, long role){
        HttpHeaders headers = buildHeader(token, appName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("role", role);

        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toJSONString(), headers);
        RestTemplate restTemplate = buildRestTemplate();
        ResponseEntity<RestResult> result = restTemplate.exchange(url, HttpMethod.POST, entity, RestResult.class);
        return result.getBody();
    }

    public static RestResult login(String url, String userName, String pass){
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("clientName", userName);
        map.add("secret", pass);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, requestHeaders);

        RestTemplate restTemplate = buildRestTemplate();
        RestResult restResult = restTemplate.postForObject(url, requestEntity, RestResult.class);
        return restResult;
    }
}
