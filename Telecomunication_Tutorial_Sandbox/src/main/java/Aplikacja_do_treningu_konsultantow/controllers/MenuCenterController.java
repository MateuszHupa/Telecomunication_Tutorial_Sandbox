package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.Main;
import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuCenterController {

    @FXML
    public ToggleButton postepyButton;
    private SceneController view = new SceneController();

    private Main maine = new Main();

    @FXML
    private ToggleButton buttonSamouczek;
    @FXML
    private ToggleButton buttonInformator;
    @FXML
    private ToggleButton buttonWyjdz;

    @FXML
    public void OpenTutorial(javafx.event.ActionEvent event) throws IOException {
        Parent mainParentScene = FXMLLoader.load(getClass().getResource("/fxml/SecondMainBorderPane.fxml"));
        view.ChangeScene((Stage)((Node)event.getSource()).getScene().getWindow(), mainParentScene);
    }

    @FXML
    public void OpenInfo() {

        maine.pdfShow();

    }

    @FXML
    public void Exit(javafx.event.ActionEvent event) {
        DataBaseManager.closeConectionSource();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();

    }

    public void customSamouczekHoverOn( ) { buttonSamouczek.setOpacity(1); }

    public void customSamouczekHoverOff( ) { buttonSamouczek.setOpacity(0.9); }

    public void customInformatorHoverOn( ) { buttonInformator.setOpacity(1); }

    public void customInformatorHoverOff( ) { buttonInformator.setOpacity(0.9); }

    public void customWyjdzHoverOn( ) { buttonWyjdz.setOpacity(1); }

    public void customWyjdzHoverOff( ) { buttonWyjdz.setOpacity(0.9); }

    public void showPostepy(javafx.event.ActionEvent event) throws IOException {
        Parent mainParentScene = FXMLLoader.load(getClass().getResource("/fxml/PostepyBorderPane.fxml"));
        view.ChangeScene((Stage)((Node)event.getSource()).getScene().getWindow(), mainParentScene);

    }
}
