package Aplikacja_do_treningu_konsultantow.database.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "OFERTA")
public class Oferta implements BaseModel {

    public Oferta(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "RODZAJ_OFERTY")
    private String rodzaj_oferty;

    @DatabaseField(columnName = "TARYFA_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Taryfa taryfa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRodzaj_oferty() {
        return rodzaj_oferty;
    }

    public void setRodzaj_oferty(String rodzaj_oferty) {
        this.rodzaj_oferty = rodzaj_oferty;
    }

    public Taryfa getTaryfa() {
        return taryfa;
    }

    public void setTaryfa(Taryfa taryfa) {
        this.taryfa = taryfa;
    }
}
