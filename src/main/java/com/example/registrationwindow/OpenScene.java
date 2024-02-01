package com.example.registrationwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class OpenScene {
    public void openNewScene(String scene,boolean showAndWaint){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(scene));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root =loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        if (showAndWaint){
            stage.showAndWait();
        }
        else stage.show();
    }
}
