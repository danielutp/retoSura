package co.com.sofka.usecase.pensionado.crearpensionado;

import co.com.sofka.model.common.ex.BusinessException;
import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;
    public Mono<Pensionado> crearPensionado(Pensionado pensionado){
        return pensionadoRepository.findByIdentificacion(pensionado.getIdentificacion())
                .flatMap(e-> Mono.error(new BusinessException(BusinessException.Type.ID_DUPLICADO)))
                        .switchIfEmpty(pensionadoRepository.save(pensionado)).thenReturn(pensionado);
    }
}