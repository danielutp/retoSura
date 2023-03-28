package co.com.sofka.mongo.fondopensional.repository;


import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import co.com.sofka.mongo.fondopensional.document.FondoPensionalDocument;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoFondoPensionalRepositoryAdapter extends AdapterOperations<FondoPensional, FondoPensionalDocument, String, MongoDBFondoPensionalRepository>
    implements FondoPensionalRepository {

    public MongoFondoPensionalRepositoryAdapter(MongoDBFondoPensionalRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, FondoPensional.class));
    }

    @Override
    public Mono<FondoPensional> update(FondoPensional fondoPensional) {
        var id = fondoPensional.getId();
        return repository.findById(id).flatMap(e -> repository.save(new FondoPensionalDocument(fondoPensional.getId(),fondoPensional.getIdFondo() ,fondoPensional.getNombreFondo()))
                .flatMap(x -> Mono.just(fondoPensional)));
    }
}
