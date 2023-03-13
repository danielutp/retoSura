package co.com.sofka.mongo.pensionado.repository;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.pensionado.document.PensionadoDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoPensionadoRepositoryAdapter extends AdapterOperations<Pensionado, PensionadoDocument, String, MongoDBPensionadoRepository>
    implements PensionadoRepository {

    public MongoPensionadoRepositoryAdapter(MongoDBPensionadoRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Pensionado.class));
    }
}
