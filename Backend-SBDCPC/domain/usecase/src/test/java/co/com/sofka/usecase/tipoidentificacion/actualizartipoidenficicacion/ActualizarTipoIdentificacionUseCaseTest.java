package co.com.sofka.usecase.tipoidentificacion.actualizartipoidenficicacion;


import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
import co.com.sofka.usecase.tipoidentificacion.creartipoidenficicacion.CrearTipoIdentificacionUseCase;
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
class ActualizarTipoIdentificacionUseCaseTest {

    @Mock
    TipoIdentificacionRepository tipoIdentificacionRepository;
    @InjectMocks
    ActualizarTipoIdentificacionUseCase actualizarTipoIdentificacionUseCase;
    @InjectMocks
    CrearTipoIdentificacionUseCase crearTipoIdentificacionUseCase;

    @BeforeEach
    public void setUp(){
        tipoIdentificacionRepository = mock(TipoIdentificacionRepository.class);
        actualizarTipoIdentificacionUseCase = new ActualizarTipoIdentificacionUseCase(tipoIdentificacionRepository);
    }

    @Test
    void actualizarTipoIdentificacion() {
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion("1","Cedula");
        TipoIdentificacion tipoIdentificacionActualizar = new TipoIdentificacion("1","Tarjeta");

        StepVerifier.create(crearTipoIdentificacionUseCase.crearTipoIdentificacion(tipoIdentificacion));
        when(tipoIdentificacionRepository.update(Mockito.any(TipoIdentificacion.class))).thenReturn(Mono.just(tipoIdentificacionActualizar));

        StepVerifier.create(actualizarTipoIdentificacionUseCase.actualizarTipoIdentificacion(tipoIdentificacionActualizar))
                .expectNextMatches(tipoIdentificacionP -> tipoIdentificacionP.getIdentificacion().equals(tipoIdentificacionActualizar.getIdentificacion()))
                .verifyComplete();
    }
}