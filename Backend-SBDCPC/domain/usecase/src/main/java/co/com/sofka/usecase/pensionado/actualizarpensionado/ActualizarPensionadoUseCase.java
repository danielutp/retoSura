package co.com.sofka.usecase.pensionado.actualizarpensionado;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RequiredArgsConstructor
public class ActualizarPensionadoUseCase {
    private final PensionadoRepository pensionadoRepository;
    public Mono<Pensionado> actualizarPensionado(String id, Pensionado pensionado){
        System.out.println("Caso");
        return pensionadoRepository.findById(id)
                .switchIfEmpty( Mono.error(new NullPointerException("El usuario no existe")))
                .flatMap(e-> pensionadoRepository.save(pensionado));
    }
}
