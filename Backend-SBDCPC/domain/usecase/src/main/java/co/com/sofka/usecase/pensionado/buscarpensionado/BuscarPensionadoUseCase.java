package co.com.sofka.usecase.pensionado.buscarpensionado;

import co.com.sofka.model.common.ex.BusinessException;
import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BuscarPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;

    public Mono<Pensionado> buscarPensionado(Integer identificacion){
        return pensionadoRepository.findByIdentificacion(identificacion)
                .flatMap(e-> Mono.error(new BusinessException(BusinessException.Type.USUARIO_NO_EXISTE)));
    }
}