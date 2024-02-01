package com.example.registrationwindow;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.registrationwindow.Users;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text thatUser;

    @FXML
    void initialize() {
        thatUser.setText(Users.sName);
    }

}
