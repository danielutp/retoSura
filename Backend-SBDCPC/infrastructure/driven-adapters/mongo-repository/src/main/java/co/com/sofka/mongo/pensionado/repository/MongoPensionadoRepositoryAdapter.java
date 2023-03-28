package co.com.sofka.mongo.pensionado.repository;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.pensionado.document.PensionadoDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoPensionadoRepositoryAdapter extends AdapterOperations<Pensionado, PensionadoDocument, String, MongoDBPensionadoRepository>
    implements PensionadoRepository {

    public MongoPensionadoRepositoryAdapter(MongoDBPensionadoRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Pensionado.class));
    }

    @Override
    public Mono<Pensionado> findByIdentificacion(Integer identificacion) {
        return repository.findAllByIdentificacion(identificacion);
    }
}
