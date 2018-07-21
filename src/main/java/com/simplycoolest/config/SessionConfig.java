package com.simplycoolest.config;

import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.filter.MainFilter;
import com.simplycoolest.service.NonSocialMediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;

/**
 * Created by Marcin on 10.06.2018.
 */
@Configuration
@ComponentScan(value = "com.simplycoolest")
public class SessionConfig {

    private static final Logger logger = LoggerFactory.getLogger(SessionConfig.class);

    @Value("${server.session.timeout}")
    static String sessionTimeoutInSeconds;

    @Autowired
    CurrentInfo currentInfo;

    public static class NoRedirectSavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws ServletException, IOException {
            request.getSession().setMaxInactiveInterval(Integer.parseInt(sessionTimeoutInSeconds));
        }
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent se) {
                logger.info("Session Created with session id+" + se.getSession().getId());
            }
            @Override
            public void sessionDestroyed(HttpSessionEvent se) {
                currentInfo.setShouldLogout(true);
                logger.info("Session Destroyed, Session id:" + se.getSession().getId());
            }
        };
    }
}
