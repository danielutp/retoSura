package co.com.sofka.model.tipoidentificacion.gateways;

import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import reactor.core.publisher.Mono;

public interface TipoIdentificacionRepository {
    Mono<TipoIdentificacion> save(TipoIdentificacion tipoIdentificacion);
    Mono<TipoIdentificacion> update(TipoIdentificacion tipoIdentificacion);
}
