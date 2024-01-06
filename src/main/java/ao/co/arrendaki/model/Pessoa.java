package ao.co.arrendaki.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkPessoa;

    private String nomeCompleto;
    private String numIdentidadePessoal;
    private String contactoTelefonico;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "fk_localidade")
    private Localidade localidade;

}
