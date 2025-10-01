package hu.unideb.inf.filmajanlo.data.repository;

import hu.unideb.inf.filmajanlo.data.entity.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository
        extends JpaRepository<FelhasznaloEntity, Long> {
}
