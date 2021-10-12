package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ZADANIA")
public class Zadania  implements BaseModel {

    public Zadania() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "TEMAT")
    private String temat;

    @DatabaseField(columnName = "TEMAT_ODP_A")
    private String temat_odp_a;

    @DatabaseField(columnName = "TEMAT_ODP_B")
    private String temat_odp_b;

    @DatabaseField(columnName = "TEMAT_ODP_C")
    private String temat_odp_c;

    @DatabaseField(columnName = "TEMAT_ODP_POPRAWNA")
    private String temat_odp_poprawna;

    @DatabaseField(columnName = "TEMAT_PODPOWIEDZ")
    private String temat_podpowiedz;

    @DatabaseField(columnName = "WERYFIKACJA1")
    private String weryfikacja;

    @DatabaseField(columnName = "WERYFIKACJA1_ODP_A")
    private String weryfikacja_odp_a;

    @DatabaseField(columnName = "WERYFIKACJA1_ODP_B")
    private String weryfikacja_odp_b;

    @DatabaseField(columnName = "WERYFIKACJA1_ODP_C")
    private String weryfikacja_odp_c;

    @DatabaseField(columnName = "WERYFIKACJA1_ODP_POPRAWNA")
    private String weryfikacja_odp_poprawna;

    @DatabaseField(columnName = "WERYFIKACJA2")
    private String weryfikacja2;

    @DatabaseField(columnName = "WERYFIKACJA2_ODP_A")
    private String weryfikacja2_odp_a;

    @DatabaseField(columnName = "WERYFIKACJA2_ODP_B")
    private String weryfikacja2_odp_b;

    @DatabaseField(columnName = "WERYFIKACJA2_ODP_C")
    private String weryfikacja2_odp_c;

    @DatabaseField(columnName = "WERYFIKACJA2_ODP_POPRAWNA")
    private String weryfikacja2_odp_poprawna;

    @DatabaseField(columnName = "WERYFIKACJA3")
    private String weryfikacja3;

    @DatabaseField(columnName = "WERYFIKACJA3_ODP_A")
    private String weryfikacja3_odp_a;

    @DatabaseField(columnName = "WERYFIKACJA3_ODP_B")
    private String weryfikacja3_odp_b;

    @DatabaseField(columnName = "WERYFIKACJA3_ODP_C")
    private String weryfikacja3_odp_c;

    @DatabaseField(columnName = "WERYFIKACJA3_ODP_POPRAWNA")
    private String weryfikacja3_odp_poprawna;

    @DatabaseField(columnName = "ZALICZENIE")
    private String zaliczenie;

    @DatabaseField(columnName = "TYP")
    private String typ;

    @DatabaseField(columnName = "OPIS")
    private String opis;

    @DatabaseField(columnName = "BLEDY")
    private Integer bledy;

    public Integer getBledy() {
        return bledy;
    }

    public void setBledy(Integer bledy) {
        this.bledy = bledy;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public String getTemat_odp_a() {
        return temat_odp_a;
    }

    public void setTemat_odp_a(String temat_odp_a) {
        this.temat_odp_a = temat_odp_a;
    }

    public String getTemat_odp_b() {
        return temat_odp_b;
    }

    public void setTemat_odp_b(String temat_odp_b) {
        this.temat_odp_b = temat_odp_b;
    }

    public String getTemat_odp_c() {
        return temat_odp_c;
    }

    public void setTemat_odp_c(String temat_odp_c) {
        this.temat_odp_c = temat_odp_c;
    }

    public String getTemat_odp_poprawna() {
        return temat_odp_poprawna;
    }

    public void setTemat_odp_poprawna(String temat_odp_poprawna) {
        this.temat_odp_poprawna = temat_odp_poprawna;
    }

    public String getTemat_podpowiedz() {
        return temat_podpowiedz;
    }

    public void setTemat_podpowiedz(String temat_podpowiedz) {
        this.temat_podpowiedz = temat_podpowiedz;
    }

    public String getWeryfikacja() {
        return weryfikacja;
    }

    public void setWeryfikacja(String weryfikacja) {
        this.weryfikacja = weryfikacja;
    }

    public String getWeryfikacja_odp_a() {
        return weryfikacja_odp_a;
    }

    public void setWeryfikacja_odp_a(String weryfikacja_odp_a) {
        this.weryfikacja_odp_a = weryfikacja_odp_a;
    }

    public String getWeryfikacja_odp_b() {
        return weryfikacja_odp_b;
    }

    public void setWeryfikacja_odp_b(String weryfikacja_odp_b) {
        this.weryfikacja_odp_b = weryfikacja_odp_b;
    }

    public String getWeryfikacja_odp_c() {
        return weryfikacja_odp_c;
    }

    public void setWeryfikacja_odp_c(String weryfikacja_odp_c) {
        this.weryfikacja_odp_c = weryfikacja_odp_c;
    }

    public String getWeryfikacja_odp_poprawna() {
        return weryfikacja_odp_poprawna;
    }

    public void setWeryfikacja_odp_poprawna(String weryfikacja_odp_poprawna) {
        this.weryfikacja_odp_poprawna = weryfikacja_odp_poprawna;
    }

    public String getWeryfikacja2() {
        return weryfikacja2;
    }

    public void setWeryfikacja2(String weryfikacja2) {
        this.weryfikacja2 = weryfikacja2;
    }

    public String getWeryfikacja2_odp_a() {
        return weryfikacja2_odp_a;
    }

    public void setWeryfikacja2_odp_a(String weryfikacja2_odp_a) {
        this.weryfikacja2_odp_a = weryfikacja2_odp_a;
    }

    public String getWeryfikacja2_odp_b() {
        return weryfikacja2_odp_b;
    }

    public void setWeryfikacja2_odp_b(String weryfikacja2_odp_b) {
        this.weryfikacja2_odp_b = weryfikacja2_odp_b;
    }

    public String getWeryfikacja2_odp_c() {
        return weryfikacja2_odp_c;
    }

    public void setWeryfikacja2_odp_c(String weryfikacja2_odp_c) {
        this.weryfikacja2_odp_c = weryfikacja2_odp_c;
    }

    public String getWeryfikacja2_odp_poprawna() {
        return weryfikacja2_odp_poprawna;
    }

    public void setWeryfikacja2_odp_poprawna(String weryfikacja2_odp_poprawna) {
        this.weryfikacja2_odp_poprawna = weryfikacja2_odp_poprawna;
    }

    public String getZaliczenie() {
        return zaliczenie;
    }

    public void setZaliczenie(String zaliczenie) {
        this.zaliczenie = zaliczenie;
    }

    public String getWeryfikacja3() {
        return weryfikacja3;
    }

    public void setWeryfikacja3(String weryfikacja3) {
        this.weryfikacja3 = weryfikacja3;
    }

    public String getWeryfikacja3_odp_a() {
        return weryfikacja3_odp_a;
    }

    public void setWeryfikacja3_odp_a(String weryfikacja3_odp_a) {
        this.weryfikacja3_odp_a = weryfikacja3_odp_a;
    }

    public String getWeryfikacja3_odp_b() {
        return weryfikacja3_odp_b;
    }

    public void setWeryfikacja3_odp_b(String weryfikacja3_odp_b) {
        this.weryfikacja3_odp_b = weryfikacja3_odp_b;
    }

    public String getWeryfikacja3_odp_c() {
        return weryfikacja3_odp_c;
    }

    public void setWeryfikacja3_odp_c(String weryfikacja3_odp_c) {
        this.weryfikacja3_odp_c = weryfikacja3_odp_c;
    }

    public String getWeryfikacja3_odp_poprawna() {
        return weryfikacja3_odp_poprawna;
    }

    public void setWeryfikacja3_odp_poprawna(String weryfikacja3_odp_poprawna) {
        this.weryfikacja3_odp_poprawna = weryfikacja3_odp_poprawna;
    }
}