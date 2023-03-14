package co.com.sofka.usecase.tipoidentificacion.actualizartipoidenficicacion;

import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarTipoIdentificacionUseCase {

    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    public Mono<TipoIdentificacion> actualizarTipoIdentificacion(TipoIdentificacion tipoIdentificacion){
        return  tipoIdentificacionRepository.update(tipoIdentificacion);
    }
}
