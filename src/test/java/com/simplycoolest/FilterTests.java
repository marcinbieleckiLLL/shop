package com.simplycoolest;

import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.filter.MainFilter;
import com.simplycoolest.service.NonSocialMediaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Marcin on 10.06.2018.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class FilterTests extends ShopApplicationTests{

    @Mock
    CurrentInfo currentInfo;

    @Mock
    @Qualifier("userServiceImpl")
    NonSocialMediaService nonSocialMediaService;

    @Before
    public void setupSecurity(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .defaultRequest(get("/home").with(user("user").roles("ADMIN")))
                .apply(springSecurity()).build();
    }

    @Test
    public void mainFilterTest() throws Exception {
        //mock
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        MainFilter filter = mock(MainFilter.class);
        //set values
        when(currentInfo.isShouldLogout()).thenReturn(Boolean.TRUE);
        when(httpServletRequest.getRequestURI()).thenReturn("/home");
        //run
        filter.doFilter(httpServletRequest, httpServletResponse, filterChain);
        //verify
        verify(nonSocialMediaService).logout(httpServletRequest);
    }

    /*this.mockMvc.perform(get(MappingConstants.home))
                .andDo(print())
                .andExpect(view().name(Views.HOME.getView()));*/
}
