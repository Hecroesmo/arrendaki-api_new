package ao.co.arrendaki.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkLocalidade;

    private String designacao;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_localidade_pai")
    private Localidade localidadePai;

    @JsonIgnore
    @OneToMany(mappedBy = "localidade")

    private List<Pessoa> pessoas;

    @JsonIgnore
    @OneToMany(mappedBy = "localidade")
    private List<Residencia> residencias;
}
