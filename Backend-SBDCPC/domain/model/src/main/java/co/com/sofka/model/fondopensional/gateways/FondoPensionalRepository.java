package co.com.sofka.model.fondopensional.gateways;

import co.com.sofka.model.fondopensional.FondoPensional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FondoPensionalRepository {

    Mono<FondoPensional> save(FondoPensional fondoPensional);

    Flux<FondoPensional> findAll();

    Mono<Void> deleteById(String id);

    Mono<FondoPensional> findById(String id);

}
