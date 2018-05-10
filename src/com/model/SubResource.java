package com.model;


public class SubResource {

   private int enum_val;
   private String resourcename;
   private boolean isRead;
   private boolean isUpdate;
   private boolean isDirty;

    public int getEnum_val() {
        return enum_val;
    }

    public void setEnum_val(int enum_val) {
        this.enum_val = enum_val;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }
}
