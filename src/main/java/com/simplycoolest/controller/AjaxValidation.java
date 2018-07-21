package com.simplycoolest.controller;

import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.error.ShouldBeAjaxSendObjectQueryException;
import com.simplycoolest.repository.UserRepository;
import com.simplycoolest.utils.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Marcin on 16.07.2018.
 */
@Controller
public class AjaxValidation {

    private static final String FIRST = "first";
    private static final String SECOND = "second";

    @Autowired
    UserRepository userRepository;

    @Autowired
    JsonUtils jsonUtils;

    @RequestMapping(value = MappingConstants.registerValidateUsername, method = RequestMethod.POST)
    @ResponseBody
    public boolean usernameValidation(@RequestBody String jsonData) throws ShouldBeAjaxSendObjectQueryException {
        String username = jsonUtils.getParamsFromAjax(jsonData).get(FIRST);
        return userRepository.findByUsernameAndActive(username, true) != null;
    }

    @RequestMapping(value = MappingConstants.registerValidateEmail, method = RequestMethod.POST)
    @ResponseBody
    public boolean emailValidation(@RequestBody String jsonData) throws ShouldBeAjaxSendObjectQueryException {
        String email = jsonUtils.getParamsFromAjax(jsonData).get(FIRST);
        return userRepository.findByEmailAndActive(email, true) != null;
    }
}
