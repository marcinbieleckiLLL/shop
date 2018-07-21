package com.simplycoolest.service;

import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.utils.annotations.logging.LogMethodName;

/**
 * Created by Marcin on 18.02.2018.
 */
public interface SocialMediaService {
    String createAuthorizationURL();
    void createAccessTokenAndUserAndLogIn(String code, UserRoleTypes userRoleTypes);
}
