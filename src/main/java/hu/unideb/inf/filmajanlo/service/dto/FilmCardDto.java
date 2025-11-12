package hu.unideb.inf.filmajanlo.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Date;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class FilmCardDto {

    private Long id;
    private String cim;
    private Date megjelenes;
    @Min(value = 1, message = "Legalább 1 perc legyen a film")
    @Max(value = 500, message = "Legfeljebb 500 perc lehet a film")
    @Positive(message = "A játékidő nem lehet negatív")
    private Integer hossz;
    private String korhatar;
}
