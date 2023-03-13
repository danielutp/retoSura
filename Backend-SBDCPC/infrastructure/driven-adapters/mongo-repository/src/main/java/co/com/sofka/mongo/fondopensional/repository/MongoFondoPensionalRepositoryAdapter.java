package co.com.sofka.mongo.fondopensional.repository;


import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import co.com.sofka.mongo.fondopensional.document.FondoPensionalDocument;
import co.com.sofka.mongo.genero.document.GeneroDocument;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoFondoPensionalRepositoryAdapter extends AdapterOperations<FondoPensional, FondoPensionalDocument, String, MongoDBFondoPensionalRepository>
    implements FondoPensionalRepository {

    public MongoFondoPensionalRepositoryAdapter(MongoDBFondoPensionalRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, FondoPensional.class));
    }
}
