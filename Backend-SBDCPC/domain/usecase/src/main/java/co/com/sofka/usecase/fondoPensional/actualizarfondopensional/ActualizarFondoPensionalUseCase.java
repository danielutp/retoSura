package co.com.sofka.usecase.fondoPensional.actualizarfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarFondoPensionalUseCase {
    private final FondoPensionalRepository fondoPensionalRepository;

    public Mono<FondoPensional> actualizarFondoPensional(FondoPensional fondoPensional){
        return fondoPensionalRepository.update(fondoPensional);
    }
}
