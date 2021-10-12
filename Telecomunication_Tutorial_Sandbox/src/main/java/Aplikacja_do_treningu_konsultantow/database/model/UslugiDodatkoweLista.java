package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "USLUGI_DODATKOWE_LISTA")
public class UslugiDodatkoweLista implements BaseModel {

    public UslugiDodatkoweLista(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "STAN")
    private String stan;

    @DatabaseField(columnName = "USLUGI_DODATKOWE_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private UslugiDodatkowe uslugi_dodatkowe_id;

    @DatabaseField(columnName = "MSISDN_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private MSISDN msisdn;

    @DatabaseField(columnName = "DATA_AKTYWACJI", canBeNull = false, format = "DD-MM-yyyy")
    private String data_aktywacji;

    @DatabaseField(columnName = "DATA_WYLACZENIA", canBeNull = false, format = "DD-MM-yyyy")
    private String data_wylaczenia;

    @DatabaseField(columnName = "RODZAJ_AKTYWACJI")
    private String rodzaj_aktywacji;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public UslugiDodatkowe getUslugi_dodatkowe_id() {
        return uslugi_dodatkowe_id;
    }

    public void setUslugi_dodatkowe_id(UslugiDodatkowe uslugi_dodatkowe_id) {
        this.uslugi_dodatkowe_id = uslugi_dodatkowe_id;
    }

    public MSISDN getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(MSISDN msisdn) {
        this.msisdn = msisdn;
    }

    public String getData_aktywacji() {
        return data_aktywacji;
    }

    public void setData_aktywacji(String data_aktywacji) {
        this.data_aktywacji = data_aktywacji;
    }

    public String getData_wylaczenia() {
        return data_wylaczenia;
    }

    public void setData_wylaczenia(String data_wylaczenia) {
        this.data_wylaczenia = data_wylaczenia;
    }

    public String getRodzaj_aktywacji() {
        return rodzaj_aktywacji;
    }

    public void setRodzaj_aktywacji(String rodzaj_aktywacji) {
        this.rodzaj_aktywacji = rodzaj_aktywacji;
    }
}
