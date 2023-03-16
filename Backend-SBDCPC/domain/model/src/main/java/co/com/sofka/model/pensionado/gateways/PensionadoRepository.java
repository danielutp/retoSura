package co.com.sofka.model.pensionado.gateways;

import co.com.sofka.model.pensionado.Pensionado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PensionadoRepository {

    Mono<Pensionado> save(Pensionado pensionado);

    Mono<Pensionado> findByIdentificacion(Integer identificacion);

    Flux<Pensionado> findAll();

    Mono<Pensionado> findById(String id);


}
