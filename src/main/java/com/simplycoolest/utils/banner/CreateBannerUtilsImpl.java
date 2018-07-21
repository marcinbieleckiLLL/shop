package com.simplycoolest.utils.banner;

import com.simplycoolest.repository.BannerRepository;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 28.02.2018.
 */
@Service
public class CreateBannerUtilsImpl implements CreateBannerUtils {

    @Autowired
    BannerRepository bannerRepository;

    @LogMethodName(value = CreateBannerUtils.class)
    public String createBannerMessage(String name) {
        return bannerRepository.findByName(name).getData();
    }
}
