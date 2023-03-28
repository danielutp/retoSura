package co.com.sofka.model.tipoidentificacion;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TipoIdentificacion {
    private String id;
    private String identificacion;

    public TipoIdentificacion(String id, String identificacion) {
        this.id = id;
        this.identificacion = identificacion;
    }

    public TipoIdentificacion() {
    }
}