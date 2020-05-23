package pl.wl.foto.reakt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wl.foto.reakt.entity.Filmy;

import java.util.List;


@Repository
public interface FilmyRepository extends CrudRepository<Filmy, Integer> {

     List<Filmy> findFilmyByProducent(Integer id);
}
