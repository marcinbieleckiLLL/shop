package com.simplycoolest.repository;

import com.simplycoolest.entities.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcin on 28.12.2017.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleData, Integer> {
    RoleData findByRole(String role);
}
