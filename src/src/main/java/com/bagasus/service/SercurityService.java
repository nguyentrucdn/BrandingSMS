package com.bagasus.service;

import com.bagasus.ConfigurationProvider;
import com.bagasus.RestHelper;
import com.bagasus.model.RestResult;
import com.bagasus.model.SiteConfiguration;
import org.springframework.stereotype.Service;

@Service
public class SercurityService {

    public int verifyToken(String token, String appId) {
        SiteConfiguration siteConfiguration = ConfigurationProvider.Instance().getSiteConfiguration();
        RestResult restResult
                = RestHelper.verifyToken(siteConfiguration.getVerifyTokenPath(), token, appId, siteConfiguration.getRoleToBeVerified());
        return restResult.getError();
    }
}
