package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import Aplikacja_do_treningu_konsultantow.database.model.UslugiDodatkowe;
import Aplikacja_do_treningu_konsultantow.database.model.UslugiDodatkoweLista;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class UslugiDodatkoweListaData {

    public static void loadUslugidodatkoweListaData (ConnectionSource connectionSource) throws SQLException {

        Dao<UslugiDodatkowe, Integer> dao = DaoManager.createDao(connectionSource, UslugiDodatkowe.class);
        Dao<MSISDN, Integer> dao0 = DaoManager.createDao(connectionSource, MSISDN.class);

        UslugiDodatkoweLista uslugiDodatkoweLista1 = new UslugiDodatkoweLista();
        uslugiDodatkoweLista1.setStan("Aktywna");
        uslugiDodatkoweLista1.setUslugi_dodatkowe_id(dao.queryForId(1));
        uslugiDodatkoweLista1.setMsisdn(dao0.queryForId(1));
        uslugiDodatkoweLista1.setData_aktywacji("13-12-2020");
        uslugiDodatkoweLista1.setData_wylaczenia("13-01-2020");
        uslugiDodatkoweLista1.setRodzaj_aktywacji("Aktywacja w POS");
        Dao<UslugiDodatkoweLista, ?> dao1 = DaoManager.createDao(connectionSource, UslugiDodatkoweLista.class);
        dao1.create(uslugiDodatkoweLista1);

        UslugiDodatkoweLista uslugiDodatkoweLista2 = new UslugiDodatkoweLista();
        uslugiDodatkoweLista2.setStan("Nieaktywna");
        uslugiDodatkoweLista2.setUslugi_dodatkowe_id(dao.queryForId(7));
        uslugiDodatkoweLista2.setMsisdn(dao0.queryForId(2));
        uslugiDodatkoweLista2.setData_aktywacji("13-12-2020");
        uslugiDodatkoweLista2.setData_wylaczenia("13-01-2020");
        uslugiDodatkoweLista2.setRodzaj_aktywacji("Aktywacja TELE");
        Dao<UslugiDodatkoweLista, ?> dao3 = DaoManager.createDao(connectionSource, UslugiDodatkoweLista.class);
        dao3.create(uslugiDodatkoweLista2);

    }

}
