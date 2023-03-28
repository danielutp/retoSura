package co.com.sofka.model.genero.gateways;

import co.com.sofka.model.genero.Genero;
import reactor.core.publisher.Mono;

public interface GeneroRepository {
    Mono<Genero> save(Genero genero);

    Mono<Genero> update(Genero genero);
}
