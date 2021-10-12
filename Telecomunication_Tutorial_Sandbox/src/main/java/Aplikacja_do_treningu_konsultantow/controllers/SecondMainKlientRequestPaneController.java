package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.Zadania;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class SecondMainKlientRequestPaneController {

    @FXML
    public Label wybierzLabel;
    @FXML
    public Label aktualnyKlientLabel;
    @FXML
    public Button cofnijButton;
    @FXML
    private Label licznikLabel;
    @FXML
    private TextArea textAreaKlient;
    @FXML
    private RadioButton radioA;
    @FXML
    private RadioButton radioB;
    @FXML
    private RadioButton radioC;
    @FXML
    private Button startButton;
    @FXML
    private Label fakeLabel;
    @FXML
    private VBox rozmowaVBox;

    private List<Zadania> zadanie;
    private Integer licznik = 0;
    private Random rand = new Random();
    private Integer int_random = 0;
    private Integer bledy = 0;
    private List<Zadania> isAny;

    public void initialize(){

        rozmowaVBox.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" + "-fx-border-insets: 5 10 0 0 ;"
                + "-fx-border-radius: 3;"
                + "-fx-border-color: black;");
    }

    public void rozmowaAction() throws SQLException {

        radioA.setSelected(false);
        radioB.setSelected(false);
        radioC.setSelected(false);

        Dao<Zadania, Integer> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), Zadania.class);

        if(startButton.getText().equals("Zakończ")){
            zadanie.get(0).setZaliczenie("Zaliczone");
            zadanie.get(0).setBledy(bledy);
            dao.update(zadanie.get(0));
        }

        if(startButton.getText().equals("Dalej")){
            licznik++;

                switch (licznik){
                    case 2:
                         textAreaKlient.setText(zadanie.get(0).getWeryfikacja2());
                         radioA.setText(zadanie.get(0).getWeryfikacja2_odp_a());
                         radioB.setText(zadanie.get(0).getWeryfikacja2_odp_b());
                         radioC.setText(zadanie.get(0).getWeryfikacja2_odp_c());
                         radioA.setStyle("-fx-text-fill: white;");
                         radioB.setStyle("-fx-text-fill: white;");
                         radioC.setStyle("-fx-text-fill: white;");
                         startButton.setDisable(true);
                         cofnijButton.setDisable(false);
                         startButton.setText("Dalej");
                         licznikLabel.setText(licznik + "/4");
                         break;
                    case 3:
                         textAreaKlient.setText(zadanie.get(0).getWeryfikacja3());
                         radioA.setText(zadanie.get(0).getWeryfikacja3_odp_a());
                         radioB.setText(zadanie.get(0).getWeryfikacja3_odp_b());
                         radioC.setText(zadanie.get(0).getWeryfikacja3_odp_c());
                         radioA.setStyle("-fx-text-fill: white;");
                         radioB.setStyle("-fx-text-fill: white;");
                         radioC.setStyle("-fx-text-fill: white;");
                         startButton.setDisable(true);
                         startButton.setText("Dalej");
                         licznikLabel.setText(licznik + "/4");
                         break;
                    case 4:
                        textAreaKlient.setText(zadanie.get(0).getTemat());
                        radioA.setText(zadanie.get(0).getTemat_odp_a());
                        radioB.setText(zadanie.get(0).getTemat_odp_b());
                        radioC.setText(zadanie.get(0).getTemat_odp_c());
                        radioA.setStyle("-fx-text-fill: white;");
                        radioB.setStyle("-fx-text-fill: white;");
                        radioC.setStyle("-fx-text-fill: white;");
                        startButton.setDisable(true);
                        startButton.setText("Zakończ");
                        licznikLabel.setText(licznik + "/4");
                        break;
            }

        } else {

            licznik = 1;

            licznikLabel.setVisible(true);
            textAreaKlient.setVisible(true);
            radioA.setVisible(true);
            radioB.setVisible(true);
            radioC.setVisible(true);
            aktualnyKlientLabel.setVisible(true);
            wybierzLabel.setVisible(true);
            cofnijButton.setVisible(true);
            cofnijButton.setDisable(true);
            radioA.setStyle("-fx-text-fill: white;");
            radioB.setStyle("-fx-text-fill: white;");
            radioC.setStyle("-fx-text-fill: white;");
            int upperbound = 3;
            int_random = rand.nextInt(upperbound) + 1;

            isAny = dao.queryForEq("ZALICZENIE", "Brak");
            if(isAny.isEmpty()){
                startButton.setDisable(true);
                radioA.setDisable(true);
                radioB.setDisable(true);
                radioC.setDisable(true);
                Alert alert1 = new Alert(Alert.AlertType.NONE);
                alert1.setAlertType(Alert.AlertType.INFORMATION);
                alert1.setTitle("Powiadomienie");
                alert1.setHeaderText("Wszystkie sprawy rozwiązane.");
                alert1.setContentText("Rozwiązałeś już wszystkie dostępne sprawy, jeżeli chcesz rozwiązać je jeszcze raz przejdź do sekcji Postępy na ekranie startowym.");
                DialogPane dialogPane = alert1.getDialogPane();
                dialogPane.setStyle(
                        "  -fx-base: #242424 ;\n" +
                                "  -fx-control-inner-background: derive(-fx-base,20%);\n" +
                                "  -fx-control-inner-background-alt: derive(-fx-control-inner-background,-10%);\n" +
                                "  -fx-accent: #006689;\n" +
                                "  -fx-focus-color: #036E83;\n" +
                                "  -fx-faint-focus-color: #036E8322;");
                alert1.show();
                return;
            }

            zadanie = dao.queryForEq("Id", int_random);

            if(!zadanie.get(0).getZaliczenie().equals("Brak")) {
                while (!zadanie.get(0).getZaliczenie().equals("Brak")) {
                    int_random = rand.nextInt(upperbound) + 1;

                    zadanie = dao.queryForEq("Id", int_random);
                }
            }

            licznikLabel.setText(licznik + "/4");
            textAreaKlient.setText(zadanie.get(0).getWeryfikacja());
            radioA.setText(zadanie.get(0).getWeryfikacja_odp_a());
            radioB.setText(zadanie.get(0).getWeryfikacja_odp_b());
            radioC.setText(zadanie.get(0).getWeryfikacja_odp_c());

            startButton.setText("Dalej");
            startButton.setDisable(true);
        }
    }

    public void radioAAction(){

        switch (licznik){
            case 1:
                  if(zadanie.get(0).getWeryfikacja_odp_poprawna().equals(radioA.getText().replace("\n", ""))){
                       startButton.setDisable(false);
                       radioA.setStyle("-fx-text-fill: green;");
                       break;
                  } else {
                      startButton.setDisable(true);
                      radioA.setStyle("-fx-text-fill: red;");
                      bledy++;
                      break;
                  }
            case 2:
                if(zadanie.get(0).getWeryfikacja2_odp_poprawna().equals(radioA.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioA.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioA.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 3:
                if(zadanie.get(0).getWeryfikacja3_odp_poprawna().equals(radioA.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioA.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioA.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 4:
                if(zadanie.get(0).getTemat_odp_poprawna().equals(radioA.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioA.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioA.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
        }
    }

    public void radioBAction(){

        switch (licznik){
            case 1:
                if(zadanie.get(0).getWeryfikacja_odp_poprawna().equals(radioB.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioB.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioB.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 2:
                if(zadanie.get(0).getWeryfikacja2_odp_poprawna().equals(radioB.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioB.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioB.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 3:
                if(zadanie.get(0).getWeryfikacja3_odp_poprawna().equals(radioB.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioB.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioB.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 4:
                if(zadanie.get(0).getTemat_odp_poprawna().equals(radioB.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioB.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioB.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
        }
    }

    public void radioCAction(){

        switch (licznik){
            case 1:
                if(zadanie.get(0).getWeryfikacja_odp_poprawna().equals(radioC.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioC.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioC.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 2:
                if(zadanie.get(0).getWeryfikacja2_odp_poprawna().equals(radioC.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioC.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioC.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 3:
                if(zadanie.get(0).getWeryfikacja3_odp_poprawna().equals(radioC.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioC.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioC.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
            case 4:
                if(zadanie.get(0).getTemat_odp_poprawna().equals(radioC.getText().replace("\n", ""))){
                    startButton.setDisable(false);
                    radioC.setStyle("-fx-text-fill: green;");
                    break;
                } else {
                    startButton.setDisable(true);
                    radioC.setStyle("-fx-text-fill: red;");
                    bledy++;
                    break;
                }
        }
    }

    public void cofnijAction() throws SQLException {

        if(licznik == 2){
            licznik --;
            startButton.setText("Start");
            rozmowaAction();
        } else {
            licznik -= 2;
            startButton.setText("Dalej");
            rozmowaAction();
        }
    }
}
