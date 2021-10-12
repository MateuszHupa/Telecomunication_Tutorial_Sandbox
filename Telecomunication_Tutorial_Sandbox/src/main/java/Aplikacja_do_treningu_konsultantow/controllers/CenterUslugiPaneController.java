package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import Aplikacja_do_treningu_konsultantow.database.model.UslugiDodatkowe;
import Aplikacja_do_treningu_konsultantow.database.model.UslugiDodatkoweLista;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CenterUslugiPaneController {

    @FXML
    private VBox szablonUslugi;
    @FXML
    private Label centerNazwaPakietu;
    @FXML
    private Label centerUslugiCenaLabel;
    @FXML
    private Button centerUslugiButton;
    @FXML
    private Label centerUslugiOpis;

    private MSISDN phoneNumber;
    private UslugiDodatkowe uslugaDodatkowa;

    public void setCenterUslugiInfo(UslugiDodatkowe usluga, MSISDN msisdn) throws SQLException, ClassNotFoundException {

        uslugaDodatkowa = usluga;
        phoneNumber = msisdn;

        centerNazwaPakietu.setText(usluga.getNazwa_uslugi());
        centerUslugiCenaLabel.setText(usluga.getCena() + " zł");
        centerUslugiOpis.setText(usluga.getOpis());

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:./teleDB", "admin", "admin");
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + phoneNumber.getId() + " AND USLUGI_DODATKOWE_ID=" + usluga.getId());

        if(rs.next()){
            if(rs.getString("STAN").equals("Aktywna")){
                centerUslugiButton.setText("Dezaktywuj");
            } else {
                centerUslugiButton.setText("Aktywuj");
            }
        } else {
            centerUslugiButton.setText("Aktywuj");
        }

        DataBaseManager.closeConectionSource();
    }

    public void buttonOnAction() throws SQLException, ClassNotFoundException {

        Alert alert1 = new Alert(Alert.AlertType.NONE);
        UslugiDodatkoweLista usluga = new UslugiDodatkoweLista();

        Dao<UslugiDodatkoweLista,?> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), UslugiDodatkoweLista.class);
        Dao<MSISDN, ?> dao_msisdn = new DaoManager().createDao(DataBaseManager.getConnectionSource(), MSISDN.class);

        if(phoneNumber.getOferta_id().getRodzaj_oferty().equals("prepaid")){

            if(Integer.parseInt(phoneNumber.getStan_konta()) >= Integer.parseInt(uslugaDodatkowa.getCena())){
                Integer wynik = Integer.parseInt(phoneNumber.getStan_konta()) - Integer.parseInt(uslugaDodatkowa.getCena());
                phoneNumber.setStan_konta("" + wynik);
                dao_msisdn.update(phoneNumber);
            } else {
                alert1.setAlertType(Alert.AlertType.WARNING);
                alert1.setTitle("Ostrzeżenie");
                alert1.setHeaderText("Zbyt niski stan konta");
                alert1.setContentText("Klient nie posiada wystarczających środków na koncie, zaproponuj doładowanie konta lub inny pakiet");
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

        } else {

            Integer wynik = Integer.parseInt(phoneNumber.getStan_konta()) + Integer.parseInt(uslugaDodatkowa.getCena());
            phoneNumber.setStan_konta("" + wynik);

        }



        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:./teleDB", "admin", "admin");
        Statement statement = connection.createStatement();

        Integer amountNow;

        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + phoneNumber.getId() + " AND USLUGI_DODATKOWE_ID=" + uslugaDodatkowa.getId());
          if (rs.next()) {
              if (rs.getString("STAN").equals("Aktywna")) {

                  usluga.setId(rs.getInt("ID"));
                  usluga.setStan("Nieaktywna");
                  usluga.setUslugi_dodatkowe_id(uslugaDodatkowa);
                  usluga.setMsisdn(phoneNumber);
                  usluga.setData_aktywacji(rs.getString("DATA_AKTYWACJI"));
                  usluga.setRodzaj_aktywacji(rs.getString("RODZAJ_AKTYWACJI"));
                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                  LocalDateTime now = LocalDateTime.now();
                  usluga.setData_wylaczenia(dtf.format(now));
                  dao.update(usluga);

                  if(uslugaDodatkowa.getTyp_uslugi().equals("GB")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_gb().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_gb()) - Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_gb("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_gb("0");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("GBR")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_gbr().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_gbr()) - Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_gbr("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      } }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("Minuty")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_minuty().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_minuty()) - Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_minuty("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_minuty("0");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("SMS")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_sms().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_sms()) - Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_sms("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_sms("0");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("SMS")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_mms().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_mms()) - Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_mms("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_mms("0");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  centerUslugiButton.setText("Aktywuj");
                  System.out.println("Usluga w bazie, powinno byc dezaktywuj, po aktywuj");

              } else {

                  usluga.setId(rs.getInt("ID"));
                  usluga.setStan("Aktywna");
                  usluga.setUslugi_dodatkowe_id(uslugaDodatkowa);
                  usluga.setMsisdn(phoneNumber);

                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                  LocalDateTime now = LocalDateTime.now();
                  usluga.setData_aktywacji(dtf.format(now));

                  LocalDate futureDate = LocalDate.now().plusMonths(1);
                  usluga.setData_wylaczenia(dtf.format(futureDate));
                  usluga.setRodzaj_aktywacji("Aktywacja TELE");
                  dao.update(usluga);

                  if(uslugaDodatkowa.getTyp_uslugi().equals("GB")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_gb().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_gb()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_gb("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_gb("Nielimitowane");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("GBR")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_gbr().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_gbr()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_gbr("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      } }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("Minuty")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_minuty().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_minuty()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_minuty("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_minuty("Nielimitowane");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("SMS")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_sms().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_sms()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_sms("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_sms("Nielimitowane");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  if(uslugaDodatkowa.getTyp_uslugi().equals("SMS")) {
                      if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_mms().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_mms()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_mms("" + amountNow);
                          dao_msisdn.update(phoneNumber);
                      }
                      if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                          phoneNumber.getOferta_id().getTaryfa().setDarmowe_mms("Nielimitowane");
                          dao_msisdn.update(phoneNumber);
                      }
                  }

                  centerUslugiButton.setText("Dezaktywuj");
                  System.out.println("Usluga w bazie, powinno byc aktywuj, po dezaktywuj ");

              }
          } else {

              usluga.setStan("Aktywna");
              usluga.setUslugi_dodatkowe_id(uslugaDodatkowa);
              usluga.setMsisdn(phoneNumber);

              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
              LocalDateTime now = LocalDateTime.now();
              usluga.setData_aktywacji(dtf.format(now));

              LocalDate futureDate = LocalDate.now().plusMonths(1);
              usluga.setData_wylaczenia(dtf.format(futureDate));

              usluga.setRodzaj_aktywacji("Aktywacja TELE");
              dao.create(usluga);

              if(uslugaDodatkowa.getTyp_uslugi().equals("GB")) {
                  if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_gb().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_gb()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_gb("" + amountNow);
                      dao_msisdn.update(phoneNumber);
                  }
                  if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_gb("Nielimitowane");
                      dao_msisdn.update(phoneNumber);
                  }
              }

              if(uslugaDodatkowa.getTyp_uslugi().equals("GBR")) {
                  if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_gbr().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_gbr()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_gbr("" + amountNow);
                      dao_msisdn.update(phoneNumber);
                  } }

              if(uslugaDodatkowa.getTyp_uslugi().equals("Minuty")) {
                  if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_minuty().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_minuty()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_minuty("" + amountNow);
                      dao_msisdn.update(phoneNumber);
                  }
                  if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_minuty("Nielimitowane");
                      dao_msisdn.update(phoneNumber);
                  }
              }

              if(uslugaDodatkowa.getTyp_uslugi().equals("SMS")) {
                  if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_sms().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_sms()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_sms("" + amountNow);
                      dao_msisdn.update(phoneNumber);
                  }
                  if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_sms("Nielimitowane");
                      dao_msisdn.update(phoneNumber);
                  }
              }

              if(uslugaDodatkowa.getTyp_uslugi().equals("SMS")) {
                  if(!phoneNumber.getOferta_id().getTaryfa().getDarmowe_mms().equals("Nielimitowane") && !uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      amountNow = Integer.parseInt(phoneNumber.getOferta_id().getTaryfa().getDarmowe_mms()) + Integer.parseInt(uslugaDodatkowa.getWysokosc_pakietu());
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_mms("" + amountNow);
                      dao_msisdn.update(phoneNumber);
                  }
                  if(uslugaDodatkowa.getWysokosc_pakietu().equals("Nielimitowane")){
                      phoneNumber.getOferta_id().getTaryfa().setDarmowe_mms("Nielimitowane");
                      dao_msisdn.update(phoneNumber);
                  }
              }

              centerUslugiButton.setText("Dezaktywuj");
              System.out.println("Brak uslugi, powinien byc button aktywuj a po dezaktywuj");

          }

        DataBaseManager.closeConectionSource();
    }


}
