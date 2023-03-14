package co.com.sofka.model.genero.gateways;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.genero.Genero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GeneroRepository {
    Mono<Genero> save(Genero genero);

    Mono<Genero> update(Genero genero);

    Mono<Genero> findById(String id);
}
