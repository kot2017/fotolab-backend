package pl.wl.foto.reakt.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Wywolania {
    private int id;
    private Date data;
    private Integer asa;
    private Integer rozcienczenie;
    private String czasWolania;
    private String uwagi;
    private String katalog;
    private String rezultat;
    private String numerNegatywu;
    private Filmy filmyByFilmy;
    private Chemikalia chemikaliaByChemikalia;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data", nullable = true)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "ASA", nullable = true)
    public Integer getAsa() {
        return asa;
    }

    public void setAsa(Integer asa) {
        this.asa = asa;
    }

    @Basic
    @Column(name = "rozcienczenie", nullable = true, length = 45)
    public Integer getRozcienczenie() {
        return rozcienczenie;
    }

    public void setRozcienczenie(Integer rozcienczenie) {
        this.rozcienczenie = rozcienczenie;
    }

    @Basic
    @Column(name = "czas_wolania", nullable = true, length = 45)
    public String getCzasWolania() {
        return czasWolania;
    }

    public void setCzasWolania(String czasWolania) {
        this.czasWolania = czasWolania;
    }

    @Basic
    @Column(name = "uwagi", nullable = true, length = 245)
    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    @Basic
    @Column(name = "katalog", nullable = true, length = 245)
    public String getKatalog() {
        return katalog;
    }

    public void setKatalog(String katalog) {
        this.katalog = katalog;
    }

    @Basic
    @Column(name = "rezultat", nullable = true, length = 245)
    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    @Basic
    @Column(name = "numer_negatywu", nullable = true, length = 200)
    public String getNumerNegatywu() {
        return numerNegatywu;
    }

    public void setNumerNegatywu(String numerNegatywu) {
        this.numerNegatywu = numerNegatywu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wywolania wywolania = (Wywolania) o;
        return id == wywolania.id &&
                Objects.equals(data, wywolania.data) &&
                Objects.equals(asa, wywolania.asa) &&
                Objects.equals(rozcienczenie, wywolania.rozcienczenie) &&
                Objects.equals(czasWolania, wywolania.czasWolania) &&
                Objects.equals(uwagi, wywolania.uwagi) &&
                Objects.equals(katalog, wywolania.katalog) &&
                Objects.equals(rezultat, wywolania.rezultat) &&
                Objects.equals(numerNegatywu, wywolania.numerNegatywu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, asa, rozcienczenie, czasWolania, uwagi, katalog, rezultat, numerNegatywu);
    }

    @ManyToOne
    @JoinColumn(name = "filmy", referencedColumnName = "ID", nullable = false)
    public Filmy getFilmyByFilmy() {
        return filmyByFilmy;
    }

    public void setFilmyByFilmy(Filmy filmyByFilmy) {
        this.filmyByFilmy = filmyByFilmy;
    }

    @ManyToOne
    @JoinColumn(name = "chemikalia", referencedColumnName = "ID", nullable = false)
    public Chemikalia getChemikaliaByChemikalia() {
        return chemikaliaByChemikalia;
    }

    public void setChemikaliaByChemikalia(Chemikalia chemikaliaByChemikalia) {
        this.chemikaliaByChemikalia = chemikaliaByChemikalia;
    }
}
