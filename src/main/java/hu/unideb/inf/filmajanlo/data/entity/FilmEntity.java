package hu.unideb.inf.filmajanlo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Movie")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String cim;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date megjelenes;
    @Column(name = "length")
    private Integer hossz;
    @Column(name = "description")
    private String leiras;
    @Column(name = "director")
    private String rendezo;
    @Column(name = "original_language")
    private String eredetiNyelv;
    @Column(name = "pg_level")
    private String korhatar;

}