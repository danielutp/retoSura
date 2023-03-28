package co.com.sofka.usecase.pensionado.actualizacionfondopensional;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizacionFondoPensionalUseCase {

    private final PensionadoRepository pensionadoRepository;
    public Mono<Pensionado> actualizacionFondoPensional(Integer identificacion,Integer fondo){
        var nuevoFondo =+ fondo;
        return pensionadoRepository.findByIdentificacion(identificacion)
                .flatMap(pensionado-> {
                    pensionado.setFondoPensional(nuevoFondo);
                    return pensionadoRepository.save(pensionado);
                });
    }
}