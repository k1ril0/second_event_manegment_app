package com.event.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

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
    public void AddUserFromSighIn(String Username,String Password){
        Connection AddConnection = getConnection();
        try{
            String Sql_Command_For_Add = "insert into SighInUsers (Name,password) values (?,?)";
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
    public void SearchUserInSighInBAse(String name,String password){
        String SQL_COMMAND_SERCHING = "select * from sighinusers where Name = ? and password = ?";
        try{
         Connection searchConnection = (getConnection());
         PreparedStatement searchstaStatement = searchConnection.prepareStatement(SQL_COMMAND_SERCHING);
         searchstaStatement.setString(1,name);
         searchstaStatement.setString(2,password);
         ResultSet resultOfSearching = searchstaStatement.executeQuery();
         if(resultOfSearching.next()){
            System.out.println("User has been found in our database");
         }else{
            System.out.println("Probllem in searching this user");
         }

        }catch(Exception e){
            System.out.println("Error was spotted in search method :" + e.getMessage());
        }
    }
    //working method of adding events to the database but there is wor to do in AddEventController where i should 
    // manage how inject list of objects in paramtres of this void so this i hope i fix in next update 
    // what will be time when i comeback from vacation 
    public void AddEventToTheSceduel(String StructerdTimeOfEvent,String NameOfEvent,String TypeOfEvent){
       Connection AddEventToTheSceduelConnection = getConnection();
       try{
        AddEventController ControllerForEventScheduel = new AddEventController();
        String Sql_Command_For_Add_Event_To_Scheduel = "insert into eventsscheduel(DateOfEvent,NameOfEvent,TypeOfEvent) values(?,?,?)";
        if(AddEventToTheSceduelConnection !=null){
          PreparedStatement ADD_EVENT_SCHEDUEL = AddEventToTheSceduelConnection.prepareStatement(Sql_Command_For_Add_Event_To_Scheduel);
          ADD_EVENT_SCHEDUEL.setString(1, StructerdTimeOfEvent);
          ADD_EVENT_SCHEDUEL.setString(2, NameOfEvent);
          ADD_EVENT_SCHEDUEL.setString(3, TypeOfEvent);
          int rowsAffected = ADD_EVENT_SCHEDUEL.executeUpdate();
          while(rowsAffected < 0 ){
          System.out.println("Rows has been updated : " + rowsAffected);
          }
        }else{
            System.out.println("Problem has been ocured in AddEventToScheduel mathod from DataBaseController");
        }
       }catch(Exception e){
        e.printStackTrace();
       }
    }
    public void AnotherVersionOfAddEventToThescheduel(String DataOfEvent,String NameOfEvent,String TypeOfEvent){
        Connection AnotherAddConnection = getConnection();
        String Another_SQL_COMMEND_FOR_ADD = "insert into eventsscheduel(DateOfEvent,NameOfevent,TypeOfEvent) values (?,?,?)";
        try{
          if(AnotherAddConnection != null){
            PreparedStatement AnotherAddStatment = AnotherAddConnection.prepareStatement(Another_SQL_COMMEND_FOR_ADD);
            AnotherAddStatment.setString(1, DataOfEvent);
            AnotherAddStatment.setString(2, NameOfEvent);
            AnotherAddStatment.setString(3, TypeOfEvent);
            int rowsAffected = AnotherAddStatment.executeUpdate();
            while( rowsAffected < 0){
                System.out.println("Rows affected : " + rowsAffected);
            }
          }else{
            System.out.println("Something went wrong you were adding events in the database");
            AnotherAddConnection.close();
          }
        }catch(Exception e){
          e.printStackTrace();
        }
    }
    
}
