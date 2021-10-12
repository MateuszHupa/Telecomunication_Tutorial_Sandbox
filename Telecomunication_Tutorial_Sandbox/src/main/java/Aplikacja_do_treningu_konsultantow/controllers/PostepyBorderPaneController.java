package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.Zadania;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostepyBorderPaneController {

    @FXML
    public TableView<Zadania> postepyTableView;
    @FXML
    public Button wyjdzButton;
    @FXML
    public TableColumn<Zadania, String> typColumn;
    @FXML
    public TableColumn<Zadania, String> zaliczenieColumn;
    @FXML
    public TableColumn<Zadania, String> opisColumn;
    @FXML
    public TableColumn<Zadania, Integer> bledyColumn;
    @FXML
    public CheckBox zaliczoneCheckBox;
    @FXML
    public CheckBox nieZaliczoneCheckBox;
    @FXML
    public ComboBox wybierzTypComboBox;
    @FXML
    public Button filtrujButton;
    @FXML
    public Button resetButton;
    TableColumn<Zadania, Void> colBtn = new TableColumn("");
    private SceneController view = new SceneController();

    public void initialize() throws SQLException {
        fillPostepyTable();

        ObservableList<String> typOptions =
                FXCollections.observableArrayList(
                        "Dowolny",
                        "Weryfikacja",
                        "Usługi",
                        "Salda bieżące"
                );
        wybierzTypComboBox.setItems(typOptions);

    }

    private void addButtonToTable(){

        Callback<TableColumn<Zadania, Void>, TableCell<Zadania, Void>> cellFactory = new Callback<TableColumn<Zadania, Void>, TableCell<Zadania, Void>>() {
            @Override
            public TableCell<Zadania, Void> call(final TableColumn<Zadania, Void> param) {
                final TableCell<Zadania, Void> cell = new TableCell<Zadania, Void>() {

                    private final Button btn = new Button("Cofnij zaliczenie");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Zadania zad = getTableView().getItems().get(getIndex());
                            try {
                                Dao<Zadania, ?> dao1 = new DaoManager().createDao(DataBaseManager.getConnectionSource(), Zadania.class);
                                zad.setZaliczenie("Brak");
                                dao1.update(zad);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            postepyTableView.getColumns().remove(colBtn);
                            try {
                                fillPostepyTable();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btn.setFocusTraversable(false);
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        postepyTableView.getColumns().add(colBtn);

    }

    public void fillPostepyTable() throws SQLException {

        Dao<Zadania, ?> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), Zadania.class);
        List<Zadania> wszystkieZadania = dao.queryForAll();
        ObservableList<Zadania> zadaniaPolaczenObservableList = FXCollections.observableArrayList(wszystkieZadania);

        postepyTableView.setItems(zadaniaPolaczenObservableList);
        zaliczenieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getZaliczenie()));
        typColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTyp()));
        opisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpis()));
        bledyColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getBledy()).asObject());

        addButtonToTable();

    }


    public void wyjdzAction(javafx.event.ActionEvent event) throws IOException {
        Parent mainParentScene = FXMLLoader.load(getClass().getResource("/fxml/MenuMainBorderPane.fxml"));
        view.ChangeScene((Stage)((Node)event.getSource()).getScene().getWindow(), mainParentScene);
    }

    public void zaliczoneAction() throws SQLException {

        if (zaliczoneCheckBox.isSelected() && nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            fillPostepyTable();
        }

        if (!zaliczoneCheckBox.isSelected() && !nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            fillPostepyTable();
        }

        if (!zaliczoneCheckBox.isSelected() && nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            niezaliczoneAction();
        }

        if(zaliczoneCheckBox.isSelected() && !nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            Dao<Zadania, ?> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), Zadania.class);
            List<Zadania> wszystkieZadania = dao.queryForEq("ZALICZENIE", "Zaliczone");
            ObservableList<Zadania> zadaniaPolaczenObservableList = FXCollections.observableArrayList(wszystkieZadania);

            postepyTableView.setItems(zadaniaPolaczenObservableList);
            zaliczenieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getZaliczenie()));
            typColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTyp()));
            opisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpis()));

            addButtonToTable();

        }
    }

    public void niezaliczoneAction() throws SQLException {
        if (zaliczoneCheckBox.isSelected() && nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            fillPostepyTable();
        }

        if (!zaliczoneCheckBox.isSelected() && !nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            fillPostepyTable();
        }

        if (!zaliczoneCheckBox.isSelected() && nieZaliczoneCheckBox.isSelected()) {
            postepyTableView.getColumns().remove(colBtn);
            Dao<Zadania, ?> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), Zadania.class);
            List<Zadania> wszystkieZadania = dao.queryForEq("ZALICZENIE", "Brak");
            ObservableList<Zadania> zadaniaPolaczenObservableList = FXCollections.observableArrayList(wszystkieZadania);

            postepyTableView.setItems(zadaniaPolaczenObservableList);
            zaliczenieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getZaliczenie()));
            typColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTyp()));
            opisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpis()));

            addButtonToTable();
        }

        if(zaliczoneCheckBox.isSelected() && !nieZaliczoneCheckBox.isSelected()) {
            zaliczoneAction();
        }
    }

    public void filtrujOnAction() throws ClassNotFoundException, SQLException {

        Zadania databaseQueryResult = new Zadania();
        List<Zadania> zadanie = new ArrayList<>();

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:./teleDB", "admin", "admin");
        Statement statement = connection.createStatement();

        String selectString = "SELECT * FROM ZADANIA";

        if(wybierzTypComboBox.getValue() != null && !wybierzTypComboBox.getValue().equals("Dowolny")){
            selectString += " WHERE TYP='" + wybierzTypComboBox.getValue() + "'";
        }

        if(selectString.equals("SELECT * FROM ZADANIA")){
            postepyTableView.getColumns().remove(colBtn);
            fillPostepyTable();
        } else {
            ResultSet rs = statement.executeQuery(selectString);
            while(rs.next()){
                databaseQueryResult.setBledy(rs.getInt("BLEDY"));
                databaseQueryResult.setId(rs.getInt("ID"));
                databaseQueryResult.setTyp(rs.getString("TYP"));
                databaseQueryResult.setZaliczenie(rs.getString("ZALICZENIE"));
                databaseQueryResult.setOpis(rs.getString("OPIS"));

                zadanie.add(databaseQueryResult);

            }

            ObservableList<Zadania> zadaniaPolaczenObservableList = FXCollections.observableArrayList(zadanie);

            postepyTableView.setItems(zadaniaPolaczenObservableList);
            zaliczenieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getZaliczenie()));
            typColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTyp()));
            opisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpis()));
        }

    }

    public void resetOnAction() throws SQLException {
        postepyTableView.getColumns().remove(colBtn);
        fillPostepyTable();
    }
}
