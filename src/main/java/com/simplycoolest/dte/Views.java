package com.simplycoolest.dte;

/**
 * Created by Marcin on 14.01.2018.
 */
public enum Views {
    HOME("home"),
    LOGIN("login"),
    REGISTER("register"),
    BANNER("banner"),
    SHOP("shop"),
    ERROR("error");

    private String view;

    Views(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
