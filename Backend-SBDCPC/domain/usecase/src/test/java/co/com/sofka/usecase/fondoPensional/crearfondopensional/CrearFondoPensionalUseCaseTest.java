package co.com.sofka.usecase.fondopensional.crearfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearFondoPensionalUseCaseTest {

    @InjectMocks
    CrearFondoPensionalUseCase crearFondoPensionalUseCase;
    @Mock
    FondoPensionalRepository fondoPensionalRepository;

    @BeforeEach
    public void setUp(){
        fondoPensionalRepository = mock(FondoPensionalRepository.class);
        crearFondoPensionalUseCase = new CrearFondoPensionalUseCase(fondoPensionalRepository);
    }

    @Test
    void crearFondoPensional() {
        FondoPensional fondoPensional = new FondoPensional("1",1,"Porvenir");
        Mono<FondoPensional> fondoPensionalMono = Mono.just(fondoPensional);

        when(fondoPensionalRepository.save(fondoPensional)).thenReturn(fondoPensionalMono);

        StepVerifier.create(crearFondoPensionalUseCase.crearFondoPensional(fondoPensional))
                .expectNextMatches(idFondo -> idFondo.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}