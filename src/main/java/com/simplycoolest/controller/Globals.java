package com.simplycoolest.controller;

import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.Views;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcin on 05.05.2018.
 */
public class Globals {

    @LogMethodName(value = Globals.class)
    @RequestMapping(value = MappingConstants.notCorrectUriOrParams, method = RequestMethod.GET)
    public String notCorrectUriOrParams(){
        return Views.ERROR.getView();
    }
}
