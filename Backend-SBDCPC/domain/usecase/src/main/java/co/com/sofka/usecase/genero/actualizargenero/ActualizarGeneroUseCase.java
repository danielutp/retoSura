package co.com.sofka.usecase.genero.actualizargenero;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarGeneroUseCase {

    private final GeneroRepository generoRepository;

    public Mono<Genero> actualizarGenero(Genero genero){
        return generoRepository.update(genero);
    }
}
