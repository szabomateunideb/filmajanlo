package hu.unideb.inf.filmajanlo.service;

import hu.unideb.inf.filmajanlo.service.dto.FilmCardDto;

import java.util.List;

public interface FilmCardService {

    FilmCardDto findById(Long id);
    FilmCardDto findByCim(String cim);
    List<FilmCardDto> findAll();
    void deleteById(Long id);
    FilmCardDto save(FilmCardDto filmCardDto);

}
