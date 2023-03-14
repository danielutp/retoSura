package co.com.sofka.api;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.usecase.fondoPensional.actualizarfondopensional.ActualizarFondoPensionalUseCase;
import co.com.sofka.usecase.fondoPensional.crearfondopensional.CrearFondoPensionalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerFondoPensional {
 private final CrearFondoPensionalUseCase crearFondoPensionalUseCase;
 private final ActualizarFondoPensionalUseCase actualizarFondoPensionalUseCase;

    public Mono<ServerResponse> crearFondoPensionalPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(FondoPensional.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearFondoPensionalUseCase.crearFondoPensional(e), FondoPensional.class));
    }

    public Mono<ServerResponse> actualizarFondoPensionalPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(FondoPensional.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(actualizarFondoPensionalUseCase.actualizarFondoPensional(e), FondoPensional.class));
    }


}
