package com.simplycoolest.dte;

/**
 * Created by Marcin on 28.02.2018.
 */
public enum BannerNames {
    AFTER_LOGIN("afterLogin"),
    AFTER_REGISTRATION("afterRegistration");

    private String name;

    BannerNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
