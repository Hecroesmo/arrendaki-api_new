package ao.co.arrendaki.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkConta;

    private String username;
    private String senha;
    private String iban;

    @OneToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;

    @JsonIgnore
    @OneToMany(mappedBy = "proprietario")
    private List<Residencia> residencias;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Contrato> contratos;
}
