package hu.unideb.inf.filmajanlo.data.repository;

import hu.unideb.inf.filmajanlo.data.entity.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosultsagRepository
        extends JpaRepository<JogosultsagEntity, Long> {

    JogosultsagEntity findByNev(String nev);
}
