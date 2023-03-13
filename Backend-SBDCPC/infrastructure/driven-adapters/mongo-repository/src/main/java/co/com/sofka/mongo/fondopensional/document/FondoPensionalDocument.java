package co.com.sofka.mongo.fondopensional.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FondoPensionalDocument {
    @Id
    private String id;
    private String nombreFondo;

}
