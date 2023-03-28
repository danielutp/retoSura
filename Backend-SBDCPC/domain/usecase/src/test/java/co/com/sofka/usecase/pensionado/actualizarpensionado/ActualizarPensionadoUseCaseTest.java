package co.com.sofka.usecase.pensionado.actualizarpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import co.com.sofka.usecase.pensionado.crearpensionado.CrearPensionadoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ActualizarPensionadoUseCaseTest {

    @InjectMocks
    ActualizarPensionadoUseCase actualizarPensionadoUseCase;
    @InjectMocks
    CrearPensionadoUseCase crearPensionadoUseCase;
    @Mock
    PensionadoRepository pensionadoRepository;

    @BeforeEach
    public void setUp(){
        pensionadoRepository = mock(PensionadoRepository.class);
        actualizarPensionadoUseCase = new ActualizarPensionadoUseCase(pensionadoRepository);
    }

    @Test
    void actualizarPensionado() {
//        Date fecha = new Date(1995, 8,27);
//        Pensionado pensionado = new Pensionado("1",1088,"Cedula","daniel","gil",fecha,1953.4,4,"1",2);
//
//        Date fecha1 = new Date(1995, 8,27);
//        Pensionado pensionadoActualizar = new Pensionado("1",1083,"Cedula","daniel","gil",fecha1,1953.4,4,"1",2);
//
//        when(pensionadoRepository.save(Mockito.any(Pensionado.class))).thenReturn(Mono.just(pensionado));
//
//        StepVerifier.create(actualizarPensionadoUseCase.actualizarPensionado(pensionadoActualizar.getId(), pensionadoActualizar))
//                .expectNextMatches(pensionado1 -> pensionado1.getIdentificacion().equals(1083))
//                .expectComplete()
//                .verify();
    }
}