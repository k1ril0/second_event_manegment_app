package com.event.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPageController {
    @FXML
    private Button AddEventButton;
    @FXML
    private Button SeeEventButton;


    @FXML
    private void AddEvent(){
      AddEventButton.setOnAction(e->{
        try{
        Parent ContiuneRoot = FXMLLoader.load(getClass().getResource("/AddMenuOfEvent.fxml"));
        Stage ContiuneStage = (Stage) AddEventButton.getScene().getWindow();
        Scene ContiuneScene = new Scene(ContiuneRoot,600,400);
        ContiuneStage.setScene(ContiuneScene);
        ContiuneStage.setTitle("Add Event Page");
        ContiuneStage.show();
        }catch(Exception ex){
         ex.printStackTrace();
        }
      });
    }
    @FXML
    private void SeeUpcomingEvents(){
      try{
          Parent root = FXMLLoader.load(getClass().getResource("/CalendarMenu.fxml"));
          Stage CalendarStage = (Stage) SeeEventButton.getScene().getWindow();
          Scene CalendarScene = new Scene(root);
          CalendarStage.setScene(CalendarScene);
          CalendarStage.show();
      }catch(Exception ex){
       ex.printStackTrace();
      }

    }
    
}
