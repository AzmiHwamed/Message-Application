package com.example.messageapplication.DAO;


import com.example.messageapplication.Controllers.MessagingController;
import com.example.messageapplication.Models.CurrentUser;
import com.example.messageapplication.Models.Message;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.UI.MessagingParent;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DAO {
    Connection con;
    static DAO obj;

    private DAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/chatlingo","root","");}
        catch(Exception e){
            System.out.println("Error");
        }
    }
    public static DAO getInstance(){
        if(obj==null)
            obj=new DAO();
        return obj;
    }


    public boolean Authentificate(String Email,String Password) throws SQLException, IOException {
        ResultSet rs = con.createStatement().executeQuery("Select * from user where Email = '"+Email+"' AND Password = '"+Password+"'");
        if(rs.next()){
            System.out.println("supposely user id = "+rs.getInt(1));
            CurrentUser.SetUser(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
            MessagingParent.obj.call();
            return true;
        }
        return false;
    }
    public boolean Register(User user) throws SQLException {
        PreparedStatement p=this.con.prepareStatement("insert into user values(?,?,?,?,?)");
        p.setString(0, user.getEmail());
        p.setString(1, user.getPassword());
        p.setString(2, user.getUserName());
        p.setString(3, user.getLang());
        p.setInt(4,user.getAvatar());
        return p.executeUpdate()>0;
    }
    public ArrayList<User> getFriends() throws SQLException {
        ArrayList<User> r=new ArrayList<>();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM friend WHERE "+CurrentUser.GetCurrentUser().getId());
        while(rs.next()){
            if(rs.getInt(1)==CurrentUser.GetCurrentUser().getId()){
                r.add(DAO.getInstance().GetUserById(rs.getInt(2)));
            }
            else{
                r.add(DAO.getInstance().GetUserById(rs.getInt(1)));
            }
        }
        return r;
    }

    public ArrayList<Message> getMessages(int id) throws SQLException {
        ArrayList<Message> r=new ArrayList<>();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `message` WHERE '"+id+"' and '"+CurrentUser.GetCurrentUser().getId()+"' ORDER by Date");
        while(rs.next()){
            r.add(new Message(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        return r;
    }
    public User GetUserById(int id) throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("Select * from user where Id = "+Integer.toString(id));
        if(rs.next()){
            return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
        }
        return null;

    }
}
