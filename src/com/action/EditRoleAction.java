package com.action;

import com.model.RoleInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TutorialsService;

public class EditRoleAction extends ActionSupport implements ModelDriven<RoleInfo>{
    private RoleInfo roleInfo = new RoleInfo();
    private String key;
    private String testingString;
    public String execute(){
       TutorialsService ts=new TutorialsService();
        ts.getRessourceList(roleInfo,key);
        return "success";
    }

    @Override
    public RoleInfo getModel() {
        return roleInfo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
