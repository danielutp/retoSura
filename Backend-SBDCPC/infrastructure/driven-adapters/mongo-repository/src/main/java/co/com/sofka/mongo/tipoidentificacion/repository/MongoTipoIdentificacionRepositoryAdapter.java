package co.com.sofka.mongo.tipoidentificacion.repository;

import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.tipoidentificacion.document.TipoIdentificacionDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoTipoIdentificacionRepositoryAdapter extends AdapterOperations<TipoIdentificacion, TipoIdentificacionDocument, String, MongoDBTipoIdentificacionRepository>
    implements TipoIdentificacionRepository {

    public MongoTipoIdentificacionRepositoryAdapter(MongoDBTipoIdentificacionRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, TipoIdentificacion.class));
    }
}
