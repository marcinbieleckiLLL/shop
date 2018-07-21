package com.simplycoolest.repository;

import com.simplycoolest.entities.SocialMediaData;
import com.simplycoolest.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 16.05.2018.
 */
@Repository("socialMediaRepository")
public interface SocialMediaRepository extends JpaRepository<SocialMediaData, Long> {
    UserData findBySocialMediaId(String id);
}
