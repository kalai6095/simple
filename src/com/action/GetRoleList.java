package com.action;

import com.model.RoleInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.TutorialsService;

import java.util.ArrayList;
import java.util.List;

public class GetRoleList extends ActionSupport implements ModelDriven<List<RoleInfo>> {

    private List<RoleInfo> roleInfolist=new ArrayList<>();
    public String execute(){
        TutorialsService ts=new TutorialsService();
        ts.getRoleList(roleInfolist);
        return "success";
    }

    public List<RoleInfo> getRoleInfolist() {
        return roleInfolist;
    }

    public void setRoleInfolist(List<RoleInfo> roleInfolist) {
        this.roleInfolist = roleInfolist;
    }

    @Override
    public List<RoleInfo> getModel() {
        return roleInfolist;
    }
}
