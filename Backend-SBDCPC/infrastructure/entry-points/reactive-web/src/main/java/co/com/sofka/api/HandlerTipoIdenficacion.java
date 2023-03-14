package co.com.sofka.api;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.usecase.tipoidentificacion.actualizartipoidenficicacion.ActualizarTipoIdentificacionUseCase;
import co.com.sofka.usecase.tipoidentificacion.creartipoidenficicacion.CrearTipoIdentificacionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerTipoIdenficacion {
    private final CrearTipoIdentificacionUseCase crearTipoIdentificacionUseCase;
    private final ActualizarTipoIdentificacionUseCase actualizarTipoIdentificacionUseCase;

    public Mono<ServerResponse> crearTipoIdentificacionPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(TipoIdentificacion.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearTipoIdentificacionUseCase.crearTipoIdentificacion(e), TipoIdentificacion.class));
    }

    public Mono<ServerResponse> actualizarTipoIdentificacionPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(TipoIdentificacion.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(actualizarTipoIdentificacionUseCase.actualizarTipoIdentificacion(e), TipoIdentificacion.class));
    }
}
