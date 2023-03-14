package co.com.sofka.usecase.fondoPensional.crearfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearFondoPensionalUseCase {
    private final FondoPensionalRepository fondoPensionalRepository;

    public Mono<FondoPensional> crearFondoPensional(FondoPensional fondoPensional){
        return fondoPensionalRepository.save(fondoPensional);
    }
}
