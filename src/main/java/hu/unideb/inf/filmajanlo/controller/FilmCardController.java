package hu.unideb.inf.filmajanlo.controller;

import hu.unideb.inf.filmajanlo.service.FilmCardService;
import hu.unideb.inf.filmajanlo.service.dto.FilmCardDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
