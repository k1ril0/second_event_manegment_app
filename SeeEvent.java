package com.event.app;

import javafx.scene.control.ChoiceBox;

public class SeeEvent extends CalendarMenuController {

   //i think we should replace names of month to just numbers.this change give me chance to minimaze code a littel a bit 
   // but that something and also this replace give me acces to search efectevly events
    DataBaseController controllerForSee = new DataBaseController();
    private void SeeEvent(int Day,String Month,int Year){ 
      controllerForSee.GetDataForSeeEventController(Month);
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
    //   public  String   GetAllrequierdDataForAddToTheDataBase(){
    //     String DataOfEventsGoing;
    //     return DataOfEventsGoing = GetNumberOfMonthUserChoose(MonthChoiceBoxForAdd)+ "." + DayChoiceBoxForAdd.getValue().toString()+ "." + YearChoiceBoxForAdd.getValue().toString();
    //   }
    //   public  String GetTypeOfEventForAdd(){
    //    String TypeOfEvent;
    //    return TypeOfEvent = TypeOfEventChoiceBoxForAdd.getValue().toString();
    //   }
    //   public String GetNameOfeventForAdd(){
    //     String NameOfEvent;
    //     return NameOfEvent = NamefieldForAdd.getText(); 
    //   }

    
    
}
