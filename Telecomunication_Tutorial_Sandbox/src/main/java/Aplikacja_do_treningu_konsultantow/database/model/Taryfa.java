package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "TARYFA")
public class Taryfa implements BaseModel {

    public Taryfa(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAZWA_TARYFY")
    private String nazwa_taryfy;

    @DatabaseField(columnName = "KOSZT_KB")
    private String koszt_kb;

    @DatabaseField(columnName = "KOSZT_POLOCZENIA")
    private String koszt_poloczenia;

    @DatabaseField(columnName = "KOSZT_SMS")
    private String koszt_sms;

    @DatabaseField(columnName = "KOSZT_MMS")
    private String koszt_mms;

    @DatabaseField(columnName = "DARMOWE_GB")
    private String darmowe_gb;

    @DatabaseField(columnName = "DARMOWE_MINUTY")
    private String darmowe_minuty;

    @DatabaseField(columnName = "DARMOWE_SMS")
    private String darmowe_sms;

    @DatabaseField(columnName = "DARMOWE_MMS")
    private String darmowe_mms;

    @DatabaseField(columnName = "DARMOWE_GBR")
    private String darmowe_gbr;

    public String getDarmowe_gbr() {
        return darmowe_gbr;
    }

    public void setDarmowe_gbr(String darmowe_gbr) {
        this.darmowe_gbr = darmowe_gbr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa_taryfy() {
        return nazwa_taryfy;
    }

    public void setNazwa_taryfy(String nazwa_taryfy) {
        this.nazwa_taryfy = nazwa_taryfy;
    }

    public String getKoszt_kb() {
        return koszt_kb;
    }

    public void setKoszt_kb(String koszt_kb) {
        this.koszt_kb = koszt_kb;
    }

    public String getKoszt_poloczenia() {
        return koszt_poloczenia;
    }

    public void setKoszt_poloczenia(String koszt_poloczenia) {
        this.koszt_poloczenia = koszt_poloczenia;
    }

    public String getKoszt_sms() {
        return koszt_sms;
    }

    public void setKoszt_sms(String koszt_sms) {
        this.koszt_sms = koszt_sms;
    }

    public String getKoszt_mms() {
        return koszt_mms;
    }

    public void setKoszt_mms(String koszt_mms) {
        this.koszt_mms = koszt_mms;
    }

    public String getDarmowe_gb() {
        return darmowe_gb;
    }

    public void setDarmowe_gb(String darmowe_gb) {
        this.darmowe_gb = darmowe_gb;
    }

    public String getDarmowe_minuty() {
        return darmowe_minuty;
    }

    public void setDarmowe_minuty(String darmowe_minuty) {
        this.darmowe_minuty = darmowe_minuty;
    }

    public String getDarmowe_sms() {
        return darmowe_sms;
    }

    public void setDarmowe_sms(String darmowe_sms) {
        this.darmowe_sms = darmowe_sms;
    }

    public String getDarmowe_mms() {
        return darmowe_mms;
    }

    public void setDarmowe_mms(String darmowe_mms) {
        this.darmowe_mms = darmowe_mms;
    }
}
