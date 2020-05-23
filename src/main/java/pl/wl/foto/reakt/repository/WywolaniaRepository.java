package pl.wl.foto.reakt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wl.foto.reakt.entity.Chemikalia;
import pl.wl.foto.reakt.entity.Filmy;
import pl.wl.foto.reakt.entity.Wywolania;

import java.util.List;


@Repository
public interface WywolaniaRepository extends CrudRepository<Wywolania, Integer> {

       Wywolania findFirstByAsaAndAndRozcienczenieAndFilmyByFilmyAndChemikaliaByChemikalia(Integer ASA, Integer rozcienczenie, Filmy filmy, Chemikalia chemikalia);

}
