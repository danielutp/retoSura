package co.com.sofka.usecase.fondoPensional.actualizarfondopensional;

import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
import co.com.sofka.usecase.fondoPensional.crearfondopensional.CrearFondoPensionalUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarFondoPensionalUseCaseTest {

    @MockBean
    FondoPensionalRepository fondoPensionalRepository;

    @SpyBean
    ActualizarFondoPensionalUseCase actualizarFondoPensionalUseCase;

    @BeforeEach
    public void setUp(){
        fondoPensionalRepository = mock(FondoPensionalRepository.class);
        actualizarFondoPensionalUseCase = new ActualizarFondoPensionalUseCase(fondoPensionalRepository);
    }

    @Test
    void actualizarFondoPensional() {
        FondoPensional fondoPensional = new FondoPensional("1","Porvenir");

        FondoPensional fondoPensionalActualizar = new FondoPensional("1","Estado");

        Mono<FondoPensional> fondoPensionalMono = Mono.just(fondoPensional);

        when(fondoPensionalRepository.save(Mockito.any(FondoPensional.class))).thenReturn(fondoPensionalMono);

        when(fondoPensionalRepository.update(Mockito.any(FondoPensional.class))).thenReturn(Mono.just(fondoPensionalActualizar));

        StepVerifier.create(actualizarFondoPensionalUseCase.actualizarFondoPensional(fondoPensionalActualizar))
                .expectNextMatches(idFondo -> idFondo.getNombreFondo().equals(fondoPensionalActualizar.getNombreFondo()))
                .verifyComplete();
    }
}