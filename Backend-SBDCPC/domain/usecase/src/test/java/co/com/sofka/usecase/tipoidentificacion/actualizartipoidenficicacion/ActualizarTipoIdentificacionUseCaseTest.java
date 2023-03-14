package co.com.sofka.usecase.tipoidentificacion.actualizartipoidenficicacion;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
import co.com.sofka.usecase.genero.actualizargenero.ActualizarGeneroUseCase;
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

class ActualizarTipoIdentificacionUseCaseTest {

    @MockBean
    TipoIdentificacionRepository tipoIdentificacionRepository;

    @SpyBean
    ActualizarTipoIdentificacionUseCase actualizarTipoIdentificacionUseCase;

    @BeforeEach
    public void setUp(){
        tipoIdentificacionRepository = mock(TipoIdentificacionRepository.class);
        actualizarTipoIdentificacionUseCase = new ActualizarTipoIdentificacionUseCase(tipoIdentificacionRepository);
    }

    @Test
    void actualizarTipoIdentificacion() {
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion("1","Cedula");

        TipoIdentificacion tipoIdentificacionActualizar = new TipoIdentificacion("1","Tarjeta");

        Mono<TipoIdentificacion> tipoIdentificacionMono = Mono.just(tipoIdentificacion);

        when(tipoIdentificacionRepository.save(Mockito.any(TipoIdentificacion.class))).thenReturn(tipoIdentificacionMono);

        when(tipoIdentificacionRepository.update(Mockito.any(TipoIdentificacion.class))).thenReturn(Mono.just(tipoIdentificacionActualizar));

        StepVerifier.create(actualizarTipoIdentificacionUseCase.actualizarTipoIdentificacion(tipoIdentificacionActualizar))
                .expectNextMatches(tipoIdentificacionP -> tipoIdentificacionP.getIdentificacion().equals(tipoIdentificacionActualizar.getIdentificacion()))
                .verifyComplete();
    }
}