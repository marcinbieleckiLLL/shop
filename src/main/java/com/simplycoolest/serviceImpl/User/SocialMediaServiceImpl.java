package com.simplycoolest.serviceImpl.User;

import com.simplycoolest.entities.SocialMediaData;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.repository.SocialMediaRepository;
import com.simplycoolest.repository.UserRepository;
import com.simplycoolest.service.SocialMediaService;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Marcin on 17.01.2018.
 */
@Service
public abstract class SocialMediaServiceImpl extends UserAbstractServiceImpl implements SocialMediaService {

    @Autowired
    SocialMediaRepository socialMediaRepository;

    @Override
    protected String getPassword(UserData userData){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @LogMethodName(value = SocialMediaServiceImpl.class)
    @Override
    public void createAccessTokenAndUserAndLogIn(String code, UserRoleTypes userRoleTypes) {
        String accessToken = createAccessToken(code);
        SocialMediaData userData = createUserData(accessToken);
        logIn(userData, userRoleTypes);
    }

    public String createAuthorizationURL(){
        OAuth2Operations oauthOperations = createOperations();
        OAuth2Parameters params = createParams();

        return oauthOperations.buildAuthorizeUrl(params);
    }

    @LogMethodName(value = SocialMediaServiceImpl.class)
    private void logIn(SocialMediaData userData, UserRoleTypes userRoleTypes){
        if(!isUserCreated(userData))
            register(userData, userRoleTypes);
        else
            forceLogin(userData);
    }

    private boolean isUserCreated(SocialMediaData userData){
        return socialMediaRepository.findBySocialMediaId(userData.getSocialMediaId()) != null;
    }

    protected abstract OAuth2Operations createOperations();
    protected abstract OAuth2Parameters createParams();
    protected abstract String createAccessToken(String code);
    protected abstract SocialMediaData createUserData(String accessToken);
}
