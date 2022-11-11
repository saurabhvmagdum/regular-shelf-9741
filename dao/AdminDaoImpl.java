package com.masai.dao;


import java.sql.*;
import com.masai.utility.*;
import com.masai.expections.adminException;
import com.masai.build.*;

public class AdminDaoImpl implements AdminDao{
    
    public String registerAdmin(Admin admin)throws adminException{
        String result = "Not inserted..";

        try (Connection conn = DBUtil.provideConnection()){

            PreparedStatement ps = conn.prepareStatement("insert into admin(username,password) values(?,?)");

            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());

            int num = ps.executeUpdate();

            if(num>0){
                result = "Admin registration successfully";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new adminException(e.getMessage());
        }

        return result;
    }

    public Admin signInAdmin(String username,String password) throws adminException{

        Admin admin =null;

        try(Connection conn = DBUtil.provideConnection()){
            
            PreparedStatement ps = conn.prepareStatement("select * from admin where username=? AND password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String u = rs.getString("username");
                String p = rs.getString("password");

                admin = new Admin(u, p);
            }
            else{
                throw new adminException("Invalid Username or password.");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            throw new adminException(e.getMessage());
        }

        return admin;
    }

}

