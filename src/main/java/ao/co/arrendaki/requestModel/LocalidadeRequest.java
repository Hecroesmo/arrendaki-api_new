package ao.co.arrendaki.requestModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class LocalidadeRequest implements Serializable {
    private final String designacao;
    private final Long localidadePai;
}
