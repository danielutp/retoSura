package co.com.sofka.usecase.pensionado.listapensionados;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListaPensionadosUseCaseTest {
    @Mock
    PensionadoRepository pensionadoRepository;
    @InjectMocks
    ListaPensionadosUseCase listaPensionadosUseCase;

    @BeforeEach
    public void setUp(){
        pensionadoRepository = mock(PensionadoRepository.class);
        listaPensionadosUseCase = new ListaPensionadosUseCase(pensionadoRepository);
    }

    @Test
    void listarPensionados() {
        Date fecha = new Date(1995, 8,27);
        Pensionado pensionado = new Pensionado("1",1088,"Cedula","daniel","gil",fecha,1953.4,4,"1",2);
        Mono<Pensionado> pensionadoMono = Mono.just(pensionado);

        when(pensionadoRepository.findAll()).thenReturn(Flux.just(pensionado));

        StepVerifier.create(listaPensionadosUseCase.listaPensionados())
                .expectNextMatches(idPensionado-> idPensionado.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}