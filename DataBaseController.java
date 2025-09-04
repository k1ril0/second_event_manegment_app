package com.event.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseController {
    String name = "root";
    String url = "jdbc:mysql://localhost:3306/eventappdatabase";
    String password = "1234567";

    private Connection getConnection(){
        Connection mainConnection = null;
        try{
         mainConnection = DriverManager.getConnection(url,name,password);
        System.out.println("Connection established");
        }catch(Exception e){
            e.printStackTrace();
        }
        return mainConnection;
    }
    public void AddUserFromLogIn(String Username,String Password){
        Connection AddConnection = getConnection();
        try{
            String Sql_Command_For_Add = "insert into LogInUsers (name,password) values (?,?)";
           if(AddConnection!=null){
            PreparedStatement AddStatment = AddConnection.prepareStatement(Sql_Command_For_Add);
            AddStatment.setString(1,Username);
            AddStatment.setString(2, Password);
            int rowsAffected = AddStatment.executeUpdate();
            while(rowsAffected >= 0){ 
                System.out.println("Rows has been updated : " + rowsAffected);
                AddConnection.close();
            } 
           }else{
            System.out.println("Problem has been ocured in AddUser mathod from DataBaseController");
           }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
