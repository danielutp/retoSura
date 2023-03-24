package co.com.sofka.model.pensionado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Pensionado {
    private String id;
    private Integer identificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private Double salario;
    private Integer mesesCotizando;
    private String genero;
    private String fondoPensional;

}
