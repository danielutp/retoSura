package co.com.sofka.usecase.pensionado.crearpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearPensionadoUseCase {

    private final PensionadoRepository pensionadoRepository;

    public Mono<Pensionado> crearPensionado(Pensionado pensionado){
        return pensionadoRepository.save(pensionado);
    }
}
