package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.Oferta;
import Aplikacja_do_treningu_konsultantow.database.model.UslugiDodatkowe;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class UslugiDodatkoweData {

    public static void loadUslugiDodatkoweData (ConnectionSource connectionSource) throws SQLException {

        Dao<Oferta, Integer> dao = DaoManager.createDao(connectionSource, Oferta.class);
        Dao<UslugiDodatkowe, ?> dao1 = DaoManager.createDao(connectionSource, UslugiDodatkowe.class);

        UslugiDodatkowe uslugiDodatkowe1 = new UslugiDodatkowe();
        uslugiDodatkowe1.setNazwa_uslugi("Nielimitowane minuty");
        uslugiDodatkowe1.setCena("10");
        uslugiDodatkowe1.setOpis("Usluga daje nielimitowane minuty na wszystkie numery komorkowe i stacjonarne w polsce przez 30 dni");
        uslugiDodatkowe1.setCzas_trwania("30 dni");
        uslugiDodatkowe1.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe1.setWysokosc_pakietu("Nielimitowane");
        uslugiDodatkowe1.setTyp_uslugi("Minuty");
        dao1.create(uslugiDodatkowe1);

        UslugiDodatkowe uslugiDodatkowe2 = new UslugiDodatkowe();
        uslugiDodatkowe2.setNazwa_uslugi("Dodatkowe 10 GB");
        uslugiDodatkowe2.setCena("5");
        uslugiDodatkowe2.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 10 GB na kolejne 30 dni");
        uslugiDodatkowe2.setCzas_trwania("30 dni");
        uslugiDodatkowe2.setOferta_id(dao.queryForId(2));
        uslugiDodatkowe2.setWysokosc_pakietu("10");
        uslugiDodatkowe2.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe2);

        UslugiDodatkowe uslugiDodatkowe3 = new UslugiDodatkowe();
        uslugiDodatkowe3.setNazwa_uslugi("Dodatkowe 15 GB");
        uslugiDodatkowe3.setCena("7");
        uslugiDodatkowe3.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 15 GB na kolejne 30 dni");
        uslugiDodatkowe3.setCzas_trwania("30");
        uslugiDodatkowe3.setOferta_id(dao.queryForId(2));
        uslugiDodatkowe3.setWysokosc_pakietu("15");
        uslugiDodatkowe3.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe3);

        UslugiDodatkowe uslugiDodatkowe4 = new UslugiDodatkowe();
        uslugiDodatkowe4.setNazwa_uslugi("Dodatkowe 20 GB");
        uslugiDodatkowe4.setCena("10");
        uslugiDodatkowe4.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 20 GB na kolejne 30 dni");
        uslugiDodatkowe4.setCzas_trwania("30");
        uslugiDodatkowe4.setOferta_id(dao.queryForId(2));
        uslugiDodatkowe4.setWysokosc_pakietu("20");
        uslugiDodatkowe4.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe4);

        UslugiDodatkowe uslugiDodatkowe5 = new UslugiDodatkowe();
        uslugiDodatkowe5.setNazwa_uslugi("Dodatkowy 1 GB w roamingu");
        uslugiDodatkowe5.setCena("15");
        uslugiDodatkowe5.setOpis("Usluga daje mozliwosc zakupienia dodatkowego 1 GB na kolejne 30 dni w roamingu EU");
        uslugiDodatkowe5.setCzas_trwania("30");
        uslugiDodatkowe5.setOferta_id(dao.queryForId(2));
        uslugiDodatkowe5.setWysokosc_pakietu("1");
        uslugiDodatkowe5.setTyp_uslugi("GBR");
        dao1.create(uslugiDodatkowe5);

        UslugiDodatkowe uslugiDodatkowe6 = new UslugiDodatkowe();
        uslugiDodatkowe6.setNazwa_uslugi("Nielimitowane SMS");
        uslugiDodatkowe6.setCena("10");
        uslugiDodatkowe6.setOpis("Usluga daje nielimitowane SMS'y na wszystkie numery komorkowe i stacjonarne w polsce przez 30 dni");
        uslugiDodatkowe6.setCzas_trwania("30 dni");
        uslugiDodatkowe6.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe6.setWysokosc_pakietu("Nielimitowane");
        uslugiDodatkowe6.setTyp_uslugi("SMS");
        dao1.create(uslugiDodatkowe6);

        UslugiDodatkowe uslugiDodatkowe8 = new UslugiDodatkowe();
        uslugiDodatkowe8.setNazwa_uslugi("100 minut do innych sieci");
        uslugiDodatkowe8.setCena("5");
        uslugiDodatkowe8.setOpis("Usluga daje darmowe minuty na numery komorkowe innych sieci w polsce przez 30 dni");
        uslugiDodatkowe8.setCzas_trwania("30 dni");
        uslugiDodatkowe8.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe8.setWysokosc_pakietu("100");
        uslugiDodatkowe8.setTyp_uslugi("Minuty");
        dao1.create(uslugiDodatkowe8);

        UslugiDodatkowe uslugiDodatkowe9 = new UslugiDodatkowe();
        uslugiDodatkowe9.setNazwa_uslugi("100 SMS do innych sieci");
        uslugiDodatkowe9.setCena("5");
        uslugiDodatkowe9.setOpis("Usluga daje darmowe SMS na numery komorkowe innych sieci w polsce przez 30 dni");
        uslugiDodatkowe9.setCzas_trwania("30 dni");
        uslugiDodatkowe9.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe9.setWysokosc_pakietu("100");
        uslugiDodatkowe9.setTyp_uslugi("SMS");
        dao1.create(uslugiDodatkowe9);

        UslugiDodatkowe uslugiDodatkowe10 = new UslugiDodatkowe();
        uslugiDodatkowe10.setNazwa_uslugi("1 GB");
        uslugiDodatkowe10.setCena("5");
        uslugiDodatkowe10.setOpis("Usluga daje mozliwosc zakupienia dodatkowego 1 GB na kolejne 30 dni");
        uslugiDodatkowe10.setCzas_trwania("30 dni");
        uslugiDodatkowe10.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe10.setWysokosc_pakietu("1");
        uslugiDodatkowe10.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe10);

        UslugiDodatkowe uslugiDodatkowe11 = new UslugiDodatkowe();
        uslugiDodatkowe11.setNazwa_uslugi("2 GB");
        uslugiDodatkowe11.setCena("7");
        uslugiDodatkowe11.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 2 GB na kolejne 30 dni");
        uslugiDodatkowe11.setCzas_trwania("30 dni");
        uslugiDodatkowe11.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe11.setWysokosc_pakietu("2");
        uslugiDodatkowe11.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe11);

        UslugiDodatkowe uslugiDodatkowe12 = new UslugiDodatkowe();
        uslugiDodatkowe12.setNazwa_uslugi("3 GB");
        uslugiDodatkowe12.setCena("10");
        uslugiDodatkowe12.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 3 GB na kolejne 30 dni");
        uslugiDodatkowe12.setCzas_trwania("30 dni");
        uslugiDodatkowe12.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe12.setWysokosc_pakietu("3");
        uslugiDodatkowe12.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe12);

        UslugiDodatkowe uslugiDodatkowe13 = new UslugiDodatkowe();
        uslugiDodatkowe13.setNazwa_uslugi("5 GB");
        uslugiDodatkowe13.setCena("15");
        uslugiDodatkowe13.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 5 GB na kolejne 30 dni");
        uslugiDodatkowe13.setCzas_trwania("30 dni");
        uslugiDodatkowe13.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe13.setWysokosc_pakietu("5");
        uslugiDodatkowe13.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe13);

        UslugiDodatkowe uslugiDodatkowe14 = new UslugiDodatkowe();
        uslugiDodatkowe14.setNazwa_uslugi("10 GB");
        uslugiDodatkowe14.setCena("20");
        uslugiDodatkowe14.setOpis("Usluga daje mozliwosc zakupienia dodatkowych 10 GB na kolejne 30 dni");
        uslugiDodatkowe14.setCzas_trwania("30 dni");
        uslugiDodatkowe14.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe14.setWysokosc_pakietu("10");
        uslugiDodatkowe14.setTyp_uslugi("GB");
        dao1.create(uslugiDodatkowe14);

        UslugiDodatkowe uslugiDodatkowe15 = new UslugiDodatkowe();
        uslugiDodatkowe15.setNazwa_uslugi("Nielimitowane MMS");
        uslugiDodatkowe15.setCena("10");
        uslugiDodatkowe15.setOpis("Usluga daje mozliwosc zakupienia nielimitowanych MMS na kolejne 30 dni");
        uslugiDodatkowe15.setCzas_trwania("30 dni");
        uslugiDodatkowe15.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe15.setWysokosc_pakietu("Nielimitowane");
        uslugiDodatkowe15.setTyp_uslugi("MMS");
        dao1.create(uslugiDodatkowe15);

        UslugiDodatkowe uslugiDodatkowe16 = new UslugiDodatkowe();
        uslugiDodatkowe16.setNazwa_uslugi("1 GB");
        uslugiDodatkowe16.setCena("15");
        uslugiDodatkowe16.setOpis("Usluga daje mozliwosc zakupienia dodatkowego 1 GB na kolejne 30 dni w roamingu UE");
        uslugiDodatkowe16.setCzas_trwania("30 dni");
        uslugiDodatkowe16.setOferta_id(dao.queryForId(1));
        uslugiDodatkowe16.setWysokosc_pakietu("1");
        uslugiDodatkowe16.setTyp_uslugi("GBR");
        dao1.create(uslugiDodatkowe16);
    }

}
