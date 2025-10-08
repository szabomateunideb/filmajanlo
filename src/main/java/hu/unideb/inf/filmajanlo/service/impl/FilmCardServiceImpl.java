package hu.unideb.inf.filmajanlo.service.impl;

import hu.unideb.inf.filmajanlo.data.entity.FilmEntity;
import hu.unideb.inf.filmajanlo.data.repository.FilmRepository;
import hu.unideb.inf.filmajanlo.service.FilmCardService;
import hu.unideb.inf.filmajanlo.service.dto.FilmCardDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
@Service
public class FilmCardServiceImpl
        implements FilmCardService {

    final FilmRepository repo;
    final ModelMapper mapper;
    private final ModelMapper modelMapper;

    public FilmCardServiceImpl(FilmRepository repo
            , ModelMapper mapper, ModelMapper modelMapper) {
        this.repo = repo;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmCardDto findById(Long id) {
        FilmEntity filmEntity = repo.getReferenceById(id);
        FilmCardDto filmCardDto = mapper
                .map(filmEntity, FilmCardDto.class);
        return filmCardDto;
    }

    @Override
    public FilmCardDto findByCim(String cim) {
        //FilmEntity e = repo.getByCim(cim);
        //return modelMapper.map(e, FilmCardDto.class);

        List<FilmEntity> filmek = repo.findAll();
        for (FilmEntity filmEntity : filmek) {
            if (filmEntity.getCim().equals(cim)) {
                return mapper.map(filmEntity, FilmCardDto.class);
            }
        }
        return null;
    }

    @Override
    public List<FilmCardDto> findAll() {

        Type listType =
                new TypeToken<List<FilmCardDto>>(){}.getType();
        return modelMapper.map(repo.findAll(), listType);
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
