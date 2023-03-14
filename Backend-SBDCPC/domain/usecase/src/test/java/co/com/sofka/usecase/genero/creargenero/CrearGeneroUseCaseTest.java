package co.com.sofka.usecase.genero.creargenero;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
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

class CrearGeneroUseCaseTest {

    @MockBean
    GeneroRepository generoRepository;

    @SpyBean
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
                .expectNextMatches(generoR -> generoR.getGenero().equals("Masculino"))
                .expectComplete()
                .verify();
    }
}