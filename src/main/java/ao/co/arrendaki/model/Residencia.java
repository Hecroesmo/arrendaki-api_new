package ao.co.arrendaki.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkResidencia;

    private String endereco;
    private double precoMensal;
    private boolean ehMobilidado;
    private Boolean ehAprovado;

    @Lob
    private String foto;

    @ManyToOne
    @JoinColumn(name = "fk_localidade")
    private Localidade localidade;

    @ManyToOne
    @JoinColumn(name = "fk_tipologia")
    private Tipologia tipologia;

    @ManyToOne
    @JoinColumn(name = "fk_proprietario")
    private Conta proprietario;

    @JsonIgnore
    @OneToMany(mappedBy = "residencia")
    @Nullable
    private List<Contrato> contratos;
}
