package com.simplycoolest.dte;

/**
 * Created by Marcin on 17.01.2018.
 */
public enum UserRoleTypes {
    USER(1, "USER"),
    SUPERVISOR(2, "SUPERVISOR"),
    ADMIN(3, "ADMIN"),
    FACEBOOK_USER(4, "FACEBOOK_USER"),
    GOOGLE_USER(5, "GOOGLE_USER");

    private int id;
    private String type;

    UserRoleTypes(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}