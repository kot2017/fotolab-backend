package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Aparaty {
    private int id;
    private String nazwa;
    private String model;
    private String opis;
    private String numerSeryjny;
    private String numerInwentarzowy;
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
    @Column(name = "model", nullable = true, length = 50)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "opis", nullable = true, length = 50)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Basic
    @Column(name = "numer_seryjny", nullable = true, length = 50)
    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        this.numerSeryjny = numerSeryjny;
    }

    @Basic
    @Column(name = "numer_inwentarzowy", nullable = true, length = 50)
    public String getNumerInwentarzowy() {
        return numerInwentarzowy;
    }

    public void setNumerInwentarzowy(String numerInwentarzowy) {
        this.numerInwentarzowy = numerInwentarzowy;
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
        Aparaty aparaty = (Aparaty) o;
        return id == aparaty.id &&
                Objects.equals(nazwa, aparaty.nazwa) &&
                Objects.equals(model, aparaty.model) &&
                Objects.equals(opis, aparaty.opis) &&
                Objects.equals(numerSeryjny, aparaty.numerSeryjny) &&
                Objects.equals(numerInwentarzowy, aparaty.numerInwentarzowy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, model, opis, numerSeryjny, numerInwentarzowy);
    }
}
