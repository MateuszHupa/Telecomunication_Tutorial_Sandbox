package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.Taryfa;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class TaryfaData {

    public static void loadTaryfaData (ConnectionSource connectionSource) throws SQLException {

        Taryfa taryfa1 = new Taryfa();
        taryfa1.setNazwa_taryfy("Super prepaid");
        taryfa1.setKoszt_kb("12 gr");
        taryfa1.setKoszt_poloczenia("29 gr");
        taryfa1.setKoszt_sms("5 gr");
        taryfa1.setKoszt_mms("5 gr");
        taryfa1.setDarmowe_gb("0");
        taryfa1.setDarmowe_minuty("0");
        taryfa1.setDarmowe_sms("0");
        taryfa1.setDarmowe_mms("0");
        taryfa1.setDarmowe_gbr("0");
        Dao<Taryfa, ?> dao1 = DaoManager.createDao(connectionSource, Taryfa.class);
        dao1.create(taryfa1);

        Taryfa taryfa2 = new Taryfa();
        taryfa2.setNazwa_taryfy("Super postpaid");
        taryfa2.setKoszt_kb("12 gr");
        taryfa2.setKoszt_poloczenia("29 gr");
        taryfa2.setKoszt_sms("5 gr");
        taryfa2.setKoszt_mms("5 gr");
        taryfa2.setDarmowe_gb("10");
        taryfa2.setDarmowe_minuty("Nielimitowane");
        taryfa2.setDarmowe_sms("Nielimitowane");
        taryfa2.setDarmowe_mms("Nielimitowane");
        taryfa2.setDarmowe_gbr("2");
        Dao<Taryfa, ?> dao2 = DaoManager.createDao(connectionSource, Taryfa.class);
        dao2.create(taryfa2);

    }

}
