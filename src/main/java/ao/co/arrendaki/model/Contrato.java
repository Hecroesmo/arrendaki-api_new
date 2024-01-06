package ao.co.arrendaki.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkContrato;

    private boolean ehSemestral;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "fk_residencia")
    private Residencia residencia;

}
