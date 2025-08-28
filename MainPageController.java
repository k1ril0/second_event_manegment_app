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

public class MainPageController implements Initializable {
    @FXML
    private Button AddEventButton;

     
    String[] ListOfMoth = { "January","February","March","April","May","June",
     "July","August","September","October","November","December"};

      Integer [] Days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

      Integer [] Years = {2026,2027,2028,2029,2030};

      ObservableList<String> CalendarMothList = FXCollections.observableArrayList(ListOfMoth);  
      ObservableList<Integer> CalendarDaysList = FXCollections.observableArrayList(Days);
      ObservableList<Integer> CalendarYearList = FXCollections.observableArrayList(Years);


      @FXML   
      ChoiceBox ChoseDataCalendar = new ChoiceBox<Integer>(CalendarDaysList);
      @FXML
      ChoiceBox ChoseMothCalendar = new ChoiceBox<String>(CalendarMothList);
      @FXML
      ChoiceBox ChoseYearcalendar = new ChoiceBox<Integer>(CalendarYearList);

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
          Button AcceptCalendarDateButton = new Button("ACCEPT");
          // ChoiceBox ChoseDataCalendar = new ChoiceBox<Integer>();
          // ChoiceBox ChoseMothCalendar = new ChoiceBox<String>();
          // ChoiceBox ChoseYearcalendar = new ChoiceBox<Integer>();
          ChoseDataCalendar.setPrefWidth(120);
          ChoseMothCalendar.setPrefWidth(120);
          ChoseYearcalendar.setPrefWidth(120); 
          Stage CalendarStage = new Stage();
          VBox SelectDataCalendar = new VBox(ChoseDataCalendar,ChoseMothCalendar,ChoseYearcalendar,AcceptCalendarDateButton);
          Scene CalendarScene = new Scene(SelectDataCalendar,400,200);
          CalendarStage.setScene(CalendarScene);
          CalendarStage.show();
      }catch(Exception ex){
       ex.printStackTrace();
      }

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      ChoseDataCalendar.getItems().addAll(CalendarDaysList);
      ChoseMothCalendar.getItems().addAll(CalendarMothList);
      ChoseYearcalendar.getItems().addAll(CalendarYearList);
    } 

    
}
