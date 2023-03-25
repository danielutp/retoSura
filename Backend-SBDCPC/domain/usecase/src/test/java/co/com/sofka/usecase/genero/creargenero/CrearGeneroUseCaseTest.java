package co.com.sofka.usecase.genero.creargenero;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearGeneroUseCaseTest {

    @Mock
    GeneroRepository generoRepository;

    @InjectMocks
    CrearGeneroUseCase crearGeneroUseCase;

    @BeforeEach
    public void setUp(){
        generoRepository = mock(GeneroRepository.class);
        crearGeneroUseCase = new CrearGeneroUseCase(generoRepository);
    }

    @Test
    void crearGenero() {
        Genero genero = new Genero("1","Masculino");
        Mono<Genero> generoMono = Mono.just(genero);

        when(generoRepository.save(Mockito.any(Genero.class))).thenReturn(generoMono);

        StepVerifier.create(crearGeneroUseCase.crearGenero(genero))
                .expectNextMatches(generoR -> generoR.getNombreGenero().equals("Masculino"))
                .expectComplete()
                .verify();
    }
}