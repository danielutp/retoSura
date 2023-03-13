package co.com.sofka.model.tipoidentificacion.gateways;

import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoIdentificacionRepository {
    Mono<TipoIdentificacion> save(TipoIdentificacion tipoIdentificacion);

    Flux<TipoIdentificacion> findAll();

    Mono<Void> deleteById(String id);

    Mono<TipoIdentificacion> findById(String id);
}
