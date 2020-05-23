package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Filmy {
    private int id;
    private String typ;
    private String nominalAsa;
    private String expDate;
    private String seria;
    private int producent;
    private String nazwa;
    private String opis;
    private String symbol;
    private String link;
    private String fot;
    private String katalog;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typ", nullable = true, length = 45)
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Basic
    @Column(name = "nominal_asa", nullable = true, length = 45)
    public String getNominalAsa() {
        return nominalAsa;
    }

    public void setNominalAsa(String nominalAsa) {
        this.nominalAsa = nominalAsa;
    }

    @Basic
    @Column(name = "exp_date", nullable = true, length = 45)
    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "seria", nullable = true, length = 45)
    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    @Basic
    @Column(name = "producent", nullable = true)
    public int getProducent() {
        return producent;
    }

    public void setProducent(int producent) {
        this.producent = producent;
    }

    @Basic
    @Column(name = "nazwa", nullable = false)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "opis" , nullable = true)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Basic
    @Column(name = "symbol", nullable = true)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "link", nullable = true)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

@Basic
@Column(name = "fot", nullable = false)
    public String getFot() {
        return fot;
    }

    public void setFot(String fot) {
        this.fot = fot;
    }

    @Basic
    @Column(name="katalog", nullable = true)
    public String getKatalog() {
        return katalog;
    }

    public void setKatalog(String katalog) {
        this.katalog = katalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmy filmy = (Filmy) o;
        return id == filmy.id &&
                Objects.equals(typ, filmy.typ) &&
                Objects.equals(nominalAsa, filmy.nominalAsa) &&
                Objects.equals(expDate, filmy.expDate) &&
                Objects.equals(seria, filmy.seria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typ, nominalAsa, expDate, seria);
    }
}
