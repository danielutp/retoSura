package co.com.sofka.usecase.pensionado.buscarpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.Date;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarPensionadoUseCaseTest {
    @Mock
    PensionadoRepository pensionadoRepository;
    @InjectMocks
    BuscarPensionadoUseCase buscarPensionadoUseCase;

    @BeforeEach
    public void setUp(){
        pensionadoRepository = mock(PensionadoRepository.class);
        buscarPensionadoUseCase = new BuscarPensionadoUseCase(pensionadoRepository);
    }

    @Test
    void buscarPensionado() {
        Date fecha = new Date(1995, 8,27);
        Pensionado pensionado = new Pensionado("1",1058788348,"Cedula","daniel","gil",fecha,1953.4,4,"1","2");

        when(pensionadoRepository.findByIdentificacion(1058788348).thenReturn(pensionado));

        StepVerifier.create(buscarPensionadoUseCase.buscarPensionado(1058788348))
                .expectNext(pensionado)
                .expectComplete()
                .verify();
    }
}