package co.com.sofka.model.pensionado;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Pensionado {
    private String id;
    private Integer numeroIdentificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private double salarioCausante;
    private Integer mesesCotizando;
    private String genero;
    private String fondoPensional;
}
