package com.event.app;

import java.lang.runtime.SwitchBootstraps;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.google.protobuf.Internal.ListAdapter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class AddEventController implements Initializable {
    @FXML
    private ChoiceBox MothChoiceBox = new ChoiceBox<String>();
    @FXML
    private ChoiceBox DayChoiceBox  = new ChoiceBox<Integer>();
    @FXML
    private ChoiceBox YearChoiceBox = new ChoiceBox<Integer>();
    @FXML
    private Button AcceptButton;

      String[] ListOfMoth = { "January","February","March","April","May","June",
     "July","August","September","October","November","December"};
      Integer [] Days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
      Integer [] Years = {2026,2027,2028,2029,2030};
      ObservableList<String> MothList = FXCollections.observableArrayList(ListOfMoth);  
      ObservableList<Integer> DaysList = FXCollections.observableArrayList(Days);
      ObservableList<Integer> YearList = FXCollections.observableArrayList();


        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
          // for(int year:Years){
          //   YearList.add(Integer.valueOf(year));
          // }
          YearList.addAll(Years);
          MothChoiceBox.getItems().addAll(MothList);
          DayChoiceBox.getItems().addAll(DaysList);
          YearChoiceBox.getItems().addAll(YearList);
        }
        @FXML
        private void AcceptData(){
           AcceptButton.setOnAction(e ->{
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
          if(MothChoiceBox.getItems().isEmpty()&&!DayChoiceBox.getItems().isEmpty()&&!YearChoiceBox.getItems().isEmpty()){
           return StatusOfChoiceBox = "MOTH_CHOICE_BOX_IS_EMPTHY";
          }if(DayChoiceBox.getItems().isEmpty()&&!MothChoiceBox.getItems().isEmpty()&&!YearChoiceBox.getItems().isEmpty()){
           return StatusOfChoiceBox = "DAY_CHOICE_BOX_IS_EMPTHY";
          }if(YearChoiceBox.getItems().isEmpty()&&!MothChoiceBox.getItems().isEmpty()&&!DayChoiceBox.getItems().isEmpty()){
           return StatusOfChoiceBox = "YEAR_CHOICE_BOX_IS_EMPTHY";
          }if(MothChoiceBox.getItems().isEmpty()&&DayChoiceBox.getItems().isEmpty()&&YearChoiceBox.getItems().isEmpty()){
           return StatusOfChoiceBox = "ALL_cHOICE_BOX_ARE_EMPTHY";
          }else{
            return StatusOfChoiceBox = "ALL_GOOD";
          }
        }
    
      
}
