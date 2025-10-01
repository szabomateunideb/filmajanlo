package hu.unideb.inf.filmajanlo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Watchlist")
public class MegnezendoListaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String nev;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date letrehozasDatuma;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private FelhasznaloEntity felhasznalo;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "watchlist_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<FilmEntity> filmek;
}
