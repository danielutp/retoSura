package co.com.sofka.usecase.pensionado.listapensionados;

import co.com.sofka.model.pensionado.Pensionado;
import co.com.sofka.model.pensionado.gateways.PensionadoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListaPensionadosUseCase {

    private final PensionadoRepository pensionadoRepository;

    public Flux<Pensionado> listaPensionados(){
        return pensionadoRepository.findAll();
    }

}
