package com.simplycoolest.serviceImpl.User;

import com.simplycoolest.entities.SocialMediaData;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 18.02.2018.
 */
@Service
public class FacebookServiceImpl extends SocialMediaServiceImpl {

    @Value("${spring.social.facebook.appId}")
    String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    String facebookSecret;
    @Value("${spring.social.facebook.redirect_uri}")
    String facebookURI;

    private static final String SCOPE = "public_profile,email,user_birthday";
    private static final String [] FIELDS = { "id", "email",  "first_name", "last_name" };

    @Override
    protected OAuth2Operations createOperations() {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        return connectionFactory.getOAuthOperations();
    }

    @Override
    protected OAuth2Parameters createParams() {
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(facebookURI);
        params.setScope(SCOPE);

        return params;
    }

    @LogMethodName(value = FacebookServiceImpl.class)
    @Override
    protected String createAccessToken(String code) {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, facebookURI, null);
        return accessGrant.getAccessToken();
    }

    @LogMethodName(value = FacebookServiceImpl.class)
    @Override
    protected SocialMediaData createUserData(String accessToken) {
        Facebook facebook = new FacebookTemplate(accessToken);
        User userProfile = facebook.fetchObject("me", User.class, FIELDS);

        String name = userProfile.getFirstName() + " " + userProfile.getLastName();
        String email =  userProfile.getEmail() != null ? userProfile.getEmail():name;
        String imageUrl = userProfile.getCover() != null ? userProfile.getCover().getSource():null;

        return new SocialMediaData(email, name, userProfile.getId(), imageUrl);
    }
}
