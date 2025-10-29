package hu.unideb.inf.filmajanlo.service;

import hu.unideb.inf.filmajanlo.service.dto.BejelentkezesDto;
import hu.unideb.inf.filmajanlo.service.dto.RegisztracioDto;

public interface AuthenticationService {

    public void regisztracio(RegisztracioDto dto);
    public void bejelentkezes(BejelentkezesDto dto);
}
