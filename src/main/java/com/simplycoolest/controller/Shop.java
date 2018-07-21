package com.simplycoolest.controller;

import com.simplycoolest.controller.abstracts.Main;
import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.Views;
import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.utils.annotations.saveCurrentInfo.SaveCurrentUri;
import com.simplycoolest.utils.tags.NavbarTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Marcin on 17.01.2018.
 */
@Controller
public class Shop extends Main {

    @SaveCurrentUri(value = MappingConstants.shop)
    @RequestMapping(value = MappingConstants.shop)
    public String shop(){
        return Views.SHOP.getView();
    }
}
