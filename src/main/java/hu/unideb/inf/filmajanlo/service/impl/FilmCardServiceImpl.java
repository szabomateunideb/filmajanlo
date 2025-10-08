package hu.unideb.inf.filmajanlo.service.impl;

import hu.unideb.inf.filmajanlo.data.entity.FilmEntity;
import hu.unideb.inf.filmajanlo.data.repository.FilmRepository;
import hu.unideb.inf.filmajanlo.service.FilmCardService;
import hu.unideb.inf.filmajanlo.service.dto.FilmCardDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmCardServiceImpl
        implements FilmCardService {

    final FilmRepository repo;
    final ModelMapper mapper;

    public FilmCardServiceImpl(FilmRepository repo
            , ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public FilmCardDto findById(Long id) {
        return null;
    }

    @Override
    public FilmCardDto findByCim(String cim) {
        return null;
    }

    @Override
    public List<FilmCardDto> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public FilmCardDto save(FilmCardDto filmCardDto) {
        FilmEntity filmEntity = mapper
                .map(filmCardDto, FilmEntity.class);

        filmEntity = repo.save(filmEntity);

        filmCardDto = mapper
                .map(filmEntity, FilmCardDto.class);

        return filmCardDto;
    }
}
