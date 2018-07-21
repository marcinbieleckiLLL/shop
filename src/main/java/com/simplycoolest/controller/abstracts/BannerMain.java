package com.simplycoolest.controller.abstracts;

import com.simplycoolest.utils.banner.CreateBannerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Marcin on 28.02.2018.
 */
@Component
public abstract class BannerMain extends Main{

    @Autowired
    CreateBannerUtils createBannerUtils;

    protected <T extends Object> void setAttributesToBanner(String name, T t) {
        currentModelMap.addAttribute("message", createBannerUtils.createBannerMessage(name));
        currentModelMap.addAttribute("url", getCurrentUri());
        setAdditionalAttributesToBanner(t);
    }

    protected abstract <T extends Object> void setAdditionalAttributesToBanner(T t);
}
