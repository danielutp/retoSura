package co.com.sofka.usecase.tipoidentificacion.creartipoidenficicacion;

import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearTipoIdentificacionUseCase {

    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    public Mono<TipoIdentificacion> crearTipoIdentificacion(TipoIdentificacion tipoIdentificacion){
        return  tipoIdentificacionRepository.save(tipoIdentificacion);
    }
}
