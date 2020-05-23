package pl.wl.foto.reakt.api;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Wywolanie {

    private Integer id;
    private Date data;
    private Integer asa;
    private String rozcienczenie;
    private String czasWolania;
    private String uwagi;
    private String katalog;
    private String rezultat;
    private String numerNegatywu;
    private Integer filmId;
    private Integer chemikaliaId;
    private String filmName;
    private String chemiaName;

    private List<String> images;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getAsa() {
        return asa;
    }

    public void setAsa(Integer asa) {
        this.asa = asa;
    }

    public String getRozcienczenie() {
        return rozcienczenie;
    }

    public void setRozcienczenie(String rozcienczenie) {
        this.rozcienczenie = rozcienczenie;
    }

    public String getCzasWolania() {
        return czasWolania;
    }

    public void setCzasWolania(String czasWolania) {
        this.czasWolania = czasWolania;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public String getKatalog() {
        return katalog;
    }

    public void setKatalog(String katalog) {
        this.katalog = katalog;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public String getNumerNegatywu() {
        return numerNegatywu;
    }

    public void setNumerNegatywu(String numerNegatywu) {
        this.numerNegatywu = numerNegatywu;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getChemikaliaId() {
        return chemikaliaId;
    }

    public void setChemikaliaId(Integer chemikaliaId) {
        this.chemikaliaId = chemikaliaId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getChemiaName() {
        return chemiaName;
    }

    public void setChemiaName(String chemiaName) {
        this.chemiaName = chemiaName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wywolanie)) return false;
        Wywolanie wywolanie = (Wywolanie) o;
        return Objects.equals(getData(), wywolanie.getData()) &&
                Objects.equals(getAsa(), wywolanie.getAsa()) &&
                Objects.equals(getRozcienczenie(), wywolanie.getRozcienczenie()) &&
                Objects.equals(getCzasWolania(), wywolanie.getCzasWolania()) &&
                Objects.equals(getUwagi(), wywolanie.getUwagi()) &&
                Objects.equals(getKatalog(), wywolanie.getKatalog()) &&
                Objects.equals(getRezultat(), wywolanie.getRezultat()) &&
                Objects.equals(getNumerNegatywu(), wywolanie.getNumerNegatywu()) &&
                Objects.equals(getFilmId(), wywolanie.getFilmId()) &&
                Objects.equals(getChemikaliaId(), wywolanie.getChemikaliaId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getAsa(), getRozcienczenie(), getCzasWolania(), getUwagi(), getKatalog(), getRezultat(), getNumerNegatywu(), getFilmId(), getChemikaliaId());
    }

    @Override
    public String toString() {
        return "Wywolanie{" +
                "id=" + id +
                ", data=" + data +
                ", asa=" + asa +
                ", rozcienczenie='" + rozcienczenie + '\'' +
                ", czasWolania='" + czasWolania + '\'' +
                ", uwagi='" + uwagi + '\'' +
                ", katalog='" + katalog + '\'' +
                ", rezultat='" + rezultat + '\'' +
                ", numerNegatywu='" + numerNegatywu + '\'' +
                ", filmId=" + filmId +
                ", chemikaliaId=" + chemikaliaId +
                ", filmName='" + filmName + '\'' +
                ", chemiaName='" + chemiaName + '\'' +
                ", images=" + images +
                '}';
    }



}

