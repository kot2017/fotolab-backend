package pl.wl.foto.reakt.api;

import pl.wl.foto.reakt.entity.*;

import java.util.List;
import java.util.Objects;

public class AllResources {

    private List<Filmy> filmy;
    private List<Chemikalia> chemikalia;
    private List<Aparaty> aparaty;
    private List<Obiektywy> obiektywy;
    private List<Producent> producenci;


    public List<Filmy> getFilmy() {
        return filmy;
    }

    public void setFilmy(List<Filmy> filmy) {
        this.filmy = filmy;
    }

    public List<Chemikalia> getChemikalia() {
        return chemikalia;
    }

    public void setChemikalia(List<Chemikalia> chemikalia) {
        this.chemikalia = chemikalia;
    }


    public List<Aparaty> getAparaty() {
        return aparaty;
    }

    public void setAparaty(List<Aparaty> aparaty) {
        this.aparaty = aparaty;
    }

    public List<Obiektywy> getObiektywy() {
        return obiektywy;
    }

    public void setObiektywy(List<Obiektywy> obiektywy) {
        this.obiektywy = obiektywy;
    }

    public List<Producent> getProducenci() {
        return producenci;
    }

    public void setProducenci(List<Producent> producenci) {
        this.producenci = producenci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllResources)) return false;
        AllResources that = (AllResources) o;
        return Objects.equals(getFilmy(), that.getFilmy()) &&
                Objects.equals(getChemikalia(), that.getChemikalia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilmy(), getChemikalia());
    }



}
