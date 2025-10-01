package hu.unideb.inf.filmajanlo.controller;

import hu.unideb.inf.filmajanlo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.filmajanlo.data.repository.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("api/felhasznalo")
public class FelhasznaloController {

    final   FelhasznaloRepository repo;

    public FelhasznaloController(FelhasznaloRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/init")
    public FelhasznaloEntity saveMock(){
        FelhasznaloEntity felhasznalo = new FelhasznaloEntity();
        felhasznalo.setEmail("xy@mail.com");
        felhasznalo.setNev("ouhzg");
        felhasznalo.setNem("N");
        felhasznalo.setSzuletesiDatum(Date.from(Instant.now()));
        felhasznalo.setFelhasznalonev("f1");
        felhasznalo.setJelszo("tzguhij");
        felhasznalo.setOrszag("HU");

        return repo.save(felhasznalo);

    }
}
