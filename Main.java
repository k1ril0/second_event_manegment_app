package com.event.app;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("/LogInPage.fxml"));
      Scene primaryScene = new Scene(root,600,400);
      primaryStage.setScene(primaryScene);
      primaryStage.setTitle("Log in Page Test");
      primaryStage.show();
    }
}