package com.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Cust extends SimpleTagSupport{
    private String subrespermission;
    private String cssClass;

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getSubrespermission() {
        return subrespermission;
    }

    public void setSubrespermission(String subrespermission) {
        this.subrespermission = subrespermission;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        try {
            System.out.println(this.subrespermission);
            if(this.subrespermission==null){
                out.write("");
            }else{
                if(this.subrespermission!=null){
                    int val=Integer.parseInt(this.subrespermission);
                    if(val==1){
                        out.println("<br/><h1 disabled='true' class="+this.cssClass+">Hai this is kalaiselvan.a created new Taglibs</h1>");
                    }else{
                        out.println("<br/><h1 class="+this.cssClass+">Hai this is kalaiselvan.a created new Taglibs</h1>");
                    }
                }
            }

        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
    }
}
