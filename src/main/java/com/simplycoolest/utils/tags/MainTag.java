package com.simplycoolest.utils.tags;

import com.simplycoolest.dto.CurrentInfo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Marcin on 20.05.2018.
 */
public abstract class MainTag extends SimpleTagSupport {


    protected CurrentInfo currentInfo;
    protected JspWriter out;

    protected abstract void createTag() throws IOException;

    @Override
    public void doTag() throws JspException, IOException {
        initialize();
        createTag();
    }

    private void initialize() throws IOException, JspException {
        out = getJspContext().getOut();
        ServletContext sc = ((PageContext) getJspContext()).getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        currentInfo = (CurrentInfo) context.getBean("currentInfo");
    }
}
