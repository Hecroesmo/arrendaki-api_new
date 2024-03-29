package ao.co.arrendaki.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Localidade implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkLocalidade;

    private String designacao;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_localidade_pai")
    private Localidade localidadePai;

//    @JsonIgnore
//    @OneToMany(mappedBy = "localidade")
//
//    private List<Pessoa> pessoas;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "localidade")
//    private List<Residencia> residencias;
}
