package co.com.sofka.usecase.fondoPensional.buscarfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BuscarFondoPensionalUseCase {
    private final FondoPensionalRepository fondoPensionalRepository;

    public Mono<FondoPensional> buscarFondoPensional(String id){
        return fondoPensionalRepository.findById(id);
    }
}
