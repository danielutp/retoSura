package co.com.sofka.mongo.tipoidentificacion.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoIdentificacionDocument {
    @Id
    private String id;
    private String identificacion;
}
