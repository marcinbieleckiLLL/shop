package com.simplycoolest.controller.login;

import com.simplycoolest.controller.abstracts.BannerMain;
import com.simplycoolest.dte.BannerNames;
import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.dte.Views;
import com.simplycoolest.service.SocialMediaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by Marcin on 17.02.2018.
 */
@Controller
public class FacebookLogin extends BannerMain {

    @Autowired
    @Qualifier("facebookServiceImpl")
    SocialMediaService socialMediaService;

    @RequestMapping(value = MappingConstants.facebookSingin, method = RequestMethod.POST)
    @ResponseBody
    public String send(){
        String url = socialMediaService.createAuthorizationURL();
        return new JSONObject().put("url", url).toString();
    }

    @RequestMapping(value = MappingConstants.facebook, method = RequestMethod.GET)
    public String createUserAndLogIn(@RequestParam("code") String code){
        socialMediaService.createAccessTokenAndUserAndLogIn(code, UserRoleTypes.FACEBOOK_USER);
        return "redirect:/afterLogin";
    }

    @RequestMapping(value = "/afterLogin", method = RequestMethod.GET)
    public String afterLogin(ModelMap modelMap, Principal principal){
        setCurrentModelMap(modelMap);
        setAttributesToBanner(BannerNames.AFTER_LOGIN.getName(), principal);
        return Views.BANNER.getView();
    }

    @Override
    protected <T> void setAdditionalAttributesToBanner(T t) {
        Principal principal = (Principal) t;
        currentModelMap.addAttribute("username", principal.getName());
    }
}
