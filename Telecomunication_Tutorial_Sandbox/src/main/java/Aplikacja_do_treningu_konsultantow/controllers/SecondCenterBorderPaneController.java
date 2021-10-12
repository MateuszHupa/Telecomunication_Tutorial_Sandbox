package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SecondCenterBorderPaneController {

    @FXML
    private VBox leftSideVBox;
    @FXML
    private BorderPane secondCenterBorderPane;
    @FXML
    private VBox VBoxCenter;
    @FXML
    private Label labelUslugi;
    @FXML
    private Label labelSalda;
    @FXML
    private Label labelHistoria;

    private CenterSaldaPaneController centerSaldaPaneController;
    private CenterUslugiTreeViewController centerUslugiTreeViewController;
    private CenterHistoriaPaneController centerHistoriaPaneController;
    private List<MSISDN> msisdn;

    public void setVisible(boolean b) {
        secondCenterBorderPane.setVisible(b);
        leftSideVBox.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" //+ "-fx-border-insets: 20;"
                + "-fx-border-radius: 3;" + "-fx-border-color: black;");
        VBoxCenter.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" //+ "-fx-border-insets: 20;"
                + "-fx-border-radius: 3;" + "-fx-border-color: black;");
    }

    public void setPhoneNumberData(String data) throws SQLException {
        Dao<MSISDN,?> dao2 = new DaoManager().createDao(DataBaseManager.getConnectionSource(), MSISDN.class);
        msisdn = dao2.queryForEq("NUMER_TELEFONU", data);
    }

    public void labelUslugiMouseEntered() {
        labelUslugi.setStyle("-fx-background-color: lightgrey;" + "-fx-text-fill: black");
    }

    public void labelSaldaMouseEntered() {
        labelSalda.setStyle("-fx-background-color: lightgrey;" + "-fx-text-fill: black");
    }

    public void labelHistoriaMouseEntered() {
        labelHistoria.setStyle("-fx-background-color: lightgrey;" + "-fx-text-fill: black");
    }

    public void labelUslugiMouseExited() {
        labelUslugi.setStyle("-fx-background-color: Default;");
    }

    public void labelSaldaMouseExited() {
        labelSalda.setStyle("-fx-background-color: Default;");
    }

    public void labelHistoriaMouseExited() {
        labelHistoria.setStyle("-fx-background-color: Default;");
    }

    public void labelHistoriaMouseClicked() throws IOException, SQLException {
        labelHistoria.setStyle("-fx-background-color: lightgrey;" + "-fx-text-fill: black");
        labelSalda.setStyle("-fx-background-color: Default;");
        labelUslugi.setStyle("-fx-background-color: Default;");
        labelHistoria.setOnMouseExited(event -> {});
        labelSalda.setOnMouseExited(event -> labelSaldaMouseExited());
        labelUslugi.setOnMouseExited(event -> labelUslugiMouseExited());

        VBoxCenter.getChildren().clear();

        FXMLLoader loader3 = new FXMLLoader(SecondCenterBorderPaneController.class.getResource("/fxml/CenterHistoriaPane.fxml"));
        VBoxCenter.getChildren().add(loader3.load());
        centerHistoriaPaneController = loader3.getController();
        centerHistoriaPaneController.fillTable(msisdn.get(0));
    }

    public void labelSaldaMouseClicked() throws IOException, SQLException {
        labelSalda.setStyle("-fx-background-color: lightgrey;" + "-fx-text-fill: black");
        labelUslugi.setStyle("-fx-background-color: Default;");
        labelHistoria.setStyle("-fx-background-color: Default;");
        labelHistoria.setOnMouseExited(event -> labelHistoriaMouseExited());
        labelSalda.setOnMouseExited(event -> {});
        labelUslugi.setOnMouseExited(event -> labelUslugiMouseExited());

        VBoxCenter.getChildren().clear();

        FXMLLoader loader2 = new FXMLLoader(SecondCenterBorderPaneController.class.getResource("/fxml/CenterSaldaPane.fxml"));
        VBoxCenter.getChildren().add(loader2.load());
        centerSaldaPaneController = loader2.getController();
        centerSaldaPaneController.setSaldaData(msisdn.get(0));

    }

    public void labelUslugiMouseClicked() throws IOException {
        labelUslugi.setStyle("-fx-background-color: lightgrey;" + "-fx-text-fill: black");
        labelSalda.setStyle("-fx-background-color: Default;");
        labelHistoria.setStyle("-fx-background-color: Default;");
        labelHistoria.setOnMouseExited(event -> labelHistoriaMouseExited());
        labelSalda.setOnMouseExited(event -> labelSaldaMouseExited());
        labelUslugi.setOnMouseExited(event -> {});

        VBoxCenter.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(SecondCenterBorderPaneController.class.getResource("/fxml/CenterUslugiTreeView.fxml"));

        VBoxCenter.getChildren().add(loader.load());

        centerUslugiTreeViewController = loader.getController();
        centerUslugiTreeViewController.setUslugiTreeView(msisdn);

    }
}