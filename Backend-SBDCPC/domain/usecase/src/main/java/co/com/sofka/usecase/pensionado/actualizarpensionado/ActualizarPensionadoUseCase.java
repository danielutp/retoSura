package co.com.sofka.usecase.pensionado.actualizarpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;
    public Mono<Pensionado> actualizarPensionado(String id, Pensionado pensionado){
        return pensionadoRepository.findById(id)
                .flatMap(e-> pensionadoRepository.save(pensionado));
    }
}
