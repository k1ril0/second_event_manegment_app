package com.event.app;

import java.net.URL;
import java.util.List;
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


  //i think we should replace names of month to just numbers.this change give me chance to minimaze code a littel a bit 
   // but that something and also this replace give me acces to search efectevly events
   // but there problem i dont wanna change that in user interface so i should just do something like this
   // October = 10 moth of n-yeran and n-day
    
  
     String[] ListOfMoth = { "January","February","March","April","May","June",
     "July","August","September","October","November","December"};

      Integer [] Days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

      Integer [] Years = {2026,2027,2028,2029,2030};

      ObservableList<String> CalendarMothList = FXCollections.observableArrayList(ListOfMoth);  
      ObservableList<Integer> CalendarDaysList = FXCollections.observableArrayList(Days);
      ObservableList<Integer> CalendarYearList = FXCollections.observableArrayList(Years);

        @FXML
        ChoiceBox ChoseDataCalendar = new ChoiceBox<Integer>();
        @FXML  
        ChoiceBox ChoseMothCalendar = new ChoiceBox<String>();
        @FXML
        ChoiceBox ChoseYearCalendar = new ChoiceBox<Integer>();
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
                System.out.println(GetAllChoiceBox(ChoseYearCalendar, ChoseMothCalendar, ChoseDataCalendar));
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

        public List<Object> GetAllChoiceBox(ChoiceBox firstChoiceBox,ChoiceBox secondChoiceBox,ChoiceBox thirdChoiceBox){
          try{
             return List.of(firstChoiceBox.getValue(),secondChoiceBox.getValue(),thirdChoiceBox.getValue());
          }catch(Exception e){
            e.printStackTrace();
            return null;
          }
        }
        private void FindNumberOfMonth(){
          int indexOfMonth = -1;
          for(int i =0;i<ListOfMoth.length;i++){
            if(ListOfMoth[i].equals(ChoseMothCalendar.getValue().toString())){
              indexOfMonth = i + 1;
              break;
            }
          }
        }


        
        //here i wanna take fresh view i guues just reconstruct cllas and method in him 



         @FXML   
         ChoiceBox MonthChoiceBox = new ChoiceBox<String>();
         @FXML
         ChoiceBox DaysChoiceBox = new ChoiceBox<Integer>();
         @FXML
         ChoiceBox YearChoiceBox = new ChoiceBox<Integer>();

        private void GetNumberOfMonthYouChoose(String ExpectedMonth){
          int numberofMonth = -1;
          for(int i = 0;i<ListOfMoth.length;i++){
            if(ListOfMoth[i].equals(ExpectedMonth));
            numberofMonth = i+1;
            break;
          }
        }
        private void CheckIfEvrythingIsField(){
         switch (StatusOfFields()) {
          case "ALL_EMPTY":
          System.out.println("Select something from options that we have");  
          break;
           case "ONLY_DAYS_EMPTY":
            System.out.println("Please choose day to contiune");
          break;
           case "ONLY_YEAR_EMPTY":
            System.out.println("Please choose year to contiune");
          break;
           case "ONLY_MONTH_EMPTY":
            System.out.println("Please choose month to contiune");
          break;
           case "ALL_GOOD":
            System.out.println("All good you can contiune your experience");
            String MonthThatUserChosse = MonthChoiceBox.getValue().toString();
            GetNumberOfMonthYouChoose(MonthThatUserChosse);
          break;
         }
        }
        private String StatusOfFields(){
          String Status;
          if(MonthChoiceBox.getValue() ==null && DaysChoiceBox.getValue() == null && YearChoiceBox.getValue() ==null){
             return Status = "ALL_EMPTY";
          }if(MonthChoiceBox.getValue() != null && DaysChoiceBox.getValue() == null && YearChoiceBox.getValue() !=null){
            return Status = "ONLY_DAYS_EMPTY";
          }if(MonthChoiceBox.getValue() != null && DaysChoiceBox.getValue() != null && YearChoiceBox.getValue() == null){
            return Status = "ONLY_YEAR_EMPTY";
          }if(MonthChoiceBox.getValue() == null && DaysChoiceBox.getValue() != null && YearChoiceBox.getValue() != null){
            return Status = "ONLY_MONTH_EMPTY";
          }else{
            return Status = "ALL_GOOD";
          }
        }
        
        

    
}
