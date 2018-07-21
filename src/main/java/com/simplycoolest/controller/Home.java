package com.simplycoolest.controller;

import com.simplycoolest.controller.abstracts.Main;
import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.Views;
import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import com.simplycoolest.utils.annotations.saveCurrentInfo.SaveCurrentUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Marcin on 23.12.2017.
 */
@Controller
@Component
public class Home extends Main {

    @LogMethodName(value = Home.class)
    @SaveCurrentUri(value = MappingConstants.home)
    @RequestMapping(value = {MappingConstants.defaultMapping, MappingConstants.home})
    public String main(){
        return Views.HOME.getView();
    }
}
