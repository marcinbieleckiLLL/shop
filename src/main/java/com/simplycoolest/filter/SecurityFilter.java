package com.simplycoolest.filter;

import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.error.NotRegisteredUserChangeException;
import com.simplycoolest.service.NonSocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin on 10.06.2018.
 */
@Component
@Order(1)
public class SecurityFilter extends MainFilter{

    @Autowired
    CurrentInfo currentInfo;

    @Qualifier("userServiceImpl")
    NonSocialMediaService nonSocialMediaService;

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(currentInfo != null && currentInfo.isShouldLogout()){
            if(nonSocialMediaService != null){
                nonSocialMediaService.logout(request);
            }
        }
        /*if(currentInfo.getCurrentUser() != null && currentInfo.getCurrentUser().equals(nonSocialMediaService.getCurrentUser())){
            throw new NotRegisteredUserChangeException();
        }*/
    }
}
