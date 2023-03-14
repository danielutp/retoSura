package co.com.sofka.usecase.fondoPensional.listafondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class UseCaseListaFondoPensionalUseCase {
    private final FondoPensionalRepository fondoPensionalRepository;

    public Flux<FondoPensional> listaFondoPensional(){
        return fondoPensionalRepository.findAll();
    }
}
