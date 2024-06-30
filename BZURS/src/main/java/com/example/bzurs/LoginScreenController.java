package com.example.bzurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {

    @FXML
    private ImageView BZULogo;
    @FXML
    private Button LoginB;
    @FXML
    private AnchorPane LoginscreenP;
    @FXML
    private Label LoginInfoL;
    @FXML
    private Label PasswordL;
    @FXML
    private TextField PasswordTF;
    @FXML
    private Label UsernameL;
    @FXML
    private TextField UsernameTF;

    @FXML
    void MouseHover(MouseEvent event) {
        LoginB.getStyleClass().add("button-hover");
    }

    @FXML
    void MouseUnHover(MouseEvent event) {
        LoginB.getStyleClass().removeAll("button-hover");

    }

    @FXML
    void MouseClicked(MouseEvent event) {
        LoginB.getStyleClass().add("button-clicked");
    }

    @FXML
    void MouseReleased(MouseEvent event) {
        LoginB.getStyleClass().removeAll("button-clicked");
        LoginInfoL.setText("Stop pressing the button!");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UsernameTF.setText("");
    }
}
