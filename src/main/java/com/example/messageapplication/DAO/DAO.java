package com.example.messageapplication.DAO;


import com.example.messageapplication.Controllers.AllUsersController;
import com.example.messageapplication.Controllers.FriendReqController;
import com.example.messageapplication.Controllers.MessagingController;
import com.example.messageapplication.Models.CurrentUser;
import com.example.messageapplication.Models.Message;
import com.example.messageapplication.Models.User;
import com.example.messageapplication.UI.MessagingParent;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
            FriendReqController.onCreate();
            AllUsersController.onCreate();
            return true;
        }
        return false;
    }
    public boolean Register(User user) throws SQLException {
        PreparedStatement p=this.con.prepareStatement("insert into user(Email, Password, Username, Lang, Avatar) values(?,?,?,?,?)");
        p.setString(1, user.getEmail());
        p.setString(2, user.getPassword());
        p.setString(3, user.getUserName());
        p.setString(4, user.getLang());
        p.setInt(5,user.getAvatar());
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
    public ArrayList<User> getFriendReqs() throws SQLException {
        ArrayList<User> r=new ArrayList<>();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `friendrequest` WHERE Reciever="+CurrentUser.GetCurrentUser().getId());
        while(rs.next()){
            r.add(DAO.getInstance().GetUserById(rs.getInt(1)));
        }
        return r;
    }
    public ArrayList<User> getNonriends() throws SQLException {
        ArrayList<User> r=new ArrayList<>();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `user` where Id NOT IN (SELECT Sender from `friendrequest` where Reciever="+CurrentUser.GetCurrentUser().getId()+") and Id NOT IN (SELECT Reciever from `friendrequest` where Sender="+CurrentUser.GetCurrentUser().getId()+") and  Id NOT IN (SELECT User1 from `friend` where User2="+CurrentUser.GetCurrentUser().getId()+") and Id NOT IN (SELECT User2 from `friend` where User1="+CurrentUser.GetCurrentUser().getId()+") and Id!="+CurrentUser.GetCurrentUser().getId());
        while(rs.next()){
                r.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
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
    public void AcceptFriendReq(int Id) throws SQLException {
        PreparedStatement p=this.con.prepareStatement("insert into friend values(?,?)");
        p.setInt(1,CurrentUser.GetCurrentUser().getId());
        p.setInt(2,Id);
        p.executeUpdate();
        this.DeleteFriendReq(Id);
    }
    public void DeleteFriendReq(int Id) throws SQLException {
        PreparedStatement m=this.con.prepareStatement("DELETE FROM friendrequest WHERE '"+CurrentUser.GetCurrentUser().getId()+"' And '"+Id+"';");
        m.executeUpdate();
    }
    public User GetUserById(int id) throws SQLException {
        ResultSet rs = con.createStatement().executeQuery("Select * from user where Id = "+Integer.toString(id));
        if(rs.next()){
            return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
        }
        return null;
    }
    public void sendMessage(Message message){
        try {
            PreparedStatement p=this.con.prepareStatement("insert into message values(?,?,?,?)");
            p.setInt(1,Integer.parseInt(message.Sender));
            p.setInt(2,Integer.parseInt(message.Reciever));
            p.setString(3,new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
            p.setString(4, message.message);
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void sendReq(int Id){
        try {
            PreparedStatement p=this.con.prepareStatement("insert into friendrequest values(?,?)");
            p.setInt(1,CurrentUser.GetCurrentUser().getId());
            p.setInt(2,Id);
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
