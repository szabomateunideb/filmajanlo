package hu.unideb.inf.filmajanlo.controller;

import hu.unideb.inf.filmajanlo.service.FilmCardService;
import hu.unideb.inf.filmajanlo.service.dto.FilmCardDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/film")
public class FilmCardController {

    final FilmCardService filmCardService;
    public FilmCardController(FilmCardService filmCardService) {
        this.filmCardService = filmCardService;
    }

    @PostMapping("/save")
    public FilmCardDto save(@RequestBody FilmCardDto dto){
        return filmCardService.save(dto);
    }

    @GetMapping("/byId")
    public FilmCardDto getById(@RequestParam Long id){
        return filmCardService.findById(id);
    }

    @GetMapping("/byCim/{cim}")
    public FilmCardDto getByCim(@PathVariable  String cim){
        return filmCardService.findByCim(cim);
    }
}
