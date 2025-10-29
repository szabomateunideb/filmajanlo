package hu.unideb.inf.filmajanlo.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisztracioDto {
    private String nev;
    private LocalDate szuletesiDatum;
    private String felhasznalonev;
    private String jelszo;
    private String email;
}
