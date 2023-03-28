package co.com.sofka.api;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.usecase.genero.actualizargenero.ActualizarGeneroUseCase;
import co.com.sofka.usecase.genero.creargenero.CrearGeneroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerGenero {

    private final CrearGeneroUseCase crearGeneroUseCase;
    private final ActualizarGeneroUseCase actualizarGeneroUseCase;

    public Mono<ServerResponse> crearGeneroPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Genero.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearGeneroUseCase.crearGenero(e), Genero.class));
    }

    public Mono<ServerResponse> actualizarGeneroPUTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Genero.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(actualizarGeneroUseCase.actualizarGenero(e), Genero.class));
    }

}
