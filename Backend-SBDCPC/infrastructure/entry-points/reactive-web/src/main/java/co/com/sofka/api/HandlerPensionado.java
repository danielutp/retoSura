package co.com.sofka.api;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.usecase.pensionado.actualizarpensionado.ActualizarPensionadoUseCase;
import co.com.sofka.usecase.pensionado.buscarpensionado.BuscarPensionadoUseCase;
import co.com.sofka.usecase.pensionado.crearpensionado.CrearPensionadoUseCase;
import co.com.sofka.usecase.pensionado.listapensionados.ListaPensionadosUseCase;
import co.com.sofka.usecase.pensionado.verificarpensionado.VerificarPensionadoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerPensionado {

    private final CrearPensionadoUseCase crearPensionadoUseCase;
    private final ActualizarPensionadoUseCase actualizarPensionadoUseCase;
    private final ListaPensionadosUseCase listaPensionadosUseCase;
    private final BuscarPensionadoUseCase buscarPensionadoUseCase;
    private final VerificarPensionadoUseCase verificarPensionadoUseCase;

    public Mono<ServerResponse> crearPensionadoPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Pensionado.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearPensionadoUseCase.crearPensionado(e), Pensionado.class));
    }
    public Mono<ServerResponse> actualizarPensionadoPUTUseCase(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Pensionado.class)
                .flatMap(e-> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(actualizarPensionadoUseCase.actualizarPensionado(id,e), Pensionado.class));
    }

    public Mono<ServerResponse> listaPensionadosGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(listaPensionadosUseCase.listaPensionados(), Pensionado.class);
    }

    public Mono<ServerResponse> buscarPensionadoGETUseCase(ServerRequest serverRequest) {
        Integer identificacion = Integer.valueOf(serverRequest.pathVariable("identificacion"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(buscarPensionadoUseCase.buscarPensionado(identificacion), Pensionado.class);
    }

    public Mono<ServerResponse> verificarPensionadoGETUseCase(ServerRequest serverRequest) {
        Integer identificacion = Integer.valueOf(serverRequest.pathVariable("identificacion"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(verificarPensionadoUseCase.verificarPensionado(identificacion), Boolean.class);
    }


}
