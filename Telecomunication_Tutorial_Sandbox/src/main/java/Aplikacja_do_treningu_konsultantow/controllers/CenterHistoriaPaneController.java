package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.HistoriaPolaczen;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CenterHistoriaPaneController {

    @FXML
    private TableView<HistoriaPolaczen> historiaTable;
    @FXML
    private TableColumn<HistoriaPolaczen, String> rodzajColumn;
    @FXML
    private TableColumn<HistoriaPolaczen, String> kierunekColumn;
    @FXML
    private TableColumn<HistoriaPolaczen, String> numerColumn;
    @FXML
    private TableColumn<HistoriaPolaczen, String> dataColumn;
    @FXML
    private TableColumn<HistoriaPolaczen, String> wykorzystanieColumn;
    @FXML
    private TableColumn<HistoriaPolaczen, String> oplataColumn;
    @FXML
    private ComboBox rodzajComboBox;
    @FXML
    private ComboBox kierunekComboBox;
    @FXML
    private TextField numerTextfield;
    @FXML
    private Button filtrujButton;
    @FXML
    private Button resetButton;
    @FXML
    private DatePicker dataDatePicker;

    private MSISDN phoneNumber;

    public void initialize(){
        ObservableList<String> rodzajOptions =
                FXCollections.observableArrayList(
                        "Dowolny",
                        "Polaczenie glosowe",
                        "SMS",
                        "MMS",
                        "GB",
                        "GBR"
                );
        rodzajComboBox.setItems(rodzajOptions);

        ObservableList<String> kierunekOptions =
                FXCollections.observableArrayList(
                        "Dowolny",
                        "Wychodzace",
                        "Przychodzace"
                );
        kierunekComboBox.setItems(kierunekOptions);
        numerTextfield.setStyle("-fx-prompt-text-fill: white;");
        dataDatePicker.getEditor().setStyle("-fx-prompt-text-fill: white;");
    }

    public void fillTable(MSISDN msisdn) throws SQLException {
        phoneNumber = msisdn;

        Dao<HistoriaPolaczen, ?> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), HistoriaPolaczen.class);
        List<HistoriaPolaczen> historiaPolaczen = dao.queryForEq("MSISDN_ID", msisdn);
        ObservableList<HistoriaPolaczen> historiaPolaczenObservableList = FXCollections.observableArrayList(historiaPolaczen);

        historiaTable.setItems(historiaPolaczenObservableList);
        rodzajColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRodzaj()));
        dataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData()));
        wykorzystanieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWykorzystane_jednostki()));
        oplataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOplata()));
        numerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDrugi_numer()));
        kierunekColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKierunek()));
    }

    public void FlirtujTeraz() throws ClassNotFoundException, SQLException {

        List<HistoriaPolaczen> historiaPolaczen = new ArrayList<>();
        HistoriaPolaczen databaseQueryResult = new HistoriaPolaczen();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:./teleDB", "admin", "admin");
        Statement statement = connection.createStatement();

        String selectString = "SELECT * FROM HISTORIA_POLACZEN WHERE MSISDN_ID=" + phoneNumber.getId();

        if(kierunekComboBox.getValue() != null && !kierunekComboBox.getValue().equals("Dowolny")){
            selectString += " AND KIERUNEK='" + kierunekComboBox.getValue() + "'";
        }
        if(rodzajComboBox.getValue() != null && !rodzajComboBox.getValue().equals("Dowolny")){
            selectString += " AND RODZAJ='" + rodzajComboBox.getValue() + "'";
        }
        if(dataDatePicker.getValue() != null){
            selectString += " AND DATA LIKE'" + dtf.format(dataDatePicker.getValue()) + "%'";
        }
        if(!numerTextfield.getText().equals("")){
            selectString += " AND DRUGI_NUMER LIKE'%" + numerTextfield.getText() + "%'";
        }

        if(selectString.equals("SELECT * FROM HISTORIA_POLACZEN WHERE MSISDN_ID=" + phoneNumber.getId())){
            fillTable(phoneNumber);
        } else {
         ResultSet rs = statement.executeQuery(selectString);
            while(rs.next()){
              databaseQueryResult.setDrugi_numer(rs.getString("DRUGI_NUMER"));
              databaseQueryResult.setId(rs.getInt("ID"));
              databaseQueryResult.setRodzaj(rs.getString("RODZAJ"));
              databaseQueryResult.setKierunek(rs.getString("KIERUNEK"));
              databaseQueryResult.setData(rs.getString("DATA"));
              databaseQueryResult.setOplata(rs.getString("OPLATA"));
              databaseQueryResult.setWykorzystane_jednostki(rs.getString("WYKORZYSTANE_JEDNOSTKI"));

            historiaPolaczen.add(databaseQueryResult);

            }

        ObservableList<HistoriaPolaczen> historiaPolaczenObservableList = FXCollections.observableArrayList(historiaPolaczen);

        historiaTable.setItems(historiaPolaczenObservableList);
        rodzajColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRodzaj()));
        dataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData()));
        wykorzystanieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWykorzystane_jednostki()));
        oplataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOplata()));
        numerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDrugi_numer()));
        kierunekColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKierunek()));
    }}

    public void reset() throws SQLException {
        fillTable(phoneNumber);
    }
}
