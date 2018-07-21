package com.simplycoolest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simplycoolest.entities.UserData;
/**
 * Created by Marcin on 28.12.2017.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData save(UserData user);
    UserData findByEmailAndActive(String email, boolean active);
    UserData findByUsernameAndActive(String username, boolean active);
}