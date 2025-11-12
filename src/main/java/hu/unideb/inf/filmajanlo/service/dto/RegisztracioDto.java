package hu.unideb.inf.filmajanlo.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisztracioDto {
    @NotBlank(message = "Nem lehet üres")
    @Size(min = 10, max = 200, message = "10 és 200 közöt legyen")
    private String nev;
    @Past
    private LocalDate szuletesiDatum;
    private String felhasznalonev;
    private String jelszo;
    @Email
    private String email;
}
