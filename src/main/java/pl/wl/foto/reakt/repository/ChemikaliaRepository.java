package pl.wl.foto.reakt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wl.foto.reakt.entity.Chemikalia;

import java.util.List;


@Repository
public interface ChemikaliaRepository extends CrudRepository<Chemikalia, Integer> {

    List<Chemikalia> findChemikaliaByProducent(Integer id);

}
