package com.simplycoolest.dto;

import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.Mappings;
import com.simplycoolest.entities.UserData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Marcin on 23.02.2018.
 */
@Setter
@NoArgsConstructor
public class CurrentInfo {
    private Mappings currentMapping;
    private String redirectUri;
    @Getter private UserData currentUser;
    @Getter @Setter private boolean shouldLogout;

    public String getRedirectUri() {
        return redirectUri != null ? redirectUri : MappingConstants.defaultMapping;
    }
    public Mappings getCurrentMapping(){
        return currentMapping != null ? currentMapping : Mappings.NULL;
    }
}
