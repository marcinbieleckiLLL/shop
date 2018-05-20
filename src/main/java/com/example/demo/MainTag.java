package com.example.demo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Marcin on 20.05.2018.
 */
public abstract class MainTag extends SimpleTagSupport {


    protected JspWriter out;

    protected abstract void createTag() throws IOException;

    @Override
    public void doTag() throws JspException, IOException {
        initialize();
        createTag();
    }

    private void initialize() throws IOException, JspException {
        out = getJspContext().getOut();
    }
}
