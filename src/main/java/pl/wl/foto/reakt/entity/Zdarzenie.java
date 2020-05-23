package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Zdarzenie {
    private int id;
    private String nazwa;
    private String opis;
    private Integer historia;

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
    @Column(name = "historia", nullable = true)
    public Integer getHistoria() {
        return historia;
    }

    public void setHistoria(Integer historia) {
        this.historia = historia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zdarzenie zdarzenie = (Zdarzenie) o;
        return id == zdarzenie.id &&
                Objects.equals(nazwa, zdarzenie.nazwa) &&
                Objects.equals(opis, zdarzenie.opis) &&
                Objects.equals(historia, zdarzenie.historia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, opis, historia);
    }
}
