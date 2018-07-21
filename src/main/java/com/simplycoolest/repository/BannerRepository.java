package com.simplycoolest.repository;

import com.simplycoolest.entities.BannerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 28.02.2018.
 */
@Repository("bannerRepository")
public interface BannerRepository extends JpaRepository<BannerData, Integer> {
    BannerData findByName(String name);
}
