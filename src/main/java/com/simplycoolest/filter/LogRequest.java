package com.simplycoolest.filter;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin on 05.05.2018.
 */
@Component
@Order(2)
public class LogRequest extends MainFilter{

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log(request);
    }

    private void log(HttpServletRequest request){
        logger.info("Current Uri -> " + request.getRequestURI());
        if(currentInfo.getCurrentMapping() != null)
            logger.info("Last Uri -> " + currentInfo.getCurrentMapping().name());
    }
}
