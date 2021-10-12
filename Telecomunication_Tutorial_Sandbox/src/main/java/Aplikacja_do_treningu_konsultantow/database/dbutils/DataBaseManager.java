package Aplikacja_do_treningu_konsultantow.database.dbutils;

import Aplikacja_do_treningu_konsultantow.database.model.*;
import Aplikacja_do_treningu_konsultantow.database.tablesdata.*;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DataBaseManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./teleDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void initDatabase() throws SQLException {
        createConnectionSource();
        dropTable();
        createTable();
        TaryfaData.loadTaryfaData(connectionSource);
        OfertaData.loadOfertaData(connectionSource);
        KlientData.loadKlientData(connectionSource);
        UslugiDodatkoweData.loadUslugiDodatkoweData(connectionSource);
        MSISDNData.loadMSISDNData(connectionSource);
        UslugiDodatkoweListaData.loadUslugidodatkoweListaData(connectionSource);
        HistoriaPolaczenData.loadHistoriaPolaczenData();
        ZadaniaData.loadZadaniaData(connectionSource);
        closeConectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, USER, PASS);
        } catch (SQLException e){
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConectionSource(){
        if(connectionSource != null){
            try{
                connectionSource.close();
            } catch (IOException e){
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, Klient.class);
            TableUtils.createTableIfNotExists(connectionSource, MSISDN.class);
            TableUtils.createTableIfNotExists(connectionSource, Oferta.class);
            TableUtils.createTableIfNotExists(connectionSource, Taryfa.class);
            TableUtils.createTableIfNotExists(connectionSource, UslugiDodatkowe.class);
            TableUtils.createTableIfNotExists(connectionSource, UslugiDodatkoweLista.class);
            TableUtils.createTableIfNotExists(connectionSource, HistoriaPolaczen.class);
            TableUtils.createTableIfNotExists(connectionSource, Zadania.class);
        } catch (SQLException e){
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable(){
        try{
            TableUtils.dropTable(connectionSource, Klient.class, true);
            TableUtils.dropTable(connectionSource, MSISDN.class, true);
            TableUtils.dropTable(connectionSource, Oferta.class, true);
            TableUtils.dropTable(connectionSource, Taryfa.class, true);
            TableUtils.dropTable(connectionSource, UslugiDodatkowe.class, true);
            TableUtils.dropTable(connectionSource, UslugiDodatkoweLista.class, true);
            TableUtils.dropTable(connectionSource, HistoriaPolaczen.class, true);
            TableUtils.dropTable(connectionSource, Zadania.class, true);
        } catch (SQLException e){
            LOGGER.warn(e.getMessage());
        }
    }

}
