package com.simplycoolest.serviceImpl.User;

import com.simplycoolest.entities.SocialMediaData;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 06.05.2018.
 */
@Service
public class GoogleServiceImpl extends SocialMediaServiceImpl {

    @Value("${spring.social.google.id}")
    String googleAppId;
    @Value("${spring.social.google.secret}")
    String googleSecret;
    @Value("${spring.social.google.redirect_uri}")
    String googleURI;
    @Value("${spring.social.google.scope}")
    String scope;

    @Override
    protected OAuth2Operations createOperations() {
        GoogleConnectionFactory connectionFactory = new GoogleConnectionFactory(googleAppId, googleSecret);
        return connectionFactory.getOAuthOperations();
    }

    @Override
    protected OAuth2Parameters createParams() {
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(googleURI);
        params.setScope(scope);
        params.set("prompt", "select_account");
        return params;
    }

    @LogMethodName(value = GoogleServiceImpl.class)
    @Override
    protected String createAccessToken(String code) {
        AccessGrant accessGrant = createOperations().exchangeForAccess(code, googleURI, null);
        return accessGrant.getAccessToken();
    }

    @LogMethodName(value = GoogleServiceImpl.class)
    @Override
    protected SocialMediaData createUserData(String accessToken) {
        Google google = new GoogleTemplate(accessToken);
        Person profile = google.plusOperations().getGoogleProfile();

        String name = profile.getDisplayName();
        String email =  profile.getAccountEmail() != null ? profile.getAccountEmail():name;

        return new SocialMediaData(email, name, profile.getId(), profile.getImageUrl());
    }
}
