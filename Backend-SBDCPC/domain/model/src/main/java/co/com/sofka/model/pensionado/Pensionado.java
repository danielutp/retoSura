package co.com.sofka.model.pensionado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
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

    public Pensionado(String id, Integer identificacion, String tipoIdentificacion, String nombres, String apellidos, Date fechaNacimiento, Double salario, Integer mesesCotizando, String genero, String fondoPensional) {
        this.id = id;
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.mesesCotizando = mesesCotizando;
        this.genero = genero;
        this.fondoPensional = fondoPensional;
    }

    public Pensionado() {
    }
}
