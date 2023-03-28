package co.com.sofka.usecase.pensionado.verificarpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.mockito.Mockito.when;

class VerificarPensionadoUseCaseTest {

    @Test
    void verificarPensionado() {
        Boolean prueba;
        Date fecha = new Date(1995, 8, 27);
        Pensionado pensionado = new Pensionado("1", 1088, "Cedula", "daniel", "gil", fecha, 1953.4, 4, "1", 2);
        Mono<Pensionado> pensionadoMono = Mono.just(pensionado);

//        when(pensionadoRepository.findAll()).thenReturn(Mono.just(prueba));
//
//        StepVerifier.create(listaPensionadosUseCase.listaPensionados())
//                .expectNextMatches(idPensionado-> idPensionado.getId().equals("1"))
//                .expectComplete()
//                .verify();
//    }
    }
}