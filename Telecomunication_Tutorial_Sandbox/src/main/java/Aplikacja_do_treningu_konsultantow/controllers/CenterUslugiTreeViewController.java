package Aplikacja_do_treningu_konsultantow.controllers;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import Aplikacja_do_treningu_konsultantow.database.model.UslugiDodatkowe;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class CenterUslugiTreeViewController {

    @FXML
    private VBox mainVBox;
    @FXML
    private HBox topHBox;
    @FXML
    private VBox centerVBox;
    @FXML
    private TreeView treeViewCenter;
    @FXML
    private CheckBox aktywneCheckbox;
    @FXML
    private CheckBox nieaktywneCheckbox;

    private CenterUslugiPaneController centerUslugiPaneController;
    private List<UslugiDodatkowe> listaUslug;
    private List<MSISDN> nrMsisdn;

    public void setUslugiTreeView(List<MSISDN> msisdn){

        nrMsisdn = msisdn;

        TreeItem rootUslugaItem = new TreeItem("Lista uslug");
        TreeItem uslugaItem = new TreeItem("Minuty");
        TreeItem uslugaItem2 = new TreeItem("SMS");
        TreeItem uslugaItem3 = new TreeItem("GB");
        TreeItem uslugaItem4 = new TreeItem("GBR");
        TreeItem uslugaItem5 = new TreeItem("MMS");

        Dao<UslugiDodatkowe,?> dao = null;
        try {
            dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), UslugiDodatkowe.class);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            listaUslug = dao.queryForEq("OFERTA_ID", msisdn.get(0).getOferta_id());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        listaUslug.forEach(e ->{
            FXMLLoader loader = new FXMLLoader(SecondCenterBorderPaneController.class.getResource("/fxml/CenterUslugiPane.fxml"));
        if(e.getTyp_uslugi().equals("Minuty")){
            try {
                uslugaItem.getChildren().add(new TreeItem(loader.load()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getTyp_uslugi().equals("SMS")){
            try {
                uslugaItem2.getChildren().add(new TreeItem(loader.load()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getTyp_uslugi().equals("MMS")){
            try {
                uslugaItem5.getChildren().add(new TreeItem(loader.load()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getTyp_uslugi().equals("GB")){
            try {
                uslugaItem3.getChildren().add(new TreeItem(loader.load()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getTyp_uslugi().equals("GBR")){
            try {
                uslugaItem4.getChildren().add(new TreeItem(loader.load()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        centerUslugiPaneController = loader.getController();

        try {
            centerUslugiPaneController.setCenterUslugiInfo(e, msisdn.get(0));
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    });

        if (!uslugaItem.isLeaf()) {
            rootUslugaItem.getChildren().add(uslugaItem);
        }
        if (!uslugaItem2.isLeaf()) {
            rootUslugaItem.getChildren().add(uslugaItem2);
        }
        if (!uslugaItem3.isLeaf()) {
            rootUslugaItem.getChildren().add(uslugaItem3);
        }
        if (!uslugaItem4.isLeaf()) {
            rootUslugaItem.getChildren().add(uslugaItem4);
        }
        if (!uslugaItem5.isLeaf()) {
            rootUslugaItem.getChildren().add(uslugaItem5);
        }
        treeViewCenter.setRoot(rootUslugaItem);
        rootUslugaItem.setExpanded(true);
        uslugaItem.setExpanded(true);
        uslugaItem2.setExpanded(true);
        uslugaItem3.setExpanded(true);
        uslugaItem4.setExpanded(true);
        uslugaItem5.setExpanded(true);

    }

    public void aktywneUslugiFilter() throws SQLException, ClassNotFoundException {

        if (aktywneCheckbox.isSelected() && nieaktywneCheckbox.isSelected()) {
            setUslugiTreeView(nrMsisdn);
        }

        if (!aktywneCheckbox.isSelected() && !nieaktywneCheckbox.isSelected()) {
            setUslugiTreeView(nrMsisdn);
        }

        if (!aktywneCheckbox.isSelected() && nieaktywneCheckbox.isSelected()) {
            nieaktywneUslugiFilter();
        }

        if(aktywneCheckbox.isSelected() && !nieaktywneCheckbox.isSelected()){

            TreeItem rootUslugaItem = new TreeItem("Lista uslug");
            TreeItem uslugaItem = new TreeItem("Minuty");
            TreeItem uslugaItem2 = new TreeItem("SMS");
            TreeItem uslugaItem3 = new TreeItem("GB");
            TreeItem uslugaItem4 = new TreeItem("GBR");
            TreeItem uslugaItem5 = new TreeItem("MMS");

            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:./teleDB", "admin", "admin");
            Statement statement = connection.createStatement();


            Dao<UslugiDodatkowe, ?> dao = null;
            try {
                dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), UslugiDodatkowe.class);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                listaUslug = dao.queryForEq("OFERTA_ID", nrMsisdn.get(0).getOferta_id());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            listaUslug.forEach(e -> {
                FXMLLoader loader = new FXMLLoader(SecondCenterBorderPaneController.class.getResource("/fxml/CenterUslugiPane.fxml"));
                int i = 0;

                if (e.getTyp_uslugi().equals("Minuty")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getTyp_uslugi().equals("SMS")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem2.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }

                if (e.getTyp_uslugi().equals("MMS")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem5.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getTyp_uslugi().equals("GB")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem3.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getTyp_uslugi().equals("GBR")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem4.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (i == 1) {
                    centerUslugiPaneController = loader.getController();

                    try {
                        centerUslugiPaneController.setCenterUslugiInfo(e, nrMsisdn.get(0));
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            if (!uslugaItem.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem);
            }
            if (!uslugaItem2.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem2);
            }
            if (!uslugaItem3.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem3);
            }
            if (!uslugaItem4.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem4);
            }
            if (!uslugaItem5.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem5);
            }
            treeViewCenter.setRoot(rootUslugaItem);
            rootUslugaItem.setExpanded(true);
            uslugaItem.setExpanded(true);
            uslugaItem2.setExpanded(true);
            uslugaItem3.setExpanded(true);
            uslugaItem4.setExpanded(true);
            uslugaItem5.setExpanded(true);

        }
    }

    public void nieaktywneUslugiFilter() throws SQLException, ClassNotFoundException {

        if (aktywneCheckbox.isSelected() && nieaktywneCheckbox.isSelected()) {
            setUslugiTreeView(nrMsisdn);
        }

        if (!aktywneCheckbox.isSelected() && !nieaktywneCheckbox.isSelected()) {
            setUslugiTreeView(nrMsisdn);
        }

        if (aktywneCheckbox.isSelected() && !nieaktywneCheckbox.isSelected()) {
            aktywneUslugiFilter();
        }

        if (!aktywneCheckbox.isSelected() && nieaktywneCheckbox.isSelected()) {

            TreeItem rootUslugaItem = new TreeItem("Lista uslug");
            TreeItem uslugaItem = new TreeItem("Minuty");
            TreeItem uslugaItem2 = new TreeItem("SMS");
            TreeItem uslugaItem3 = new TreeItem("GB");
            TreeItem uslugaItem4 = new TreeItem("GBR");
            TreeItem uslugaItem5 = new TreeItem("MMS");

            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:./teleDB", "admin", "admin");
            Statement statement = connection.createStatement();


            Dao<UslugiDodatkowe, ?> dao = null;
            try {
                dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), UslugiDodatkowe.class);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                listaUslug = dao.queryForEq("OFERTA_ID", nrMsisdn.get(0).getOferta_id());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            listaUslug.forEach(e -> {
                FXMLLoader loader = new FXMLLoader(SecondCenterBorderPaneController.class.getResource("/fxml/CenterUslugiPane.fxml"));
                int i = 0;

                if (e.getTyp_uslugi().equals("Minuty")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (!rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            i = 1;
                            try {
                                uslugaItem.getChildren().add(new TreeItem(loader.load()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getTyp_uslugi().equals("SMS")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (!rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem2.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            i = 1;
                            try {
                                uslugaItem2.getChildren().add(new TreeItem(loader.load()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }

                if (e.getTyp_uslugi().equals("MMS")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (!rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem5.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            i = 1;
                            try {
                                uslugaItem5.getChildren().add(new TreeItem(loader.load()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getTyp_uslugi().equals("GB")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (!rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem3.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            i = 1;
                            try {
                                uslugaItem3.getChildren().add(new TreeItem(loader.load()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (e.getTyp_uslugi().equals("GBR")) {

                    try {
                        ResultSet rs = statement.executeQuery("SELECT * FROM USLUGI_DODATKOWE_LISTA WHERE MSISDN_ID=" + nrMsisdn.get(0).getId() + " AND USLUGI_DODATKOWE_ID=" + e.getId());

                        if (rs.next()) {
                            if (!rs.getString("STAN").equals("Aktywna")) {
                                i = 1;
                                try {
                                    uslugaItem4.getChildren().add(new TreeItem(loader.load()));
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            i = 1;
                            try {
                                uslugaItem4.getChildren().add(new TreeItem(loader.load()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                if (i == 1) {
                    centerUslugiPaneController = loader.getController();

                    try {
                        centerUslugiPaneController.setCenterUslugiInfo(e, nrMsisdn.get(0));
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            if (!uslugaItem.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem);
            }
            if (!uslugaItem2.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem2);
            }
            if (!uslugaItem3.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem3);
            }
            if (!uslugaItem4.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem4);
            }
            if (!uslugaItem5.isLeaf()) {
                rootUslugaItem.getChildren().add(uslugaItem5);
            }
            treeViewCenter.setRoot(rootUslugaItem);
            rootUslugaItem.setExpanded(true);
            uslugaItem.setExpanded(true);
            uslugaItem2.setExpanded(true);
            uslugaItem3.setExpanded(true);
            uslugaItem4.setExpanded(true);
            uslugaItem5.setExpanded(true);


        }
    }
}
