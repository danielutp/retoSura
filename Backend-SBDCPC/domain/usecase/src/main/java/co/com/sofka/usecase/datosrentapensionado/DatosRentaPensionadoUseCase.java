package co.com.sofka.usecase.datosrentapensionado;

import co.com.sofka.model.common.ex.BusinessException;
import co.com.sofka.model.pensionado.Renta;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DatosRentaPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;
    public Mono<Renta> obtenerRenta(Integer identificacion){
        return pensionadoRepository.findByIdentificacion(identificacion)
                .switchIfEmpty(Mono.error(new BusinessException(BusinessException.Type.USUARIO_NO_EXISTE)))
                .map(e->  new Renta(e.getSalario(),e.getMesesCotizando()));
    }
}
