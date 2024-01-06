package ao.co.arrendaki.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LocalidadeRequest implements Serializable {
    private final String designacao;
    private final long localidadePai;
}
