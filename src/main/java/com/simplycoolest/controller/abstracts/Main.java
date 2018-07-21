package com.simplycoolest.controller.abstracts;

import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.utils.json.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;

/**
 * Created by Marcin on 23.02.2018.
 */

@Component
public abstract class Main {

    @Resource(name = "currentInfo")
    protected CurrentInfo currentInfo;

    @Autowired
    protected JsonUtils jsonUtils;

    @Getter @Setter
    protected ModelMap currentModelMap;

    protected UserData getCurrentUser(){return currentInfo.getCurrentUser();}

    protected String getCurrentUri(){return currentInfo.getRedirectUri();}
}
