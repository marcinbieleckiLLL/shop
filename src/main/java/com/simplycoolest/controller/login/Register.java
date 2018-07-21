package com.simplycoolest.controller.login;

import com.simplycoolest.controller.abstracts.ValidationMain;
import com.simplycoolest.dte.BannerNames;
import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.dte.Views;
import com.simplycoolest.dto.ValidationView;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.error.ShouldBeAjaxSendObjectQueryException;
import com.simplycoolest.repository.UserRepository;
import com.simplycoolest.service.UserService;
import com.simplycoolest.utils.json.JsonUtils;
import com.simplycoolest.utils.validation.ValidationErrors;
import com.simplycoolest.utils.validation.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Marcin on 28.02.2018.
 */
@Controller
public class Register extends ValidationMain {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @RequestMapping(value = MappingConstants.register, method = RequestMethod.GET)
    public String goToRegisterViewByBrowser(ModelMap modelMap){
        return Views.REGISTER.getView();
    }

    @Override
    protected <T> void doActionWhenNoError(T t) {
        UserData userData = (UserData) t;
        userService.register(userData, UserRoleTypes.USER);
    }

    @Override
    protected <T> void setAdditionalAttributesToBanner(T t) {
        UserData userData = (UserData) t;
        currentModelMap.addAttribute("username", userData.getUsername());
    }
}
