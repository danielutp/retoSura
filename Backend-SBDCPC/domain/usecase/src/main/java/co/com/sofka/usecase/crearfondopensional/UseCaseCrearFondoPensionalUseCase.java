package co.com.sofka.usecase.crearfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UseCaseCrearFondoPensionalUseCase {
    private final FondoPensionalRepository fondoPensionalRepository;

    public Mono<FondoPensional> crearFondoPensional(FondoPensional fondoPensional){
        System.out.println(fondoPensional);
        return fondoPensionalRepository.save(fondoPensional);
    }
}
