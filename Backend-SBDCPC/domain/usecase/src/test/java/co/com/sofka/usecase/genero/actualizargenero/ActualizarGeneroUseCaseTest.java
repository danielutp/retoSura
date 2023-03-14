package co.com.sofka.usecase.genero.actualizargenero;

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

class ActualizarGeneroUseCaseTest {

    @MockBean
    GeneroRepository generoRepository;

    @SpyBean
    ActualizarGeneroUseCase actualizarGeneroUseCase;

    @BeforeEach
    public void setUp(){
        generoRepository = mock(GeneroRepository.class);
        actualizarGeneroUseCase = new ActualizarGeneroUseCase(generoRepository);
    }

    @Test
    void actualizarGenero() {
        Genero genero = new Genero("1","Masculino");

        Genero generoActualizar = new Genero("1","Femenino");

        Mono<Genero> fondoPensionalMono = Mono.just(genero);

        when(generoRepository.save(Mockito.any(Genero.class))).thenReturn(fondoPensionalMono);

        when(generoRepository.update(Mockito.any(Genero.class))).thenReturn(Mono.just(generoActualizar));

        StepVerifier.create(actualizarGeneroUseCase.actualizarGenero(generoActualizar))
                .expectNextMatches(generoP -> generoP.getGenero().equals(generoActualizar.getGenero()))
                .verifyComplete();
    }
}