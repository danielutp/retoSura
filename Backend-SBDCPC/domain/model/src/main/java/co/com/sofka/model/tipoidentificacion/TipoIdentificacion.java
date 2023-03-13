package co.com.sofka.model.tipoidentificacion;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TipoIdentificacion {
    private String id;
    private String identificacion;
}