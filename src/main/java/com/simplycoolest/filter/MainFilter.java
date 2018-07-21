package com.simplycoolest.filter;


import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import com.simplycoolest.dto.AvailableUri;
import com.simplycoolest.dto.CurrentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcin on 01.05.2018.
 */
public abstract class MainFilter implements Filter{

    private static final String[] SHOULD_NOT_FILTER_STARTS = {"/css", "/js", "/WEB-INF", "/images", "favicon"};
    private static final String[] SHOULD_NOT_FILTER = {"google", "facebook", "afterLogin"};
    protected static final Logger logger = LoggerFactory.getLogger(MainFilter.class);

    @Resource(name = "currentInfo")
    protected CurrentInfo currentInfo;

    protected abstract void filter(HttpServletRequest request, HttpServletResponse response) throws IOException;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse))
            return;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();

        if(!shouldNotFilterStarts(request) && !shouldNotFilter(request)){
            filter(request, response);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}

    private boolean shouldNotFilterStarts(HttpServletRequest request){
        return Arrays.stream(SHOULD_NOT_FILTER_STARTS)
                .filter(s -> request.getRequestURI().startsWith(s))
                .findAny()
                .isPresent();
    }

    private boolean shouldNotFilter(HttpServletRequest request){
        return Arrays.stream(SHOULD_NOT_FILTER)
                .filter(s -> request.getRequestURI().contains(s))
                .findAny()
                .isPresent();
    }

    protected AvailableUri createCurrentUriContainer(HttpServletRequest request){
        String currentUri = request.getRequestURI();
        RequestMethod currentMethod = getRequestMethodFromString(request);
        return new AvailableUri(currentUri, currentMethod);
    }


    private RequestMethod getRequestMethodFromString(HttpServletRequest request){
        return RequestMethod.valueOf(request.getMethod());
    }
}
