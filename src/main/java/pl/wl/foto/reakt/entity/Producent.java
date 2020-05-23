package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Producent {
    private int id;
    private String nazwa;
    private String opis;
    private String link;
    private String fot;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazwa", nullable = true, length = 50)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "opis", nullable = true, length = -1)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Basic
    @Column(name = "link", nullable = true, length = 50)
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producent producent = (Producent) o;
        return id == producent.id &&
                Objects.equals(nazwa, producent.nazwa) &&
                Objects.equals(opis, producent.opis) &&
                Objects.equals(link, producent.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, opis, link);
    }
}
