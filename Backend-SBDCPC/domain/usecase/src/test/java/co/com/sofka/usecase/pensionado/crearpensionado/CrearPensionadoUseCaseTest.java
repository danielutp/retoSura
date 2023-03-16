package co.com.sofka.usecase.pensionado.crearpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
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
class CrearPensionadoUseCaseTest {
    @Mock
    PensionadoRepository pensionadoRepository;
    @InjectMocks
    CrearPensionadoUseCase crearPensionadoUseCase;

    @BeforeEach
    public void setUp(){
        pensionadoRepository = mock(PensionadoRepository.class);
        crearPensionadoUseCase = new CrearPensionadoUseCase(pensionadoRepository);
    }

    @Test
    void crearPensionado() {
        Date fecha = new Date(1995, 8,27);
        Pensionado pensionado = new Pensionado("1",1088,"Cedula","daniel","gil",fecha,1953.4,4,"1","2");
        Mono<Pensionado> pensionadoMono = Mono.just(pensionado);

        when(pensionadoRepository.save(Mockito.any(Pensionado.class))).thenReturn(pensionadoMono);

        StepVerifier.create(crearPensionadoUseCase.crearPensionado(pensionado))
                .expectNextMatches(pensionado1 -> pensionado1.getMesesCotizando().equals(4))
                .expectComplete()
                .verify();
    }
}