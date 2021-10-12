package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MSISDN")
public class MSISDN implements BaseModel {

    public MSISDN(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NUMER_TELEFONU", canBeNull = false, unique = true)
    private String numer_telefonu;

    @DatabaseField(columnName = "OFERTA_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Oferta oferta_id;

    @DatabaseField(columnName = "DATA_ROZPOCZECIA_UMOWY", format = "DD-MM-yyyy")
    private String data_rozpoczecia_umowy;

    @DatabaseField(columnName = "DATA_ZAKONCZENIA_UMOWY")
    private String data_zakonczenia_umowy;

    @DatabaseField(columnName = "SEGMENT_UTRZYMANIOWY")
    private String segment_utrzymaniowy;

    @DatabaseField(columnName = "KLIENT_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Klient klient_ID;

    @DatabaseField(columnName = "STAN_KONTA")
    private String stan_konta;

    @DatabaseField(columnName = "WAZNOSC_POLACZEN_WYCHODZACYCH")
    private String waznosc_polaczen_wychodzacych;

    @DatabaseField(columnName = "WAZNOSC_POLACZEN_PRZYCHODZACYCH")
    private String waznosc_polaczen_przychodzacych;

    public String getStan_konta() {
        return stan_konta;
    }

    public void setStan_konta(String stan_konta) {
        this.stan_konta = stan_konta;
    }

    public String getWaznosc_polaczen_wychodzacych() {
        return waznosc_polaczen_wychodzacych;
    }

    public void setWaznosc_polaczen_wychodzacych(String waznosc_polaczen_wychodzacych) {
        this.waznosc_polaczen_wychodzacych = waznosc_polaczen_wychodzacych;
    }

    public String getWaznosc_polaczen_przychodzacych() {
        return waznosc_polaczen_przychodzacych;
    }

    public void setWaznosc_polaczen_przychodzacych(String waznosc_polaczen_przychodzacych) {
        this.waznosc_polaczen_przychodzacych = waznosc_polaczen_przychodzacych;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public Oferta getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(Oferta oferta_id) {
        this.oferta_id = oferta_id;
    }

    public String getData_rozpoczecia_umowy() {
        return data_rozpoczecia_umowy;
    }

    public void setData_rozpoczecia_umowy(String data_rozpoczecia_umowy) {
        this.data_rozpoczecia_umowy = data_rozpoczecia_umowy;
    }

    public String getData_zakonczenia_umowy() {
        return data_zakonczenia_umowy;
    }

    public void setData_zakonczenia_umowy(String data_zakonczenia_umowy) {
        this.data_zakonczenia_umowy = data_zakonczenia_umowy;
    }

    public String getSegment_utrzymaniowy() {
        return segment_utrzymaniowy;
    }

    public void setSegment_utrzymaniowy(String segment_utrzymaniowy) {
        this.segment_utrzymaniowy = segment_utrzymaniowy;
    }

    public Klient getKlient_ID() {
        return klient_ID;
    }

    public void setKlient_ID(Klient klient_ID) {
        this.klient_ID = klient_ID;
    }
}
