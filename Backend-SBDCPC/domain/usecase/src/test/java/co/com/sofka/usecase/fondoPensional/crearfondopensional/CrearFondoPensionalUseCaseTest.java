package co.com.sofka.usecase.fondoPensional.crearfondopensional;


import co.com.sofka.model.fondopensional.FondoPensional;
import co.com.sofka.model.fondopensional.gateways.FondoPensionalRepository;
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

class CrearFondoPensionalUseCaseTest {

    @MockBean
    FondoPensionalRepository fondoPensionalRepository;

    @SpyBean
    CrearFondoPensionalUseCase crearFondoPensionalUseCase;

    @BeforeEach
    public void setUp(){
        fondoPensionalRepository = mock(FondoPensionalRepository.class);
        crearFondoPensionalUseCase = new CrearFondoPensionalUseCase(fondoPensionalRepository);
    }

    @Test
    void crearFondoPensional() {
        FondoPensional fondoPensional = new FondoPensional("1","Porvenir");
        Mono<FondoPensional> fondoPensionalMono = Mono.just(fondoPensional);

        when(fondoPensionalRepository.save(Mockito.any(FondoPensional.class))).thenReturn(fondoPensionalMono);

        StepVerifier.create(crearFondoPensionalUseCase.crearFondoPensional(fondoPensional))
                .expectNextMatches(idFondo -> idFondo.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}