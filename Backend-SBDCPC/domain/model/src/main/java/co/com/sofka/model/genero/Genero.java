package co.com.sofka.model.genero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Genero {
    private String id;
    private String nombreGenero;

    public Genero(String id, String nombreGenero) {
        this.id = id;
        this.nombreGenero = nombreGenero;
    }

    public Genero() {
    }
}
