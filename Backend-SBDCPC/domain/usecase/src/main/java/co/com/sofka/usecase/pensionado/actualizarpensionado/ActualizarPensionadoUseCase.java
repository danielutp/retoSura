package co.com.sofka.usecase.pensionado.actualizarpensionado;

import co.com.sofka.model.common.ex.BusinessException;
import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class  ActualizarPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;
    public Mono<Pensionado> actualizarPensionado( Pensionado pensionado){
        return pensionadoRepository.findByIdentificacion(pensionado.getIdentificacion())
                .switchIfEmpty(Mono.error(new BusinessException(BusinessException.Type.USUARIO_NO_EXISTE)))
                .flatMap(e-> pensionadoRepository.save(pensionado)).thenReturn(pensionado);
    }
}