package co.com.sofka.usecase.pensionado.actualizacionfondopensional;

import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import co.com.sofka.usecase.pensionado.crearpensionado.CrearPensionadoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

class ActualizacionFondoPensionalUseCaseTest {

    @Mock
    PensionadoRepository pensionadoRepository;
    @InjectMocks
    ActualizacionFondoPensionalUseCase actualizacionFondoPensionalUseCase;
    @InjectMocks
    CrearPensionadoUseCase crearPensionadoUseCase;

    @BeforeEach
    public void setUp(){
        pensionadoRepository = mock(PensionadoRepository.class);
        actualizacionFondoPensionalUseCase = new ActualizacionFondoPensionalUseCase(pensionadoRepository);
    }

    @Test
    void actualizacionFondoPensional() {
//        Date fecha = new Date(1995, 8, 27);
//        Pensionado pensionado = new Pensionado("1", 1088, "Cedula", "daniel", "gil", fecha, 1953.4, 4, "1", 2);
//
//        Mockito.when(pensionadoRepository.save(pensionado)).thenReturn(Mono.just(pensionado));
//        StepVerifier.create(crearPensionadoUseCase.crearPensionado(pensionado)).verifyComplete();
//
//        StepVerifier.create(actualizacionFondoPensionalUseCase.actualizacionFondoPensional(1088,1))
//               .expectNextMatches(idFondo -> idFondo.getFondoPensional().equals(1))
//               .verifyComplete();
        }
}