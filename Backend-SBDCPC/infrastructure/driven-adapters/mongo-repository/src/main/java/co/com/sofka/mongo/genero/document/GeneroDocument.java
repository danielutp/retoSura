package co.com.sofka.mongo.genero.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Genero")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneroDocument {
    @Id
    private String id;
    private String genero;
}
