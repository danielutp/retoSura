package co.com.sofka.model.fondopensional;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FondoPensional {
    private String id;
    private Integer idFondo;
    private String nombreFondo;

    public FondoPensional(String id,Integer idFondo, String nombreFondo) {
        this.id = id;
        this.nombreFondo = nombreFondo;
        this.idFondo = idFondo;
    }


    public FondoPensional() {
    }
}
