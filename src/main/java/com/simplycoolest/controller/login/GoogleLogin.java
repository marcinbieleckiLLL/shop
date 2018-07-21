package com.simplycoolest.controller.login;

import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.dte.Views;
import com.simplycoolest.service.SocialMediaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Marcin on 17.02.2018.
 */
@Controller
public class GoogleLogin {

    @Autowired
    @Qualifier("googleServiceImpl")
    SocialMediaService socialMediaService;


    @RequestMapping(value = "/signin/google", method = RequestMethod.POST)
    @ResponseBody
    public String send(){
        String url = socialMediaService.createAuthorizationURL();
        System.out.println(url);
        return new JSONObject().put("url", url).toString();
    }

    @RequestMapping(value = "/google")
    public String createToken(@RequestParam("code") String code){
        socialMediaService.createAccessTokenAndUserAndLogIn(code, UserRoleTypes.GOOGLE_USER);
        return "redirect:" + MappingConstants.home;
    }
}
