package com.event.app;

import java.lang.runtime.SwitchBootstraps;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.google.protobuf.Internal.ListAdapter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class AddEventController implements Initializable {
  //all good here except CheckStatments method but in futer fix i can make him better
    @FXML
    private ChoiceBox MothChoiceBox = new ChoiceBox<String>();
    @FXML
    private ChoiceBox DayChoiceBox  = new ChoiceBox<Integer>();
    @FXML
    private ChoiceBox YearChoiceBox = new ChoiceBox<Integer>();
    @FXML
    private Button AcceptButton;
    @FXML
    private Button AcceptButton1;
    @FXML
    private Button AcceptButton11;
    @FXML
    private ChoiceBox TypeChoiceBox = new ChoiceBox<String>();
    @FXML
    private TextField NameOfEventTextField;
    @FXML
    private Button BackToMenuButton;


    //   String[] ListOfEvents = { "Conference","Workshop","Webinar","Seminar","Concert","Festival","Meetup","Networking Event",
    //   "Fundraiser","Charity Event","Exhibition","Trade Show","Launch Event","Panel Discussion","Hackathon","Award Ceremony",
    //   "Sports Event","Comedy Show","Theater Performance","Religious Event","Political Rally","Training Session","Retreat","Online Course",
    //   "Job Fair","Book Signing","Art Opening","Community Gathering","Movie Screening","Gaming Tournament"};

    //   String[] ListOfMoth = { "January","February","March","April","May","June",
    //  "July","August","September","October","November","December"};

    //   Integer [] Days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

    //   Integer [] Years = {2026,2027,2028,2029,2030};

      // ObservableList<String> MothList = FXCollections.observableArrayList(ListOfMoth);  
      // ObservableList<Integer> DaysList = FXCollections.observableArrayList(Days);
      // ObservableList<Integer> YearList = FXCollections.observableArrayList(Years);
      // ObservableList<String> EventsList = FXCollections.observableArrayList(ListOfEvents);


        // @Override
        // public void initialize(URL arg0, ResourceBundle arg1) {

        //   TypeChoiceBox.getItems().addAll(EventsList);
        //   MothChoiceBox.getItems().addAll(MothList);
        //   DayChoiceBox.getItems().addAll(DaysList);
        //   YearChoiceBox.getItems().addAll(YearList);
        // }
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
                DataBaseController controller = new DataBaseController();
                // controller.AddEventToTheSceduel();
                GetStructerdTimeOfEvent();
                // GetBackToTheMenu();
                break;
              }

            }catch(Exception ex){
              ex.printStackTrace();
            }
           });
        }
        //this method not working properlly like i want hin to work but i hope in future i can fix him to 
        //work how i planned
        private String CheckchoiceBoxes(){
          String StatusOfChoiceBox;
          if(MothChoiceBox.getValue()==null && DayChoiceBox.getValue() != null && YearChoiceBox.getValue() != null ){
           return StatusOfChoiceBox = "MOTH_CHOICE_BOX_IS_EMPTHY";
          }else if(DayChoiceBox.getValue()==null && MothChoiceBox.getValue() != null && YearChoiceBox.getValue() != null){
           return StatusOfChoiceBox = "DAY_CHOICE_BOX_IS_EMPTHY";
          }else if(YearChoiceBox.getValue()==null && MothChoiceBox.getValue() != null && DayChoiceBox.getValue() != null){
           return StatusOfChoiceBox = "YEAR_CHOICE_BOX_IS_EMPTHY";
          }else if(MothChoiceBox.getValue()==null && DayChoiceBox.getValue()==null && YearChoiceBox.getValue()==null){
           return StatusOfChoiceBox = "ALL_cHOICE_BOX_ARE_EMPTHY";
          }else{
            return StatusOfChoiceBox = "ALL_GOOD";
            
          }
        }

        private Boolean GetCheckedTypeOfChoiceBox(){
          if(TypeChoiceBox.getValue()==null){
            return false;
          }else{
            return true;
          }
        }


        private Boolean GetCheckedNameOfEventChoiceBox(){
          if(NameOfEventTextField.getText().isEmpty()){
            return false;
          }else{
            return true;
          }


        }
        @FXML
        private void GetAllStatusButton(){
           if(GetCheckedNameOfEventChoiceBox()==false && GetCheckedTypeOfChoiceBox()==false && CheckchoiceBoxes()!="ALL_GOOD"){
            System.out.println("Please fill all expected fields in this window to contiune");
           }else{
            System.out.println("All fields are filled you can check event in menu");
            DataBaseController AddEventDBController = new DataBaseController();
            System.out.println(GetStructerdTimeOfEvent());
            AddEventDBController.AddEventToTheSceduel(GetStructerdTimeOfEvent(),getNameOfEventTextField(),getTypeChoiceBox());
            GetBackToTheMenu();
           }
        }
        @FXML
        private void GetBackToTheMenu(){
          try{
           Parent root = FXMLLoader.load(getClass().getResource("/MainPAge.fxml"));
           Stage BackToTheMenuStage = (Stage) BackToMenuButton.getScene().getWindow();
           Scene BackToTheMenuScene = new Scene(root,600,400);
           BackToTheMenuStage.setScene(BackToTheMenuScene);
           BackToTheMenuStage.show();
          }catch(Exception e){
            e.printStackTrace();
          }

        }
        public List<Object> GetTimeFromDataChoiceBox(ChoiceBox firstChoiceBox,Integer secondChoiceBox,ChoiceBox thirdChoiceBox){
          try{
            return List.of(firstChoiceBox.getValue(),secondChoiceBox,thirdChoiceBox.getValue());
          }catch(Exception e){
            e.printStackTrace();
            return null;
          }
        }

        public String getTypeChoiceBox() {
           if(TypeChoiceBox.getValue() != null){
              String TypeOfChoiceBox;
              return TypeOfChoiceBox = TypeChoiceBox.getValue().toString();
           }else{
            return null;
           }
        }
        public String getNameOfEventTextField() {
          if(!NameOfEventTextField.getText().isEmpty()){
             return NameOfEventTextField.getText();
          }else{
            return null;
          }
        }
        public String getMothChoiceBox() {
          if(MothChoiceBox !=null){
           return MothChoiceBox.getValue().toString();
          }else{
            return null;
          }
        }
        public String getDayChoiceBox() {
          if(DayChoiceBox.getValue()!=null){
             return DayChoiceBox.getValue().toString();
          }else{
            return null;
          }
        }
        public String getYearChoiceBox() {
          if(YearChoiceBox.getValue() != null){
          return YearChoiceBox.getValue().toString();
          }else{
            return null;
          }
        }
        public String GetStructerdTimeOfEvent(){
          String Day = getDayChoiceBox();  
          String Moth = getMothChoiceBox();
          String Year = getYearChoiceBox();
          String AllData;
          return AllData = "[Day: " + Day + "; Moth: " + Moth + "; Year: " + Year + "] ";
        }












        
       //reimagend code for this class










       String[] ListOfEvents = { "Conference","Workshop","Webinar","Seminar","Concert","Festival","Meetup","Networking Event",
      "Fundraiser","Charity Event","Exhibition","Trade Show","Launch Event","Panel Discussion","Hackathon","Award Ceremony",
      "Sports Event","Comedy Show","Theater Performance","Religious Event","Political Rally","Training Session","Retreat","Online Course",
      "Job Fair","Book Signing","Art Opening","Community Gathering","Movie Screening","Gaming Tournament"};

      String[] ListOfMoth = { "January","February","March","April","May","June",
     "July","August","September","October","November","December"};

      Integer [] Days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

      Integer [] Years = {2026,2027,2028,2029,2030};


      ObservableList MonthList = FXCollections.observableArrayList(ListOfMoth);
      ObservableList DayList = FXCollections.observableArrayList(Days);
      ObservableList YearList = FXCollections.observableArrayList(Years);
      ObservableList TypeList = FXCollections.observableArrayList(ListOfEvents);
       
       

       @FXML
       ChoiceBox MonthChoiceBoxForAdd = new ChoiceBox<String>();
       @FXML
       ChoiceBox DayChoiceBoxForAdd = new ChoiceBox<String>();
       @FXML
       ChoiceBox YearChoiceBoxForAdd = new ChoiceBox<String>();
       @FXML
       ChoiceBox TypeOfEventChoiceBoxForAdd = new ChoiceBox<String>();
       @FXML
       TextField NamefieldForAdd = new TextField();

       private String CheckAllStatmentsForAdd(){
        String StatusForAdd;
        if(MonthChoiceBoxForAdd.getValue() == null && YearChoiceBoxForAdd.getValue() == null && DayChoiceBoxForAdd.getValue() ==null && TypeOfEventChoiceBoxForAdd.getValue() == null && NamefieldForAdd.getText().isEmpty()){
         return StatusForAdd = "ALL_EMPTY";
        }if(MonthChoiceBoxForAdd.getValue() == null && YearChoiceBoxForAdd.getValue() != null && DayChoiceBoxForAdd.getValue() != null && TypeOfEventChoiceBoxForAdd.getValue() != null && !NamefieldForAdd.getText().isEmpty()){
          return StatusForAdd = "ONLY_MONTH";
        }if(MonthChoiceBoxForAdd.getValue() != null && YearChoiceBoxForAdd.getValue() == null && DayChoiceBoxForAdd.getValue() != null && TypeOfEventChoiceBoxForAdd.getValue() != null && !NamefieldForAdd.getText().isEmpty()){
          return StatusForAdd = "ONLY_YEAR";
        }if(MonthChoiceBoxForAdd.getValue() != null && YearChoiceBoxForAdd.getValue() != null && DayChoiceBoxForAdd.getValue() == null && TypeOfEventChoiceBoxForAdd.getValue() != null && !NamefieldForAdd.getText().isEmpty()){
          return StatusForAdd = "ONLY_DAY";
        }if(MonthChoiceBoxForAdd.getValue() != null && YearChoiceBoxForAdd.getValue() != null && DayChoiceBoxForAdd.getValue() !=null && TypeOfEventChoiceBoxForAdd.getValue() == null && !NamefieldForAdd.getText().isEmpty()){
          return StatusForAdd = "ONLY_TYPE";
        }if(MonthChoiceBoxForAdd.getValue()!=null && YearChoiceBoxForAdd.getValue() != null && DayChoiceBoxForAdd.getValue() != null && TypeOfEventChoiceBoxForAdd.getValue() != null && NamefieldForAdd.getText().isEmpty()){
          return StatusForAdd = "ONLY_NAME_FIELD";
        }else{
          return StatusForAdd = "ALL_GOOD";
        }
       }
      @FXML
      private void CheckIfEvrythingIsFieldForAdd(){
        switch (CheckAllStatmentsForAdd()) {
          case "ALL_EMPTY":
          System.out.println("ALL EMPTY"); 
          break;
          case "ONLY_MONTH":
          System.out.println("EMPTY ONLY MONTH");  
          break;
          case "ONLY_YEAR":
          System.out.println("EMPTY ONLY YEAR");  
          break;
          case "ONLY_DAY":
          System.out.println("EMPTY ONLY DAY");  
          break;
          case "ONLY_TYPE":
          System.out.println("EMPTY ONLY TYPE");  
          break;
          case "ONLY_NAME_FIELD":
          System.out.println("EMPTY ONLY NAME FIELD");  
          break;
          case "ALL_GOOD":
          // GetTimeFromDataChoiceBox(DayChoiceBoxForAdd,GetNumberOfMonthUserChoose(MonthChoiceBoxForAdd),YearChoiceBoxForAdd);
          // GetNumberOfMonthUserChoose(DayChoiceBoxForAdd);
           DataBaseController controllerForAdd  = new DataBaseController();
          // controllerForAdd.AddEventToTheSceduel(GetTimeFromDataChoiceBox(DayChoiceBoxForAdd, GetNumberOfMonthUserChoose(MonthChoiceBoxForAdd), YearChoiceBoxForAdd));
          controllerForAdd.AnotherVersionOfAddEventToThescheduel(GetAllrequierdDataForAddToTheDataBase(),GetNameOfeventForAdd(),GetTypeOfEventForAdd());
          System.out.println("ALL GOOd");
          GetBackToTheMenu();  
          break;
        }
      }
      private Integer GetNumberOfMonthUserChoose(ChoiceBox<String> reqiueredChoiceBox){
        int indexOfMonth = -1;
        String ChoosenMonth = reqiueredChoiceBox.getValue();
        for(int i = 0;i<ListOfMoth.length;i++){
          if(ListOfMoth[i].equals(ChoosenMonth)){
            return indexOfMonth = i+1;
          }else{
            System.out.println("SOMETHING WENT WRONG IN CALCULATING");
          }
        }
        return null;
      }
      public  String   GetAllrequierdDataForAddToTheDataBase(){
        String DataOfEventsGoing;
        return DataOfEventsGoing = GetNumberOfMonthUserChoose(MonthChoiceBoxForAdd)+ "." + DayChoiceBoxForAdd.getValue().toString()+ "." + YearChoiceBoxForAdd.getValue().toString();
      }
      public  String GetTypeOfEventForAdd(){
       String TypeOfEvent;
       return TypeOfEvent = TypeOfEventChoiceBoxForAdd.getValue().toString();
      }
      public String GetNameOfeventForAdd(){
        String NameOfEvent;
        return NameOfEvent = NamefieldForAdd.getText(); 
      }

      
      @Override
      public void initialize(URL arg0, ResourceBundle arg1) {
       MonthChoiceBoxForAdd.getItems().addAll(MonthList);
       DayChoiceBoxForAdd.getItems().addAll(DayList);
       YearChoiceBoxForAdd.getItems().addAll(YearList);
       TypeOfEventChoiceBoxForAdd.getItems().addAll(TypeList);
      }

}
