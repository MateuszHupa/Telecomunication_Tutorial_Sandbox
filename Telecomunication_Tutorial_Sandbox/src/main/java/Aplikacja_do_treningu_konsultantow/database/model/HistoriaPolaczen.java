package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "HISTORIA_POLACZEN")
public class HistoriaPolaczen implements BaseModel {

    public HistoriaPolaczen(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "RODZAJ")
    private String rodzaj;

    @DatabaseField(columnName = "OPLATA")
    private String oplata;

    @DatabaseField(columnName = "WYKORZYSTANE_JEDNOSTKI", canBeNull = false)
    private String wykorzystane_jednostki;

    @DatabaseField(columnName = "DATA", canBeNull = false)
    private String data;

    @DatabaseField(columnName = "MSISDN_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private MSISDN msisdn;

    @DatabaseField(columnName = "KIERUNEK")
    private String kierunek;

    @DatabaseField(columnName = "DRUGI_NUMER")
    private String drugi_numer;

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getDrugi_numer() {
        return drugi_numer;
    }

    public void setDrugi_numer(String drugi_numer) {
        this.drugi_numer = drugi_numer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getOplata() {
        return oplata;
    }

    public void setOplata(String oplata) {
        this.oplata = oplata;
    }

    public String getWykorzystane_jednostki() {
        return wykorzystane_jednostki;
    }

    public void setWykorzystane_jednostki(String wykorzystane_jednostki) {
        this.wykorzystane_jednostki = wykorzystane_jednostki;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MSISDN getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(MSISDN msisdn) {
        this.msisdn = msisdn;
    }
}
