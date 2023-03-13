package co.com.sofka.model.fondopensional;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FondoPensional {
    private String id;
    private String nombreFondo;
}
