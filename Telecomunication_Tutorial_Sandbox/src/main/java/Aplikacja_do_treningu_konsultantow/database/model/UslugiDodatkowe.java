package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "USLUGI_DODATKOWE")
public class UslugiDodatkowe implements BaseModel {

    public UslugiDodatkowe(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAZWA_USLUGI")
    private String nazwa_uslugi;

    @DatabaseField(columnName = "CENA")
    private String cena;

    @DatabaseField(columnName = "OPIS")
    private String opis;

    @DatabaseField(columnName = "CZAS_TRWANIA")
    private String czas_trwania;

    @DatabaseField(columnName = "OFERTA_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Oferta oferta_id;

    @DatabaseField(columnName = "WYSOKOSC_PAKIETU")
    private String wysokosc_pakietu;

    @DatabaseField(columnName = "TYP_USLUGI")
    private String typ_uslugi;

    public String getTyp_uslugi() {
        return typ_uslugi;
    }

    public void setTyp_uslugi(String typ_uslugi) {
        this.typ_uslugi = typ_uslugi;
    }

    public String getWysokosc_pakietu() {
        return wysokosc_pakietu;
    }

    public void setWysokosc_pakietu(String wysokosc_pakietu) {
        this.wysokosc_pakietu = wysokosc_pakietu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa_uslugi() {
        return nazwa_uslugi;
    }

    public void setNazwa_uslugi(String nazwa_uslugi) {
        this.nazwa_uslugi = nazwa_uslugi;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCzas_trwania() {
        return czas_trwania;
    }

    public void setCzas_trwania(String czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    public Oferta getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(Oferta oferta_id) {
        this.oferta_id = oferta_id;
    }
}
