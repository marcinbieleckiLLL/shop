package com.simplycoolest.filter;

import com.simplycoolest.dte.MappingConstants;
import com.simplycoolest.dte.Mappings;
import com.simplycoolest.dto.AvailableUri;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Marcin on 05.05.2018.
 */
@Component
@Order(3)
public class FilterRequestCorrectness extends MainFilter {

    private HttpServletRequest currentRequest;
    private Mappings lastMapping;
    private AvailableUri currentUri;

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //setData(request);
        //if(!isCorrectUri() || !isCorrectParams())
         //   sendRedirect(response);
    }

    private void setData(HttpServletRequest request){
        this.currentRequest = request;
        this.lastMapping = currentInfo.getCurrentMapping();
        this.currentUri = createCurrentUriContainer(request);
    }

    private boolean isCorrectUri(){
        return isRequestToAvaliableUri() || isRequestToTheSamePage() || isRequestToHome();
    }

    private boolean isRequestToAvaliableUri(){
        return lastMapping.getAvaliableUrisToForward().contains(currentUri);
    }

    private boolean isRequestToTheSamePage(){
        return lastMapping.getCurrentUris().contains(currentUri);
    }

    private boolean isRequestToHome(){
        return Mappings.HOME.getCurrentUris().contains(currentUri);
    }

    private boolean isCorrectParams(){
        Enumeration<String> e = currentRequest.getParameterNames();
        List<String> l = lastMapping.getAvaliableRequestParams();
        return Collections.list(e).equals(l);
    }

    private void sendRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect(MappingConstants.notCorrectUriOrParams);
    }
}
