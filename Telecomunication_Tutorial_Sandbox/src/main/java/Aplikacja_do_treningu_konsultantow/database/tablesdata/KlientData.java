package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.Klient;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class KlientData {

    public static void loadKlientData(ConnectionSource conectionSource) throws SQLException {

        Klient klient1 = new Klient();
        klient1.setImie("Tadeusz");
        klient1.setNazwisko("Sznuk");
        klient1.setForma_prawna("Osoba fizyczna bedaca obywatelem polskim");
        klient1.setNumer_dowodu_osobistego("GLH 654234");
        klient1.setData_waznosci_dowodu_osobistego("24-01-2025");
        klient1.setPesel(91110134512l);
        klient1.setAdres_korespondencyjny("ul. Szczesliwa 25, 01-123 Warszawa");
        klient1.setAdres_zameldowania("ul. Szczesliwa 25, 01-123 Warszawa");
        klient1.setEmail("tadek.sznuk@gmail.com");
        klient1.setEmail_do_faktur("tadek.sznuk@gmail.com");
        klient1.setNumer_kontaktowy(543654765);
        klient1.setHaslo("tadek.sznuk");
        klient1.setNumer_klienta(123123);
        klient1.setOkres_rozliczeniowy("5");
        Dao<Klient, ?> dao1 = DaoManager.createDao(conectionSource, Klient.class);
        dao1.create(klient1);

        Klient klient2 = new Klient();
        klient2.setImie("Barnaba");
        klient2.setNazwisko("Butkiewicz");
        klient2.setForma_prawna("Osoba fizyczna bedaca obywatelem polskim");
        klient2.setNumer_dowodu_osobistego("ELO 123321");
        klient2.setData_waznosci_dowodu_osobistego("21-05-2027");
        klient2.setPesel(88010187523l);
        klient2.setAdres_korespondencyjny("al. Wybrancow 69, 43-125 Gdansk");
        klient2.setAdres_zameldowania("al. Wybrancow 69, 43-125 Gdansk");
        klient2.setEmail("barnaba.butkiewicz@wp.pl");
        klient2.setEmail_do_faktur("barnaba.butkiewicz@wp.pl");
        klient2.setNumer_kontaktowy(999666333);
        klient2.setHaslo("barnaba");
        klient2.setNumer_klienta(231231);
        klient2.setOkres_rozliczeniowy("5");
        Dao<Klient, ?> dao2 = DaoManager.createDao(conectionSource, Klient.class);
        dao2.create(klient2);

    }

}
