package co.com.sofka.usecase.tipoidentificacion.creartipoidenficicacion;

import co.com.sofka.model.tipoidentificacion.TipoIdentificacion;
import co.com.sofka.model.tipoidentificacion.gateways.TipoIdentificacionRepository;
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
class CrearTipoIdentificacionUseCaseTest {

    @Mock
    TipoIdentificacionRepository tipoIdentificacionRepository;

    @InjectMocks
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