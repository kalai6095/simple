package com.service;

//import com.common.Testing;
import com.dbconnection.DbConnection;
import com.model.RoleInfo;
import com.model.SubResource;

import java.sql.*;
import java.util.*;

public class TutorialsService {


    public String getTutorials() {
        return "kalaiselvan.info";
    }

    public boolean storeRoleInfo(RoleInfo roleInfo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            DbConnection db = new DbConnection();
            conn = db.connect();
            //Testing t = new Testing();
            //t.getStrings();
            sql = "INSERT INTO role(`application`,`name`, `description`,`webpage`)VALUES(?,?,?,?);";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, roleInfo.getApplication());
            pstmt.setString(2, roleInfo.getName());
            pstmt.setString(3, roleInfo.getDescription());
            pstmt.setString(4, roleInfo.getResourceWebPage());
            pstmt.execute();
            rs = pstmt.getGeneratedKeys();
            int pk = 0;
            if (rs.next()) {
                pk = rs.getInt(1);
            }
            rs.close();
            pstmt.close();

            Iterator<SubResource> itr = roleInfo.getSubResources().iterator();
            while (itr.hasNext()) {
                System.out.println("hai");
                sql = "INSERT INTO resource(resourcename,isRead,isUpdate,roleId)VALUES(?,?,?,?);";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, itr.next().getResourcename());
                pstmt.setBoolean(2, itr.next().isRead());
                pstmt.setBoolean(3, itr.next().isUpdate());
                pstmt.setInt(4, pk);
                pstmt.execute();
                pstmt.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void getRessourceList(RoleInfo roleInfo,String key) {
        Connection conn = null;
        Statement stmt, stmt2 = null;
        ResultSet rs, rs2 = null;
        String sql, sql2 = "";
        List<SubResource> subResources = new ArrayList<>();
        try {
            DbConnection db = new DbConnection();
            conn = db.connect();

            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            sql = "SELECT  * FROM role WHERE pkid="+key;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int pkid = rs.getInt("pkid");
                roleInfo.setPkid(pkid);
                roleInfo.setApplication(rs.getString("application"));
                roleInfo.setName(rs.getString("name"));
                roleInfo.setDescription(rs.getString("description"));
                roleInfo.setResourceWebPage(rs.getString("webpage"));
                roleInfo.setShowPermission(1);
                sql2 = "SELECT * FROM resource WHERE roleId='" + pkid + "'";
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    SubResource sub = new SubResource();
                    sub.setResourcename(rs2.getString("resourcename"));
                    sub.setEnum_val(rs2.getInt("enumid"));
                    sub.setRead(rs2.getBoolean("isRead"));
                    sub.setUpdate(rs2.getBoolean("isUpdate"));
                    subResources.add(sub);
                }
                rs2.close();
                roleInfo.setSubResources(subResources);
            }
            rs.close();
            stmt.close();
            stmt2.close();
        } catch (Exception e) {
            System.out.println("--------------some exp------------------------" + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void getRoleList(List<RoleInfo> roleInfoList) {
        Connection conn = null;
        Statement stmt, stmt2 = null;
        ResultSet rs, rs2 = null;
        String sql, sql2 = "";
        try {
            DbConnection db = new DbConnection();
            conn = db.connect();
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            sql = "SELECT  * FROM role";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int pkid = rs.getInt("pkid");
                RoleInfo roleInfo=new RoleInfo();
                roleInfo.setPkid(pkid);
                roleInfo.setApplication(rs.getString("application"));
                roleInfo.setName(rs.getString("name"));
                roleInfo.setDescription(rs.getString("description"));
                roleInfo.setResourceWebPage(rs.getString("webpage"));
                roleInfo.setShowPermission(1);
                /*Set<SubResource> subResources = new HashSet<>();
                sql2 = "SELECT * FROM resource WHERE roleId='" + pkid + "'";
                rs2 = stmt2.executeQuery(sql2);
                while (rs2.next()) {
                    SubResource sub = new SubResource();
                    sub.setResourcename(rs2.getString("resourcename"));
                    sub.setEnum_val(rs2.getInt("enumid"));
                    sub.setRead(rs2.getBoolean("isRead"));
                    sub.setUpdate(rs2.getBoolean("isUpdate"));
                    subResources.add(sub);

                }
                rs2.close();
                roleInfo.setSubResources(subResources);*/
                roleInfoList.add(roleInfo);
            }
            rs.close();
            stmt.close();
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
