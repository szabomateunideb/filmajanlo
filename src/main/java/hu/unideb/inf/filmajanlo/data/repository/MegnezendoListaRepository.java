package hu.unideb.inf.filmajanlo.data.repository;

import hu.unideb.inf.filmajanlo.data.entity.MegnezendoListaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MegnezendoListaRepository
        extends JpaRepository<MegnezendoListaEntity, Long> {
}
