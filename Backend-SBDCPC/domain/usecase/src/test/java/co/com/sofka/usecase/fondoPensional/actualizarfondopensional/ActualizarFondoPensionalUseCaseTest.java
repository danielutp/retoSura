package co.com.sofka.usecase.fondoPensional.actualizarfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import co.com.sofka.usecase.fondoPensional.crearfondopensional.CrearFondoPensionalUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ActualizarFondoPensionalUseCaseTest {

    @Mock
    FondoPensionalRepository fondoPensionalRepository;
    @InjectMocks
    ActualizarFondoPensionalUseCase actualizarFondoPensionalUseCase;
    @InjectMocks
    CrearFondoPensionalUseCase crearFondoPensionalUseCase;

    @BeforeEach
    public void setUp(){
        fondoPensionalRepository = mock(FondoPensionalRepository.class);
        actualizarFondoPensionalUseCase = new ActualizarFondoPensionalUseCase(fondoPensionalRepository);
    }

    @Test
    void actualizarFondoPensional() {
        FondoPensional fondoPensional = new FondoPensional("1","Porvenir");
        FondoPensional fondoPensionalActualizar = new FondoPensional("1","Estado");

        StepVerifier.create(crearFondoPensionalUseCase.crearFondoPensional(fondoPensional));
        Mockito.when(fondoPensionalRepository.update(fondoPensional)).thenReturn(Mono.just(fondoPensionalActualizar));

        StepVerifier.create(actualizarFondoPensionalUseCase.actualizarFondoPensional(fondoPensional))
                .expectNextMatches(idFondo -> idFondo.getNombreFondo().equals("Estado"))
                .verifyComplete();
    }
}