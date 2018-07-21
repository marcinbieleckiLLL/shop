package com.simplycoolest.serviceImpl.User;

import com.simplycoolest.entities.RoleData;
import com.simplycoolest.entities.UserData;
import com.simplycoolest.dte.UserRoleTypes;
import com.simplycoolest.repository.RoleRepository;
import com.simplycoolest.repository.UserRepository;
import com.simplycoolest.service.NonSocialMediaService;
import com.simplycoolest.service.UserService;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Marcin on 21.01.2018.
 */
public abstract class UserAbstractServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @LogMethodName(value = UserAbstractServiceImpl.class)
    public void register(UserData userData, UserRoleTypes userRoleTypes){
        userData = createAndSetPassword(userData);
        userData = createAndSetRole(userData, userRoleTypes);
        saveUser(userData);
        forceLogin(userData);
    };

    private UserData createAndSetPassword(UserData userData){
        String password = getPassword(userData);
        password = encodePassword(password);
        userData.setPassword(password);

        return userData;
    }

    private UserData createAndSetRole(UserData userData, UserRoleTypes userRoleTypes){
        userData.setActive(true);
        RoleData userRole = roleRepository.findByRole(userRoleTypes.getType());
        userData.setRoles(new HashSet<RoleData>(Arrays.asList(userRole)));

        return userData;
    }

    @LogMethodName(value = UserAbstractServiceImpl.class)
    private void saveUser(UserData userData){
        userRepository.save(userData);
    }

    @LogMethodName(value = UserAbstractServiceImpl.class)
    protected void forceLogin(UserData userData){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(UserRoleTypes.USER.getType()));
        Authentication auth = new UsernamePasswordAuthenticationToken(userData.getEmail(), userData.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    protected abstract String getPassword(UserData userData);
}


