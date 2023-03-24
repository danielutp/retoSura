package co.com.sofka.usecase.pensionado.verificarpensionado;

import co.com.sofka.model.common.ex.BusinessException;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class VerificarPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;

    public Mono<Boolean> verificarPensionado(Integer identificacion){
        return pensionadoRepository.findByIdentificacion(identificacion)
                .switchIfEmpty(Mono.error(new BusinessException(BusinessException.Type.USUARIO_NO_EXISTE))).thenReturn(true);
    }
}
