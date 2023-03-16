package co.com.sofka.usecase.genero.actualizargenero;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import co.com.sofka.usecase.genero.creargenero.CrearGeneroUseCase;
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
class ActualizarGeneroUseCaseTest {

    @Mock
    GeneroRepository generoRepository;
    @InjectMocks
    ActualizarGeneroUseCase actualizarGeneroUseCase;
    @InjectMocks
    CrearGeneroUseCase crearGeneroUseCase;

    @BeforeEach
    public void setUp(){
        generoRepository = mock(GeneroRepository.class);
        actualizarGeneroUseCase = new ActualizarGeneroUseCase(generoRepository);
    }

    @Test
    void actualizarGenero() {
        Genero genero = new Genero("1","Masculino");
        Genero generoActualizar = new Genero("1","Femenino");

        StepVerifier.create(crearGeneroUseCase.crearGenero(genero));
        when(generoRepository.update(Mockito.any(Genero.class))).thenReturn(Mono.just(generoActualizar));

        StepVerifier.create(actualizarGeneroUseCase.actualizarGenero(generoActualizar))
                .expectNextMatches(generoP -> generoP.getGenero().equals(generoActualizar.getGenero()))
                .verifyComplete();
    }
}