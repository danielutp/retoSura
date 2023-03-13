package co.com.sofka.mongo.genero.repository;

import co.com.sofka.mongo.genero.document.GeneroDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBGeneroRepository extends ReactiveMongoRepository<GeneroDocument, String>, ReactiveQueryByExampleExecutor<GeneroDocument> {
}
