package co.com.sofka.usecase.genero.creargenero;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearGeneroUseCase {

    private final GeneroRepository generoRepository;

    public Mono<Genero> crearGenero(Genero genero){
        return generoRepository.save(genero);
    }
}
