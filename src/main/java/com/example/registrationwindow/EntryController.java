package com.example.registrationwindow;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.registrationwindow.animation.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EntryController extends OpenScene {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Log_in_field;

    @FXML
    private Button entry;

    @FXML
    private Button log_in_Button;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        entry.setOnAction(event -> {
            String LoginText = Log_in_field.getText().trim();
            String LoginPassword = password_field.getText();
            if(!LoginText.equals("") && !LoginPassword.equals("")){
               loginUser(LoginText, LoginPassword);
            }
            else {
                System.out.println("login or password is empty");
            }
        } );
        log_in_Button.setOnAction(actionEvent -> {

            this.log_in_Button.getScene().getWindow().hide();
            super.openNewScene("signUp-view.fxml",true);

        });


    }



    private void loginUser(String loginText, String loginPassword) {
        DatabaseHendler databaseHendler = new DatabaseHendler();

        Users user = new Users();
        user.setUserName(loginText);
        user.setPasswrod(loginPassword);

        ResultSet result = databaseHendler.getUser(user);
        int conter = 0;
        try{
             while (result.next()){
                conter++;

            }
        } catch (SQLException e) {

        }
        if (conter >= 1){
            Users.sName=loginText;
            this.log_in_Button.getScene().getWindow().hide();

            openNewScene("helloUser-view.fxml",true);

        }
        else {
            Shake userLoginAnime = new Shake( Log_in_field);
            Shake userPassAnime = new Shake(password_field );
            userLoginAnime.playAnime();
            userPassAnime.playAnime();

            password_field.setText("");
        }
    }
//    public void openNewScene(String window) {
//
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(window));
//
//        try {
//            loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Parent root =loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
//    }

}
