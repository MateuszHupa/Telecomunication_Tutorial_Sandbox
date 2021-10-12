package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.HistoriaPolaczen;
import Aplikacja_do_treningu_konsultantow.database.model.MSISDN;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public class HistoriaPolaczenData {

    public static void loadHistoriaPolaczenData() throws SQLException {

        Dao<MSISDN,Integer> dao = new DaoManager().createDao(DataBaseManager.getConnectionSource(), MSISDN.class);
        MSISDN msisdn = new MSISDN();

        Dao<HistoriaPolaczen, ?> dao2 = new DaoManager().createDao(DataBaseManager.getConnectionSource(), HistoriaPolaczen.class);

        HistoriaPolaczen historiaPolaczen = new HistoriaPolaczen();
        historiaPolaczen.setData("01-01-2021 12:12");
        historiaPolaczen.setMsisdn(dao.queryForId(1));
        historiaPolaczen.setOplata("29 gr");
        historiaPolaczen.setWykorzystane_jednostki("1 min");
        historiaPolaczen.setRodzaj("Polaczenie glosowe");
        historiaPolaczen.setKierunek("Wychodzace");
        historiaPolaczen.setDrugi_numer("776688995");
        dao2.create(historiaPolaczen);

        HistoriaPolaczen historiaPolaczen2 = new HistoriaPolaczen();
        historiaPolaczen2.setData("01-01-2021 14:13");
        historiaPolaczen2.setMsisdn(dao.queryForId(1));
        historiaPolaczen2.setOplata("58 gr");
        historiaPolaczen2.setWykorzystane_jednostki("2 min");
        historiaPolaczen2.setRodzaj("Polaczenie glosowe");
        historiaPolaczen2.setKierunek("Przychodzace");
        historiaPolaczen2.setDrugi_numer("776688995");
        dao2.create(historiaPolaczen2);

        HistoriaPolaczen historiaPolaczen3 = new HistoriaPolaczen();
        historiaPolaczen3.setData("02-01-2021 14:13");
        historiaPolaczen3.setMsisdn(dao.queryForId(1));
        historiaPolaczen3.setOplata("58 gr");
        historiaPolaczen3.setWykorzystane_jednostki("2 min");
        historiaPolaczen3.setRodzaj("Polaczenie glosowe");
        historiaPolaczen3.setKierunek("Wychodzace");
        historiaPolaczen3.setDrugi_numer("612307956");
        dao2.create(historiaPolaczen3);

        HistoriaPolaczen historiaPolaczen4 = new HistoriaPolaczen();
        historiaPolaczen4.setData("02-01-2021 15:38");
        historiaPolaczen4.setMsisdn(dao.queryForId(1));
        historiaPolaczen4.setOplata("58 gr");
        historiaPolaczen4.setWykorzystane_jednostki("2 min");
        historiaPolaczen4.setRodzaj("Polaczenie glosowe");
        historiaPolaczen4.setKierunek("Wychodzace");
        historiaPolaczen4.setDrugi_numer("612307956");
        dao2.create(historiaPolaczen4);

        HistoriaPolaczen historiaPolaczen5 = new HistoriaPolaczen();
        historiaPolaczen5.setData("03-01-2021 15:38");
        historiaPolaczen5.setMsisdn(dao.queryForId(1));
        historiaPolaczen5.setOplata("5 gr");
        historiaPolaczen5.setWykorzystane_jednostki("1 szt.");
        historiaPolaczen5.setRodzaj("SMS");
        historiaPolaczen5.setKierunek("Wychodzace");
        historiaPolaczen5.setDrugi_numer("612307956");
        dao2.create(historiaPolaczen5);
    }

}
