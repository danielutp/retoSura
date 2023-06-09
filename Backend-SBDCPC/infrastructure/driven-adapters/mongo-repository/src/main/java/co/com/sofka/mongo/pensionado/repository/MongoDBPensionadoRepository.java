package co.com.sofka.mongo.pensionado.repository;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.mongo.pensionado.document.PensionadoDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MongoDBPensionadoRepository extends ReactiveMongoRepository<PensionadoDocument, String>, ReactiveQueryByExampleExecutor<PensionadoDocument> {

    Mono<Pensionado> findAllByIdentificacion(Integer identificacion);


}
