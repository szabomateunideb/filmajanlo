package hu.unideb.inf.filmajanlo.controller;

import hu.unideb.inf.filmajanlo.service.FilmCardService;
import hu.unideb.inf.filmajanlo.service.dto.FilmCardDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/film")
public class FilmCardController {

    final FilmCardService filmCardService;
    public FilmCardController(FilmCardService filmCardService) {
        this.filmCardService = filmCardService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('FELHASZNALO','ADMIN')")
    public FilmCardDto save(@RequestBody FilmCardDto dto){
        //System.out.println("Film mentése "+ dto.getCim());
        return filmCardService.save(dto);
    }

    @GetMapping("/byId")
    @PreAuthorize("hasAuthority('ADMIN')")
    public FilmCardDto getById(@RequestParam Long id){
        return filmCardService.findById(id);
    }

    @GetMapping("/byCim/{cim}")
    public FilmCardDto getByCim(@PathVariable  String cim){
        return filmCardService.findByCim(cim);
    }
}
