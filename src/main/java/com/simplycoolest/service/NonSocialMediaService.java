package com.simplycoolest.service;

import com.simplycoolest.entities.UserData;
import com.simplycoolest.utils.annotations.logging.LogMethodName;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Marcin on 01.05.2018.
 */
public interface NonSocialMediaService {
    boolean isUserExist(UserData userData);
    UserData getCurrentUser();
    void logout(HttpServletRequest request);
}
