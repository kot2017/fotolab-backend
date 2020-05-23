package pl.wl.foto.reakt.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wl.foto.reakt.entity.Zdarzenie;

public interface ZdarzenieRepository extends CrudRepository<Zdarzenie, Integer> {
}
