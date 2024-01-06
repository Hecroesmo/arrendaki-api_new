package ao.co.arrendaki.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Tipologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkTipologia;

    private String designacao;

    @JsonIgnore
    @OneToMany(mappedBy = "tipologia")
    private List<Residencia> residencias;
}
