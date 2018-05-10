package com.action;

import com.model.RoleInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TutorialsService;

public class PostTutorialsAction extends ActionSupport {
    private RoleInfo roleInfo = new RoleInfo();

    public String execute() {
        TutorialsService ts=new TutorialsService();
        if(!ts.storeRoleInfo(getRoleInfo())){
            return "failure";
        }
        return "success";
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
}
