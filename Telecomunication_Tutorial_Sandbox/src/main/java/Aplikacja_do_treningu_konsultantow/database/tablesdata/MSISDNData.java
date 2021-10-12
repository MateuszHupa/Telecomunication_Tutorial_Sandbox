package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.Klient;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import Aplikacja_do_treningu_konsultantow.database.model.Oferta;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public class MSISDNData {

    public static void loadMSISDNData (ConnectionSource conectionSource) throws SQLException{

        Dao<Oferta, Integer> dao = DaoManager.createDao(conectionSource, Oferta.class);
        Dao<Klient, Integer> dao0 = DaoManager.createDao(conectionSource, Klient.class);

        MSISDN msisdn1 = new MSISDN();
        msisdn1.setNumer_telefonu("543654765");
        msisdn1.setOferta_id(dao.queryForId(1));
        msisdn1.setData_rozpoczecia_umowy("12-12-2020");
        msisdn1.setData_zakonczenia_umowy("Umowa na czas nieokreślony");
        msisdn1.setSegment_utrzymaniowy("Brak");
        msisdn1.setKlient_ID(dao0.queryForId(1));
        msisdn1.setStan_konta("0");
        Dao<MSISDN, ?> dao1 = DaoManager.createDao(conectionSource, MSISDN.class);
        dao1.create(msisdn1);

        MSISDN msisdn3 = new MSISDN();
        msisdn3.setNumer_telefonu("654544544");
        msisdn3.setOferta_id(dao.queryForId(1));
        msisdn3.setData_rozpoczecia_umowy("12-11-2021");
        msisdn3.setData_zakonczenia_umowy("Umowa na czas nieokreślony");
        msisdn3.setSegment_utrzymaniowy("Brak");
        msisdn3.setKlient_ID(dao0.queryForId(1));
        msisdn3.setStan_konta("0");
        Dao<MSISDN, ?> dao3 = DaoManager.createDao(conectionSource, MSISDN.class);
        dao3.create(msisdn3);

        MSISDN msisdn4 = new MSISDN();
        msisdn4.setNumer_telefonu("544544544");
        msisdn4.setOferta_id(dao.queryForId(1));
        msisdn4.setData_rozpoczecia_umowy("12-11-2021");
        msisdn4.setData_zakonczenia_umowy("Umowa na czas nieokreślony");
        msisdn4.setSegment_utrzymaniowy("Brak");
        msisdn4.setKlient_ID(dao0.queryForId(1));
        msisdn4.setStan_konta("0");
        Dao<MSISDN, ?> dao4 = DaoManager.createDao(conectionSource, MSISDN.class);
        dao4.create(msisdn4);

        MSISDN msisdn2 = new MSISDN();
        msisdn2.setNumer_telefonu("999666333");
        msisdn2.setOferta_id(dao.queryForId(2));
        msisdn2.setData_rozpoczecia_umowy("13-02-2019");
        msisdn2.setData_zakonczenia_umowy("13-02-2022");
        msisdn2.setSegment_utrzymaniowy("Brak");
        msisdn2.setKlient_ID(dao0.queryForId(2));
        msisdn2.setStan_konta("50");
        Dao<MSISDN, ?> dao2 = DaoManager.createDao(conectionSource, MSISDN.class);
        dao2.create(msisdn2);

        MSISDN msisdn5 = new MSISDN();
        msisdn5.setNumer_telefonu("999666878");
        msisdn5.setOferta_id(dao.queryForId(2));
        msisdn5.setData_rozpoczecia_umowy("12-01-2017");
        msisdn5.setData_zakonczenia_umowy("12-01-2020");
        msisdn5.setSegment_utrzymaniowy("Tak");
        msisdn5.setKlient_ID(dao0.queryForId(1));
        msisdn5.setStan_konta("30");
        Dao<MSISDN, ?> dao5 = DaoManager.createDao(conectionSource, MSISDN.class);
        dao5.create(msisdn5);

    }

}
