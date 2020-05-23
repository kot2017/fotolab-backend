package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Chemikalia {
    private int id;
    private String nazwa;
    private Date dataProdukcji;
    private String expDate;
    private String sklad;
    private String uwagi;
    private int producent;
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
    @Column(name = "nazwa", nullable = true, length = 45)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "data_produkcji", nullable = true)
    public Date getDataProdukcji() {
        return dataProdukcji;
    }

    public void setDataProdukcji(Date dataProdukcji) {
        this.dataProdukcji = dataProdukcji;
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
    @Column(name = "sklad", nullable = true, length = 1000)
    public String getSklad() {
        return sklad;
    }

    public void setSklad(String sklad) {
        this.sklad = sklad;
    }

    @Basic
    @Column(name = "uwagi", nullable = true, length = 45)
    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
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
    @Column(name = "opis" , nullable = true)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chemikalia that = (Chemikalia) o;
        return id == that.id &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(dataProdukcji, that.dataProdukcji) &&
                Objects.equals(expDate, that.expDate) &&
                Objects.equals(sklad, that.sklad) &&
                Objects.equals(uwagi, that.uwagi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, dataProdukcji, expDate, sklad, uwagi);
    }
}
