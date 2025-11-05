package hu.unideb.inf.filmajanlo.service.impl;

import hu.unideb.inf.filmajanlo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.filmajanlo.data.entity.JogosultsagEntity;
import hu.unideb.inf.filmajanlo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.filmajanlo.data.repository.JogosultsagRepository;
import hu.unideb.inf.filmajanlo.service.AuthenticationService;
import hu.unideb.inf.filmajanlo.service.dto.BejelentkezesDto;
import hu.unideb.inf.filmajanlo.service.dto.RegisztracioDto;
import hu.unideb.inf.filmajanlo.service.mapper.FelhasznaloMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl
        implements AuthenticationService {

    private final FelhasznaloRepository felhRepo;
    private final JogosultsagRepository jogRepo;
    private final FelhasznaloMapper felhasznaloMapper;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity e = felhasznaloMapper.regisztracioToEntity(dto);
        e.setJelszo(passwordEncoder.encode(e.getJelszo()));
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
        SecurityContext context =
                SecurityContextHolder.createEmptyContext();

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getFelhasznalonev(),
                        dto.getJelszo()
                )
        );
        context.setAuthentication(auth);
        SecurityContextHolder.setContext(context);

    }
}
