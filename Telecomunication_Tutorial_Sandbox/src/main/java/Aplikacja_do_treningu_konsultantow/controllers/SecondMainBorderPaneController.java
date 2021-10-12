package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.Main;
import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.Klient;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SecondMainBorderPaneController {

    @FXML
    public HBox klientRequestHBox;
    @FXML
    public HBox klientInfoHBox;
    private Main maine = new Main();
    @FXML
    private BorderPane secondMainBorderPane;
    @FXML
    private TextField searchText;
    @FXML
    private TreeView treeView;
    @FXML
    private Label dekalogLabel;
    @FXML
    private VBox rightVBox;
    private SceneController view = new SceneController();
    private List<Klient> klient;
    private List<MSISDN> msisdns;
    private SecondRightPanelController secondRightPanelController;
    private SecondCenterBorderPaneController secondCenterBorderPaneController;

    public void initialize() throws IOException {

        secondMainBorderPane.setStyle(
                "  -fx-base: #242424 ;\n" +
                        "  -fx-control-inner-background: derive(-fx-base,20%);\n" +
                        "  -fx-control-inner-background-alt: derive(-fx-control-inner-background,-10%);\n" +
                        "  -fx-accent: #006689;\n" +
                        "  -fx-focus-color: #036E83;\n" +
                        "  -fx-faint-focus-color: #036E8322;");

        treeView.setStyle(
                "  -fx-base: #242424 ;\n" +
                        "  -fx-control-inner-background: derive(-fx-base,20%);\n" +
                        "  -fx-control-inner-background-alt: derive(-fx-control-inner-background,-10%);\n" +
                        "  -fx-accent: #006689;\n" +
                        "  -fx-focus-color: #036E83;\n" +
                        "  -fx-faint-focus-color: #036E8322;");

        searchText.setStyle("-fx-prompt-text-fill: white;");

        FXMLLoader loaderXXX = new FXMLLoader(SecondMainBorderPaneController.class.getResource("/fxml/SecondMainKlientRequestPane.fxml"));
        klientRequestHBox.getChildren().add(loaderXXX.load());
    }

    public void OpenCRM() throws IOException, SQLException {

        searchText.setText("");
        searchButtonOnAction();

    }

    public void OpenInfo( ) {

        maine.pdfShow();

    }

    @FXML
    public void GoBack(javafx.event.ActionEvent event) throws IOException {
        Parent mainParentScene = FXMLLoader.load(getClass().getResource("/fxml/MenuMainBorderPane.fxml"));
        view.ChangeScene((Stage)((Node)event.getSource()).getScene().getWindow(), mainParentScene);
    }

    public void Search(KeyEvent keyEvent) throws SQLException, IOException {

        if(keyEvent.getCode() == KeyCode.ENTER){
            searchButtonOnAction();
        }
    }

    public void searchButtonOnAction( ) throws SQLException, IOException {

        klientInfoHBox.getChildren().clear();

        dekalogLabel.setVisible(false);
        if(secondCenterBorderPaneController != null){
        secondCenterBorderPaneController.setVisible(false);}

        int textLength = searchText.getText().length();
        Dao<Klient,?> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), Klient.class);
        Dao<MSISDN,?> dao2 = new DaoManager().createDao(DataBaseManager.getConnectionSource(), MSISDN.class);

        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            try {
                handleMouseClicked(event);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };

        FXMLLoader loader = new FXMLLoader(SecondMainBorderPaneController.class.getResource("/fxml/SecondRightPanel.fxml"));

        switch(textLength){
            case 11:
                klientInfoHBox.getChildren().add(loader.load());

                secondRightPanelController = loader.getController();

                klient = dao.queryForEq("PESEL", searchText.getText());
                secondRightPanelController.setInfo(klient);

                msisdns = dao2.queryForEq("KLIENT_ID", klient.get(0).getId());

                TreeItem rootItem = new TreeItem("Numer konta: " + klient.get(0).getNumer_klienta());
                TreeItem ofertaItem = new TreeItem("Postpaid");
                TreeItem ofertaItem2 = new TreeItem("Prepaid");

                msisdns.forEach(e ->{

                    if(e.getOferta_id().getRodzaj_oferty().equals("prepaid")){
                        ofertaItem2.getChildren().add(new TreeItem(e.getNumer_telefonu()));
                    } else {
                        ofertaItem.getChildren().add(new TreeItem(e.getNumer_telefonu()));
                    }
                });

                rootItem.getChildren().add(ofertaItem2);
                rootItem.getChildren().add(ofertaItem);
                treeView.setRoot(rootItem);
                rootItem.setExpanded(true);

                treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
                treeView.setVisible(true);
                secondRightPanelController.setVisible(true);
                secondMainBorderPane.setCenter(dekalogLabel);
                dekalogLabel.setVisible(true);
                break;
            case 9:
                klientInfoHBox.getChildren().add(loader.load());

                secondRightPanelController = loader.getController();

                msisdns = dao2.queryForEq("NUMER_TELEFONU", searchText.getText());
                secondRightPanelController.setInfo2(msisdns);
                String ofertaToExpand = msisdns.get(0).getOferta_id().getRodzaj_oferty();

                TreeItem rootItem2 = new TreeItem("Numer konta: " + msisdns.get(0).getKlient_ID().getNumer_klienta());
                TreeItem ofertaItem4 = new TreeItem("Postpaid");
                TreeItem ofertaItem3 = new TreeItem("Prepaid");

                msisdns = dao2.queryForEq("KLIENT_ID", msisdns.get(0).getKlient_ID());

                msisdns.forEach(e ->{
                    if(e.getOferta_id().getRodzaj_oferty().equals("prepaid")){
                        ofertaItem3.getChildren().add(new TreeItem(e.getNumer_telefonu()));
                    } else {
                        ofertaItem4.getChildren().add(new TreeItem(e.getNumer_telefonu()));
                    }
                });

                rootItem2.getChildren().add(ofertaItem3);
                rootItem2.getChildren().add(ofertaItem4);
                treeView.setRoot(rootItem2);

                if(ofertaToExpand.equals("prepaid")){
                    rootItem2.setExpanded(true);
                    ofertaItem3.setExpanded(true);
                } else{
                    rootItem2.setExpanded(true);
                    ofertaItem4.setExpanded(true);
                }

                treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
                treeView.setVisible(true);
                secondRightPanelController.setVisible(true);
                secondMainBorderPane.setCenter(dekalogLabel);
                dekalogLabel.setVisible(true);
                break;
            case 6:
               // secondMainBorderPane.setRight(loader.load());
               // rightVBox.getChildren().add(loader.load());
                klientInfoHBox.getChildren().add(loader.load());

                secondRightPanelController = loader.getController();

                klient = dao.queryForEq("NUMER_KLIENTA", searchText.getText());
                secondRightPanelController.setInfo(klient);

                msisdns = dao2.queryForEq("KLIENT_ID", klient.get(0).getId());

                TreeItem rootItem3 = new TreeItem("Numer konta: " + klient.get(0).getNumer_klienta());
                TreeItem ofertaItem5 = new TreeItem("Postpaid");
                TreeItem ofertaItem6 = new TreeItem("Prepaid");

                msisdns.forEach(e ->{
                    if(e.getOferta_id().getRodzaj_oferty().equals("prepaid")){
                        ofertaItem6.getChildren().add(new TreeItem(e.getNumer_telefonu()));
                    } else {
                        ofertaItem5.getChildren().add(new TreeItem(e.getNumer_telefonu()));
                    }
                });

                rootItem3.getChildren().add(ofertaItem6);
                rootItem3.getChildren().add(ofertaItem5);
                treeView.setRoot(rootItem3);
                rootItem3.setExpanded(true);

                treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
                treeView.setVisible(true);
                secondRightPanelController.setVisible(true);
                secondMainBorderPane.setCenter(dekalogLabel);
                dekalogLabel.setVisible(true);
                break;
            case 0:
                treeView.setVisible(false);
                secondMainBorderPane.setCenter(dekalogLabel);
                dekalogLabel.setVisible(true);
              //  secondRightPanelController.setVisible(false);
              //  secondCenterBorderPaneController.setVisible(false);
                break;
            default:
                Alert alert1 = new Alert(Alert.AlertType.NONE);
                alert1.setAlertType(Alert.AlertType.INFORMATION);
                alert1.setTitle("Powiadomienie");
                alert1.setHeaderText("Błędne dane");
                alert1.setContentText("Podane dane są nieprawidłowe lub nie ma ich w bazie, podaj prawidłowy numer telefonu, pesel lub numer konta.");
                DialogPane dialogPane = alert1.getDialogPane();
                dialogPane.setStyle(
                        "  -fx-base: #242424 ;\n" +
                                "  -fx-control-inner-background: derive(-fx-base,20%);\n" +
                                "  -fx-control-inner-background-alt: derive(-fx-control-inner-background,-10%);\n" +
                                "  -fx-accent: #006689;\n" +
                                "  -fx-focus-color: #036E83;\n" +
                                "  -fx-faint-focus-color: #036E8322;");
                alert1.show();

                treeView.setVisible(false);
                secondMainBorderPane.setCenter(dekalogLabel);
                dekalogLabel.setVisible(true);
               // secondRightPanelController.setVisible(false);
               // secondCenterBorderPaneController.setVisible(false);
                break;
        }
    }

    private void handleMouseClicked(MouseEvent event) throws IOException, SQLException {
        Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)treeView.getSelectionModel().getSelectedItem()).getValue();
           // System.out.println("Node click: " + name);

            if(name.length() == 9) {
                FXMLLoader loader = new FXMLLoader(SecondMainBorderPaneController.class.getResource("/fxml/SecondCenterBorderPane.fxml"));
                secondMainBorderPane.setCenter(loader.load());
                secondCenterBorderPaneController = loader.getController();
                secondCenterBorderPaneController.setVisible(true);
                secondCenterBorderPaneController.setPhoneNumberData(name);
            }
        }
    }
}
