package co.com.sofka.mongo.pensionado.repository;

import co.com.sofka.mongo.pensionado.document.PensionadoDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBPensionadoRepository extends ReactiveMongoRepository<PensionadoDocument, String>, ReactiveQueryByExampleExecutor<PensionadoDocument> {
}
