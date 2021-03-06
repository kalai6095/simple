package com.model;

import java.util.List;
import java.util.Set;

public class RoleInfo {
    private Integer pkid;
    private String application;
    private String name;
    private String description;
    private String resourceWebPage;
    private int showPermission;
    private List<SubResource> subResources;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceWebPage() {
        return resourceWebPage;
    }

    public void setResourceWebPage(String resourceWebPage) {
        this.resourceWebPage = resourceWebPage;
    }

    public int getShowPermission() {
        return showPermission;
    }

    public void setShowPermission(int showPermission) {
        this.showPermission = showPermission;
    }

    public List<SubResource> getSubResources() {
        return subResources;
    }

    public void setSubResources(List<SubResource> subResources) {
        this.subResources = subResources;
    }
}
