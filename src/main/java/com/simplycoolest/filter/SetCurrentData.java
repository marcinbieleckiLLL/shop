package com.simplycoolest.filter;

import com.simplycoolest.dte.Mappings;
import com.simplycoolest.service.NonSocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin on 05.05.2018.
 */
@Component
@Order(4)
public class SetCurrentData extends MainFilter {

    @Autowired
    NonSocialMediaService nonSocialMediaService;

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(currentInfo.getCurrentUser() == null) {
            currentInfo.setCurrentUser(nonSocialMediaService.getCurrentUser());
        }
        //currentInfo.setCurrentMapping(Mappings.getMappingByUri(createCurrentUriContainer(request)));
    }
}
