package pl.wl.foto.reakt.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Obiektywy {
    private int id;
    private String nazwa;
    private String jasnosc;
    private Integer ogniskowa;
    private Integer srednica;
    private Date dataZakupu;
    private String zrodloZakupu;
    private String montowanie;
    private Integer column10;
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
    @Column(name = "nazwa", nullable = true, length = 100)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "jasnosc", nullable = true, length = 10)
    public String getJasnosc() {
        return jasnosc;
    }

    public void setJasnosc(String jasnosc) {
        this.jasnosc = jasnosc;
    }

    @Basic
    @Column(name = "ogniskowa", nullable = true)
    public Integer getOgniskowa() {
        return ogniskowa;
    }

    public void setOgniskowa(Integer ogniskowa) {
        this.ogniskowa = ogniskowa;
    }

    @Basic
    @Column(name = "srednica", nullable = true)
    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    @Basic
    @Column(name = "data_zakupu", nullable = true)
    public Date getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(Date dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    @Basic
    @Column(name = "zrodlo_zakupu", nullable = true, length = 300)
    public String getZrodloZakupu() {
        return zrodloZakupu;
    }

    public void setZrodloZakupu(String zrodloZakupu) {
        this.zrodloZakupu = zrodloZakupu;
    }

    @Basic
    @Column(name = "montowanie", nullable = true, length = 50)
    public String getMontowanie() {
        return montowanie;
    }

    public void setMontowanie(String montowanie) {
        this.montowanie = montowanie;
    }

    @Basic
    @Column(name = "column_10", nullable = true)
    public Integer getColumn10() {
        return column10;
    }

    public void setColumn10(Integer column10) {
        this.column10 = column10;
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
        Obiektywy obiektywy = (Obiektywy) o;
        return id == obiektywy.id &&
                Objects.equals(nazwa, obiektywy.nazwa) &&
                Objects.equals(jasnosc, obiektywy.jasnosc) &&
                Objects.equals(ogniskowa, obiektywy.ogniskowa) &&
                Objects.equals(srednica, obiektywy.srednica) &&
                Objects.equals(dataZakupu, obiektywy.dataZakupu) &&
                Objects.equals(zrodloZakupu, obiektywy.zrodloZakupu) &&
                Objects.equals(montowanie, obiektywy.montowanie) &&
                Objects.equals(column10, obiektywy.column10);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, jasnosc, ogniskowa, srednica, dataZakupu, zrodloZakupu, montowanie, column10);
    }
}
