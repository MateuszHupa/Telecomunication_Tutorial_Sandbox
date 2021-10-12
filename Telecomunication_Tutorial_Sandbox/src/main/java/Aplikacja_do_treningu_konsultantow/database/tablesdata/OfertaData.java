package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.Oferta;
import Aplikacja_do_treningu_konsultantow.database.model.Taryfa;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class OfertaData {

    public static void loadOfertaData(ConnectionSource conectionSource) throws SQLException {

        Dao<Taryfa, Integer> dao = DaoManager.createDao(conectionSource, Taryfa.class);

        Oferta oferta1 = new Oferta();
        oferta1.setRodzaj_oferty("prepaid");
        oferta1.setTaryfa(dao.queryForId(1));
        Dao<Oferta, Integer> dao1 = DaoManager.createDao(conectionSource, Oferta.class);
        dao1.create(oferta1);

        Oferta oferta2 = new Oferta();
        oferta2.setRodzaj_oferty("postpaid");
        oferta2.setTaryfa(dao.queryForId(2));
        Dao<Oferta, Integer> dao2 = DaoManager.createDao(conectionSource, Oferta.class);
        dao2.create(oferta2);

    }

}
