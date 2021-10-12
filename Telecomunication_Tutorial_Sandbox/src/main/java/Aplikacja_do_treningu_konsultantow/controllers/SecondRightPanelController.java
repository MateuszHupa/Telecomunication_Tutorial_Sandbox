package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.model.Klient;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

public class SecondRightPanelController{

    @FXML
    private VBox secondRightPanel;
    @FXML
    private Label imieField;
    @FXML
    private Label nazwiskoField;
    @FXML
    private Label formaPrawnaField;
    @FXML
    private Label numerDowoduOsobistegoField;
    @FXML
    private Label dataWaznosciDowoduOsobistegoField;
    @FXML
    private Label peselField;
    @FXML
    private Label adresZameldowaniaField;
    @FXML
    private Label numerKontaktowyField;
    @FXML
    private Label emailKontaktowyField;
    @FXML
    private Label emailDoFakturField;
    @FXML
    private Label hasloDoKontaField;

    public void setInfo(List<Klient> klient){

        secondRightPanel.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" + "-fx-border-insets: 5 10 0 0 ;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");

        imieField.setText(klient.get(0).getImie());
        nazwiskoField.setText(klient.get(0).getNazwisko());
        numerDowoduOsobistegoField.setText(klient.get(0).getNumer_dowodu_osobistego());
        dataWaznosciDowoduOsobistegoField.setText(klient.get(0).getData_waznosci_dowodu_osobistego());
        peselField.setText("" + klient.get(0).getPesel());
        adresZameldowaniaField.setText(klient.get(0).getAdres_zameldowania());
        numerKontaktowyField.setText("" + klient.get(0).getNumer_kontaktowy());
        emailKontaktowyField.setText(klient.get(0).getEmail());
        emailDoFakturField.setText(klient.get(0).getEmail_do_faktur());
        hasloDoKontaField.setText(klient.get(0).getHaslo());
        formaPrawnaField.setText(klient.get(0).getForma_prawna());
    }

    public void setInfo2(List<MSISDN> klient){

        secondRightPanel.setStyle("-fx-border-style: solid inside;"
                + "-fx-border-width: 1;" + "-fx-border-insets: 5 10 0 0 ;"
                + "-fx-border-radius: 3;"
                + "-fx-border-color: black;");

        imieField.setText(klient.get(0).getKlient_ID().getImie());
        nazwiskoField.setText(klient.get(0).getKlient_ID().getNazwisko());
        numerDowoduOsobistegoField.setText(klient.get(0).getKlient_ID().getNumer_dowodu_osobistego());
        dataWaznosciDowoduOsobistegoField.setText(klient.get(0).getKlient_ID().getData_waznosci_dowodu_osobistego());
        peselField.setText("" + klient.get(0).getKlient_ID().getPesel());
        adresZameldowaniaField.setText(klient.get(0).getKlient_ID().getAdres_zameldowania());
        numerKontaktowyField.setText("" + klient.get(0).getKlient_ID().getNumer_kontaktowy());
        emailKontaktowyField.setText(klient.get(0).getKlient_ID().getEmail());
        emailDoFakturField.setText(klient.get(0).getKlient_ID().getEmail_do_faktur());
        hasloDoKontaField.setText(klient.get(0).getKlient_ID().getHaslo());
        formaPrawnaField.setText(klient.get(0).getKlient_ID().getForma_prawna());
    }

    public void setVisible(boolean b){
        secondRightPanel.setVisible(b);
    }

}
