package hu.unideb.inf.filmajanlo.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private Integer hossz;
    private String korhatar;
}
