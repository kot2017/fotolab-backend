package pl.wl.foto.reakt.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Historia {
    private int idHistoria;
    private Timestamp data;
    private Integer aparat;
    private Chemikalia chemikaliaByChemikalia;
    private Filmy filmyByFilmy;
    private Aparaty aparatyById;

    @Id
    @Column(name = "ID_historia", nullable = false)
    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    @Basic
    @Column(name = "data", nullable = true)
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Basic
    @Column(name = "aparat", nullable = true)
    public Integer getAparat() {
        return aparat;
    }

    public void setAparat(Integer aparat) {
        this.aparat = aparat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Historia historia = (Historia) o;
        return idHistoria == historia.idHistoria &&
                Objects.equals(data, historia.data) &&
                Objects.equals(aparat, historia.aparat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistoria, data, aparat);
    }

    @ManyToOne
    @JoinColumn(name = "chemikalia", referencedColumnName = "ID")
    public Chemikalia getChemikaliaByChemikalia() {
        return chemikaliaByChemikalia;
    }

    public void setChemikaliaByChemikalia(Chemikalia chemikaliaByChemikalia) {
        this.chemikaliaByChemikalia = chemikaliaByChemikalia;
    }

    @ManyToOne
    @JoinColumn(name = "filmy", referencedColumnName = "ID")
    public Filmy getFilmyByFilmy() {
        return filmyByFilmy;
    }

    public void setFilmyByFilmy(Filmy filmyByFilmy) {
        this.filmyByFilmy = filmyByFilmy;
    }

    @ManyToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    public Aparaty getAparatyById() {
        return aparatyById;
    }

    public void setAparatyById(Aparaty aparatyById) {
        this.aparatyById = aparatyById;
    }
}
