package com.example.registrationwindow;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

    public class SignUpController extends OpenScene {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private RadioButton FemaleSignUpRadioButton;

        @FXML
        private RadioButton MaleSignUpRadioButton;

        @FXML
        private Button SignUpButton;

        @FXML
        private TextField SignUpCountry;

        @FXML
        private TextField SignUpFirstName;

        @FXML
        private TextField SignUpLastName;

        @FXML
        private TextField SignUpName;

        @FXML
        private PasswordField SignUpPass;

        @FXML
        private ToggleGroup gander;

        @FXML
        void initialize() {
            SignUpButton.setOnAction(event -> {
                if (!SignUpFirstName.getText().equals("") && !SignUpLastName.getText().equals("") &&
                        !SignUpName.getText().equals("") && !SignUpPass.getText().equals("") &&
                        !SignUpCountry.getText().equals("")){
                    if ( !SignUpName.getText().equals(""))
                    SignUpUser();
                    SignUpPass.getScene().getWindow().hide();
                    super.openNewScene("entry-view.fxml",false);

                }
                else System.out.println("Одне з полів порожнє");
            });

        }

        private void SignUpUser() {
            DatabaseHendler dbHandler = new DatabaseHendler();
            String firstName = SignUpFirstName.getText();
            String lastName = SignUpLastName.getText();
            String userName = SignUpName.getText();
            String password = SignUpPass.getText();
            String location = SignUpCountry.getText();
            String gender = "";
            if(MaleSignUpRadioButton.isManaged()){
                gender = "male";
            }
            else gender = "female";

            Users user = new Users(firstName,lastName,userName,password,location,gender);

            dbHandler.SignUpUser(user);
        }

    }


