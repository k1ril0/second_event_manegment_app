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
import javafx.stage.Stage;

public class CalendarMenuController implements Initializable {
    
  
     String[] ListOfMoth = { "January","February","March","April","May","June",
     "July","August","September","October","November","December"};

      Integer [] Days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

      Integer [] Years = {2026,2027,2028,2029,2030};

      ObservableList<String> CalendarMothList = FXCollections.observableArrayList(ListOfMoth);  
      ObservableList<Integer> CalendarDaysList = FXCollections.observableArrayList(Days);
      ObservableList<Integer> CalendarYearList = FXCollections.observableArrayList(Years);

        @FXML
        ChoiceBox<Integer> ChoseDataCalendar = new ChoiceBox<>();
        @FXML  
        ChoiceBox<String> ChoseMothCalendar = new ChoiceBox<>();
        @FXML
        ChoiceBox<Integer> ChoseYearCalendar = new ChoiceBox<>();
        @FXML
        Button AcceptCalendarDateButton = new Button();
        @FXML
        private Button BackFromSeeEvent;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      ChoseDataCalendar.getItems().addAll(CalendarDaysList);
      ChoseMothCalendar.getItems().addAll(CalendarMothList);
      ChoseYearCalendar.getItems().addAll(CalendarYearList); 
    }
            @FXML
        private void AcceptData(){
           AcceptCalendarDateButton.setOnAction(e ->{
            try{
              switch (CheckchoiceBoxes()) {
                case "MOTH_CHOICE_BOX_IS_EMPTHY":
                System.out.println("MOTH CHOICE BOX IS EMPTHY");  
                break;
                case "DAY_CHOICE_BOX_IS_EMPTHY":
                System.out.println("DAY CHOICE BOX IS EMPTHY");
                break;
                case "YEAR_CHOICE_BOX_IS_EMPTHY":
                System.out.println("YEAR CHOICE BOX IS EMPTHY");
                break;
                case "ALL_cHOICE_BOX_ARE_EMPTHY":
                System.out.println("ALL cHOICE BOX ARE EMPTHY");
                break;
                case "ALL_GOOD":
                System.out.println("ALL GOOD");
                break;
              }

            }catch(Exception ex){
              ex.printStackTrace();
            }
           });
        }
        private String CheckchoiceBoxes(){
          String StatusOfChoiceBox;
          if(ChoseMothCalendar.getValue()==null && ChoseDataCalendar.getValue() != null && ChoseYearCalendar.getValue() != null ){
           return StatusOfChoiceBox = "MOTH_CHOICE_BOX_IS_EMPTHY";
          }else if(ChoseDataCalendar.getValue()==null && ChoseMothCalendar.getValue() != null && ChoseYearCalendar.getValue() != null){
           return StatusOfChoiceBox = "DAY_CHOICE_BOX_IS_EMPTHY";
          }else if(ChoseYearCalendar.getValue()==null && ChoseMothCalendar.getValue() != null && ChoseDataCalendar.getValue() != null){
           return StatusOfChoiceBox = "YEAR_CHOICE_BOX_IS_EMPTHY";
          }else if(ChoseMothCalendar.getValue()==null && ChoseDataCalendar.getValue()==null && ChoseYearCalendar.getValue()==null){
           return StatusOfChoiceBox = "ALL_cHOICE_BOX_ARE_EMPTHY";
          }else{
            return StatusOfChoiceBox = "ALL_GOOD";
          }
        }
        @FXML
        private void BackFromSeeEvent(){
            try{
           Parent root = FXMLLoader.load(getClass().getResource("/MainPAge.fxml"));
           Stage BackToTheMenuStage = (Stage) BackFromSeeEvent.getScene().getWindow();
           Scene BackToTheMenuScene = new Scene(root,600,400);
           BackToTheMenuStage.setScene(BackToTheMenuScene);
           BackToTheMenuStage.show();
            }catch(Exception ex){
             ex.printStackTrace();
            }
        }

    
}
