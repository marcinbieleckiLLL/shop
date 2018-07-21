package com.simplycoolest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Marcin on 16.05.2018.
 */
@Entity(name = "social_media")
@DiscriminatorValue("2")
@Getter
@NoArgsConstructor
public class SocialMediaData extends UserData {

    @Column(name="social_media_id")
    private String socialMediaId;

    @Column(name="user_image_url")
    private String imageUrl;

    public SocialMediaData(String email, String username, String socialMediaId, String imageUrl) {
        this.email = email;
        this.username = username;
        this.socialMediaId = socialMediaId;
        this.imageUrl = imageUrl;
    }
}
