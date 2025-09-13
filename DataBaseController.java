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
            while(rowsAffected < 0){ 
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
    //working method of adding events to the database but there is wor to do in AddEventController where i should 
    // manage how inject list of objects in paramtres of this void so this i hope i fix in next update 
    // what will be time when i comeback from vacation 
    public void AddEventToTheSceduel(String NameOfEvent,String TypeOfEvent,String DateOfEvent){
       Connection AddEventToTheSceduelConnection = getConnection();
       try{
        String Sql_Command_For_Add_Event_To_Scheduel = "insert into eventssceduel(DateOfEvent,NameOfEvent,TypeOfEvent) values(?,?,?)";
        if(AddEventToTheSceduelConnection !=null){
          PreparedStatement ADD_EVENT_SCHEDUEL = AddEventToTheSceduelConnection.prepareStatement(Sql_Command_For_Add_Event_To_Scheduel);
          ADD_EVENT_SCHEDUEL.setString(1, DateOfEvent);
          ADD_EVENT_SCHEDUEL.setString(2, NameOfEvent);
          ADD_EVENT_SCHEDUEL.setString(3, TypeOfEvent);
          int rowsAffected = ADD_EVENT_SCHEDUEL.executeUpdate();
          while(rowsAffected > 0 ){
          System.out.println("Rows has been updated : " + rowsAffected);
          }
        }else{
            System.out.println("Problem has been ocured in AddEventToScheduel mathod from DataBaseController");
        }
       }catch(Exception e){
        e.printStackTrace();
       }
    }
    
}
