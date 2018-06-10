package com.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomTags extends SimpleTagSupport {
    private String cssClass;

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public void doTag() throws JspException {

        JspWriter out = getJspContext().getOut();
        try {
            System.out.println(this.cssClass);
            out.println("<br/><h1 class="+this.cssClass+">Hai this is kalaiselvan.a created new Taglibs</h1>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
    }

}
