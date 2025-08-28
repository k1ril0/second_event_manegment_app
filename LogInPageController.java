package com.event.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInPageController {
    @FXML
    private Button LogInButton;
    @FXML
    private TextField NameField;
    @FXML
    private TextField PasswordField;


    @FXML
    private void LogIn() throws Exception{
        LogInButton.setOnAction(e ->{
            try{
            switch (CheckStatments()) {
                case"BOTH_FIELDS_EMPTHY":
                System.out.println("BOTH FIELDS ARE EMPTHY ");    
                 break;
                case"NAME_FIELD_EMPTHY":
                System.out.println("NAME FIELD EMPTHY");
                break;
                case "PASSWORD_FIELD_EMPTHY":
                System.out.println("PASSWORD FIELD EMPTHY");
                break;
                case"ALL_GOOD":
                System.out.println("ALL GOOD");
                GoToNextPage(LogInButton);
                break;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        });
    }
    private String CheckStatments(){
        String status;
        try{
            if(NameField.getText().isEmpty() && !PasswordField.getText().isEmpty()){
                return status = "NAME_FIELD_EMPTHY";
            }if(PasswordField.getText().isEmpty() && !NameField.getText().isEmpty()){
                return status = "PASSWORD_FIELD_EMPTHY";
            }if(PasswordField.getText().isEmpty() && NameField.getText().isEmpty()){
                return status = "BOTH_FIELDS_EMPTHY";
            }else{
                return status = "ALL_GOOD";
            }

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private void GoToNextPage(Button expectedButton) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("/MainPage.fxml"));
       Scene nextScene = new Scene(root,600,400);
       Stage secondStage = (Stage) expectedButton.getScene().getWindow();
       secondStage.setScene(nextScene);
       secondStage.setTitle("MAIN PPAGE");
       secondStage.show();       
    }
    
}
