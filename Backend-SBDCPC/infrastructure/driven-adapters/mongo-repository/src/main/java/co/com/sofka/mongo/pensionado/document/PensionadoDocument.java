package co.com.sofka.mongo.pensionado.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "Pensionado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionadoDocument {
    @Id
    private String id;
    private Integer identificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private double salario;
    private Integer mesesCotizando;
    private String genero;
    private String fondoPensional;
}
