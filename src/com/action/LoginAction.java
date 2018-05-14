package com.action;

import com.model.LogIn;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

public class LoginAction extends ActionSupport implements ModelDriven<LogIn> {
    private LogIn login = new LogIn();

    @Override
    public void validate() {
        if (StringUtils.isEmpty(getLogin().getUserId())) {
            addFieldError("userId", "Please Enter UserId");

        }
        if (StringUtils.isEmpty(getLogin().getPassword())) {
            addFieldError("password", "Please Enter password");
        }
    }

    public String execute() {
        if (getLogin().getUserId().equals("kalai") && getLogin().getPassword().equals("kalai")) {
            return "success";
        }
        return "failure";

    }

    public LogIn getLogin() {
        return login;
    }

    public void setLogin(LogIn login) {
        this.login = login;
    }

    @Override
    public LogIn getModel() {
        return login;
    }
}
