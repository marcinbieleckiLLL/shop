package com.simplycoolest.serviceImpl.User;

import com.simplycoolest.entities.SocialMediaData;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.repository.UserRepository;
import com.simplycoolest.service.NonSocialMediaService;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Marcin on 28.12.2017.
 */
@Service("userServiceImpl")
public class UserServiceImpl extends UserAbstractServiceImpl implements NonSocialMediaService {

    @Autowired
    UserRepository userRepository;

    @Override
    protected String getPassword(UserData userData) {
        return userData.getPassword();
    }

    @LogMethodName(value = UserServiceImpl.class)
    @Override
    public boolean isUserExist(UserData userData) {
        return userRepository.findByEmailAndActive(userData.getEmail(), true) != null;
    }

    @LogMethodName(value = UserServiceImpl.class)
    @Override
    public UserData getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmailAndActive((String) auth.getPrincipal(), true);
    }

    @Override
    public void logout(HttpServletRequest request) {
        new SecurityContextLogoutHandler().logout(request, null, null);
    }
}
