package com.action;

import com.model.RoleInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TutorialsService;

public class GetTutorialsAction extends ActionSupport{
    private RoleInfo roleInfo = new RoleInfo();
    private String testingString;
    public String execute(){
        System.out.println("---------------------");
        System.out.println("hai hellow how are you");
        System.out.println("---------------------");
        TutorialsService ts=new TutorialsService();
        ts.getRessourceList(roleInfo);
        return "success";
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }


    public String getTestingString() {
        return testingString;
    }

    public void setTestingString(String testingString) {
        this.testingString = testingString;
    }
}
