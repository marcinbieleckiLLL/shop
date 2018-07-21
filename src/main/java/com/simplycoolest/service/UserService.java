package com.simplycoolest.service;

import com.simplycoolest.entities.UserData;
import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.utils.annotations.logging.LogMethodName;

/**
 * Created by Marcin on 15.02.2018.
 */
public interface UserService {
    void register(UserData userData, UserRoleTypes userRoleTypes);
}
