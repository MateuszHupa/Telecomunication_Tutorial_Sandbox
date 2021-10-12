package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "KLIENT")
public class Klient implements BaseModel {

    public Klient(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "IMIE", canBeNull = false)
    private String imie;

    @DatabaseField(columnName = "NAZWISKO", canBeNull = false)
    private String nazwisko;

    @DatabaseField(columnName = "FORMA_PRAWNA")
    private String forma_prawna;

    @DatabaseField(columnName = "NUMER_DOWODU_OSOBISTEGO", unique = true)
    private String numer_dowodu_osobistego;

    @DatabaseField(columnName = "PESEL", canBeNull = false, width = 11,unique = true)
    private long pesel;

    @DatabaseField(columnName = "DATA_WAZNOSCI_DOWODU_OSOBISTEGO", format = "DD-MM-yyyy")
    private String data_waznosci_dowodu_osobistego;

    @DatabaseField(columnName = "ADRES_ZAMELDOWANIA")
    private String adres_zameldowania;

    @DatabaseField(columnName = "ADRES_KORESPONDENCYJNY")
    private String adres_korespondencyjny;

    @DatabaseField(columnName = "EMAIL")
    private String email;

    @DatabaseField(columnName = "EMAIL_DO_FAKTUR")
    private String email_do_faktur;

    @DatabaseField(columnName = "NUMER_KONTAKTOWY")
    private long numer_kontaktowy;

    @DatabaseField(columnName = "HASLO", canBeNull = false)
    private String haslo;

    @DatabaseField(columnName = "NUMER_KLIENTA", canBeNull = false, unique = true)
    private long numer_klienta;

    @DatabaseField(columnName = "OKRES_ROZLICZENIOWY")
    private String okres_rozliczeniowy;

    public String getOkres_rozliczeniowy() {
        return okres_rozliczeniowy;
    }

    public void setOkres_rozliczeniowy(String okres_rozliczeniowy) {
        this.okres_rozliczeniowy = okres_rozliczeniowy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getForma_prawna() {
        return forma_prawna;
    }

    public void setForma_prawna(String forma_prawna) {
        this.forma_prawna = forma_prawna;
    }

    public String getNumer_dowodu_osobistego() {
        return numer_dowodu_osobistego;
    }

    public void setNumer_dowodu_osobistego(String numer_dowodu_osobistego) {
        this.numer_dowodu_osobistego = numer_dowodu_osobistego;
    }

    public String getData_waznosci_dowodu_osobistego() {
        return data_waznosci_dowodu_osobistego;
    }

    public void setData_waznosci_dowodu_osobistego(String data_waznosci_dowodu_osobistego) {
        this.data_waznosci_dowodu_osobistego = data_waznosci_dowodu_osobistego;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getAdres_zameldowania() {
        return adres_zameldowania;
    }

    public void setAdres_zameldowania(String adres_zameldowania) {
        this.adres_zameldowania = adres_zameldowania;
    }

    public String getAdres_korespondencyjny() {
        return adres_korespondencyjny;
    }

    public void setAdres_korespondencyjny(String adres_korespondencyjny) {
        this.adres_korespondencyjny = adres_korespondencyjny;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_do_faktur() {
        return email_do_faktur;
    }

    public void setEmail_do_faktur(String email_do_faktur) {
        this.email_do_faktur = email_do_faktur;
    }

    public long getNumer_kontaktowy() {
        return numer_kontaktowy;
    }

    public void setNumer_kontaktowy(long numer_kontaktowy) {
        this.numer_kontaktowy = numer_kontaktowy;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public long getNumer_klienta() {
        return numer_klienta;
    }

    public void setNumer_klienta(long numer_klienta) {
        this.numer_klienta = numer_klienta;
    }

 //   @Override
 //   public String toString() {
 //       return ("Klient:" + id +""+ imie + "" + nazwisko + "");
 //   }
}
