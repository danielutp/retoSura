package co.com.sofka.mongo.genero.repository;


import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import co.com.sofka.mongo.fondopensional.document.FondoPensionalDocument;
import co.com.sofka.mongo.genero.document.GeneroDocument;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoGeneroRepositoryAdapter extends AdapterOperations<Genero, GeneroDocument, String, MongoDBGeneroRepository>
    implements GeneroRepository {

    public MongoGeneroRepositoryAdapter(MongoDBGeneroRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Genero.class));
    }

    @Override
    public Mono<Genero> update(Genero genero) {
        var id = genero.getId();
        return repository.findById(id).flatMap(e -> repository.save(new GeneroDocument(genero.getId(), genero.getGenero()))
                .flatMap(x -> Mono.just(genero)));

    }
}
