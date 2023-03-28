package co.com.sofka.mongo.fondopensional.repository;

import co.com.sofka.mongo.fondopensional.document.FondoPensionalDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBFondoPensionalRepository extends ReactiveMongoRepository<FondoPensionalDocument, String>, ReactiveQueryByExampleExecutor<FondoPensionalDocument> {
}
