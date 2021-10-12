package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CenterSaldaPaneController {

    @FXML
    private Label stanKontaLabel;
    @FXML
    private Label stanKontaField;
    @FXML
    private Label waznoscPolWychodzacychField;
    @FXML
    private Label waznoscPolaczenPrzychodzacychField;
    @FXML
    private Label dataRozpoczeciaUmowyField;
    @FXML
    private Label dataZakonczeniaUmowyField;
    @FXML
    private Label okresRozliczeniowyField;
    @FXML
    private Label segmentUtrzymaniowyField;
    @FXML
    private Label darmoweMinutyField;
    @FXML
    private Label darmoweSmsField;
    @FXML
    private Label liczbaGbField;
    @FXML
    private Label darmoweMmsField;
    @FXML
    private Label liczbaGbRoamingField;

    public void setSaldaData(MSISDN msisdn){

        if(msisdn.getOferta_id().getRodzaj_oferty().equals("postpaid")){
            stanKontaLabel.setText("Kwota do zapłaty: ");
            waznoscPolWychodzacychField.setText("Bez limitu");
            waznoscPolaczenPrzychodzacychField.setText("Bez limitu");
            dataZakonczeniaUmowyField.setText(msisdn.getData_zakonczenia_umowy());
            okresRozliczeniowyField.setText(msisdn.getKlient_ID().getOkres_rozliczeniowy());
            darmoweMinutyField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_minuty());
            darmoweSmsField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_sms());
            liczbaGbField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_gb());
            darmoweMmsField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_mms());
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate futureDate = LocalDate.now().plusMonths(1);
            waznoscPolWychodzacychField.setText(dtf.format(futureDate));

            LocalDate futureDate2 = LocalDate.now().plusMonths(3);
            waznoscPolaczenPrzychodzacychField.setText(dtf.format(futureDate2));

            dataZakonczeniaUmowyField.setText(msisdn.getData_zakonczenia_umowy());
            okresRozliczeniowyField.setText(msisdn.getKlient_ID().getOkres_rozliczeniowy());
            darmoweMinutyField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_minuty());
            darmoweSmsField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_sms());
            liczbaGbField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_gb());
            darmoweMmsField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_mms());
        }

        stanKontaField.setText(msisdn.getStan_konta() + " zł");
        dataRozpoczeciaUmowyField.setText(msisdn.getData_rozpoczecia_umowy());
        segmentUtrzymaniowyField.setText(msisdn.getSegment_utrzymaniowy());
        liczbaGbRoamingField.setText(msisdn.getOferta_id().getTaryfa().getDarmowe_gbr());
    }

}
