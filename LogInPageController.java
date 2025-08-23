package com.event.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LogInPageController {
    @FXML
    private Button helloButton;
    @FXML
    private TextField NameField;
    @FXML
    private TextField PasswordField;


    @FXML
    private void LogIn(){
        helloButton.setOnAction(e ->{
            switch (CheckStatments()) {
                case"BOTH_FIELDS_EMPTHY":
                System.out.println("both fields are empthy");    
                 break;
                case"NAME_FIELD_EMPTHY":
                System.out.println("NAME FIELD EMPTHY");
                break;
                case "PASSWORD_FIELD_EMPTHY":
                System.out.println("PASSWORD FIELD EMPTHY");
                break;
                case"ALL_GOOD":
                System.out.println("ALL_GOOD");
                break;
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
    
}
