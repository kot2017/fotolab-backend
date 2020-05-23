package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Wyniki {
    private int id;
    private String plik;
    private String opis;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "plik", nullable = true, length = 245)
    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Basic
    @Column(name = "opis", nullable = true, length = 45)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wyniki wyniki = (Wyniki) o;
        return id == wyniki.id &&
                Objects.equals(plik, wyniki.plik) &&
                Objects.equals(opis, wyniki.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plik, opis);
    }
}
