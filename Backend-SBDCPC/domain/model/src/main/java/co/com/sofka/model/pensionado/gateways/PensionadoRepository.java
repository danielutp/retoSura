package co.com.sofka.model.pensionado.gateways;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.Renta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PensionadoRepository {

    Mono<Pensionado> save(Pensionado pensionado);

    Mono<Pensionado> findByIdentificacion(Integer identificacion);

    Flux<Pensionado> findAll();

}
