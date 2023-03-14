package co.com.sofka.model.genero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Genero {
    private String id;
    private String genero;

    public Genero(String id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public Genero() {
    }
}
