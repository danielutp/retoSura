package co.com.sofka.usecase.pensionado.actualizacionfondopensional;

import co.com.sofka.model.common.ex.BusinessException;
import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizacionFondoPensionalUseCase {

    private final PensionadoRepository pensionadoRepository;
    public Mono<Pensionado> actualizacionFondoPensional(Integer identificacion,Integer fondo){
        return pensionadoRepository.findByIdentificacion(identificacion)
                .switchIfEmpty(Mono.error(new BusinessException(BusinessException.Type.USUARIO_NO_EXISTE)))
                .flatMap(e-> {
                    e.setFondoPensional(fondo);
                    return pensionadoRepository.save(e);
                });
    }
}