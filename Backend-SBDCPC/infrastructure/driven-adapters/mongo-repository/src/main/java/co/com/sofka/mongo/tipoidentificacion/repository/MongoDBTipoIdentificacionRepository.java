package co.com.sofka.mongo.tipoidentificacion.repository;

import co.com.sofka.mongo.tipoidentificacion.document.TipoIdentificacionDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBTipoIdentificacionRepository extends ReactiveMongoRepository<TipoIdentificacionDocument, String>, ReactiveQueryByExampleExecutor<TipoIdentificacionDocument> {
}
