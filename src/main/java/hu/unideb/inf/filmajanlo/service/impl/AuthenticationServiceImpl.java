package hu.unideb.inf.filmajanlo.service.impl;

import hu.unideb.inf.filmajanlo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.filmajanlo.data.entity.JogosultsagEntity;
import hu.unideb.inf.filmajanlo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.filmajanlo.data.repository.JogosultsagRepository;
import hu.unideb.inf.filmajanlo.service.AuthenticationService;
import hu.unideb.inf.filmajanlo.service.dto.BejelentkezesDto;
import hu.unideb.inf.filmajanlo.service.dto.RegisztracioDto;
import hu.unideb.inf.filmajanlo.service.mapper.FelhasznaloMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl
        implements AuthenticationService {

    private final FelhasznaloRepository felhRepo;
    private final JogosultsagRepository jogRepo;
    private final FelhasznaloMapper felhMapper;
    private final FelhasznaloMapper felhasznaloMapper;

    public AuthenticationServiceImpl(FelhasznaloRepository felhRepo, JogosultsagRepository jogRepo, FelhasznaloMapper felhMapper, FelhasznaloMapper felhasznaloMapper) {
        this.felhRepo = felhRepo;
        this.jogRepo = jogRepo;
        this.felhMapper = felhMapper;
        this.felhasznaloMapper = felhasznaloMapper;
    }

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity e = felhasznaloMapper.regisztracioToEntity(dto);
        JogosultsagEntity jog = jogRepo.findByNev("FELHASZNALO");
        if(jog != null){
            e.setJogosultsag(jog);
        } else {
            jog =  new JogosultsagEntity();
            jog.setNev("FELHASZNALO");
            jog = jogRepo.save(jog);

            e.setJogosultsag(jog);
        }
        felhRepo.save(e);
    }

    @Override
    public void bejelentkezes(BejelentkezesDto dto) {

    }
}
