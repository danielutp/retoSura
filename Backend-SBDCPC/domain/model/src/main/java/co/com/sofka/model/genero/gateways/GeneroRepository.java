package co.com.sofka.model.genero.gateways;

import co.com.sofka.model.genero.Genero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GeneroRepository {
    Mono<Genero> save(Genero genero);

    Flux<Genero> findAll();

    Mono<Void> deleteById(String id);

    Mono<Genero> findById(String id);
}
