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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String nev;
    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date szuletesiDatum;
    @Column(name = "username", nullable = false, unique = true)
    private String felhasznalonev;
    @Column(name = "password", nullable = false)
    private String jelszo;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "gender")
    private String nem;
    @Column(name = "country_code")
    private String orszag;

    @OneToMany(mappedBy = "felhasznalo")
    private List<MegnezendoListaEntity> listak;
}
