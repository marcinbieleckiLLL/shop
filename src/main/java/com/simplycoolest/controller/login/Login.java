package com.simplycoolest.controller.login;

import com.simplycoolest.controller.abstracts.ValidationMain;
import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.Views;
import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.utils.validation.ValidationErrors;
import com.simplycoolest.utils.validation.ValidationUtilsPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * Created by Marcin on 26.12.2017.
 */
@Controller
public class Login extends ValidationMain {

    @Autowired
    @Qualifier("userValidationImpl")
    ValidationUtilsPresent validationUtilsPresent;

    @RequestMapping(value = MappingConstants.login, method = RequestMethod.GET)
    public String goToLoginView(ModelMap modelMap){
        modelMap.addAttribute("user", new UserData());
        return Views.LOGIN.getView();
    }

    @RequestMapping(value = MappingConstants.login, method = RequestMethod.POST)
    public String login(@RequestParam("g-recaptcha-response") String captchaResponse,
                        @ModelAttribute("user")UserData userData, ModelMap modelMap){
        setCurrentModelMap(modelMap);
        ValidationErrors error = validationUtilsPresent.validateAlreadyPresent(userData);
        /*return handleErrorsChecking(new ValidationView(errorsList, Views.LOGIN, Views.BANNER,
                BannerNames.AFTER_LOGIN), userData);*/
        return null;
    }

    @Override
    protected <T> void setAdditionalAttributesToBanner(T t) {
        Principal principal = (Principal) t;
        currentModelMap.addAttribute("username", principal.getName());
    }

    @Override
    protected <T> void doActionWhenNoError(T t) {}
}

