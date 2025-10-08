package hu.unideb.inf.filmajanlo.data.repository;

import hu.unideb.inf.filmajanlo.data.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository
        extends JpaRepository<FilmEntity, Long> {

    FilmEntity getByCim(String cim);
}
