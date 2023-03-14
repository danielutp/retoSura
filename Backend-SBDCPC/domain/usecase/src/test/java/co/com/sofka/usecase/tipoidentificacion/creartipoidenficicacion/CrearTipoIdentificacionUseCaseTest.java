package co.com.sofka.usecase.tipoidentificacion.creartipoidenficicacion;

import co.com.sofka.model.genero.Genero;
import co.com.sofka.model.genero.gateways.GeneroRepository;
import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
import co.com.sofka.usecase.genero.creargenero.CrearGeneroUseCase;
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

class CrearTipoIdentificacionUseCaseTest {

    @MockBean
    TipoIdentificacionRepository tipoIdentificacionRepository;

    @SpyBean
    CrearTipoIdentificacionUseCase crearTipoIdentificacionUseCase;

    @BeforeEach
    public void setUp(){
        tipoIdentificacionRepository = mock(TipoIdentificacionRepository.class);
        crearTipoIdentificacionUseCase = new CrearTipoIdentificacionUseCase(tipoIdentificacionRepository);
    }

    @Test
    void crearTipoIdentificacion() {
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion("1","Cedula");
        Mono<TipoIdentificacion> tipoIdentificacionMono = Mono.just(tipoIdentificacion);

        when(tipoIdentificacionRepository.save(Mockito.any(TipoIdentificacion.class))).thenReturn(tipoIdentificacionMono);

        StepVerifier.create(crearTipoIdentificacionUseCase.crearTipoIdentificacion(tipoIdentificacion))
                .expectNextMatches(tipoIdentificacionP -> tipoIdentificacionP.getIdentificacion().equals("Cedula"))
                .expectComplete()
                .verify();
    }
}