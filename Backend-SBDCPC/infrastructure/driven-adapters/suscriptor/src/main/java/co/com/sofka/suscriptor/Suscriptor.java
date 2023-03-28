package co.com.sofka.suscriptor;

import co.com.sofka.model.pensionado.AfiliadoFondo;
import co.com.sofka.usecase.pensionado.actualizacionfondopensional.ActualizacionFondoPensionalUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Log
@Configuration
@EnableCommandListeners
@RequiredArgsConstructor
public class Suscriptor {
    static final String CAUSANTE_PENSIONADO = "causante.pensionado";

    private final ActualizacionFondoPensionalUseCase actualizacionFondoPensionalUseCase;

    @Bean
    public HandlerRegistry comandoSuscriptor(){
        return HandlerRegistry.register().handleCommand(CAUSANTE_PENSIONADO,
        p->{
            AfiliadoFondo afiliadoFondo = p.getData();
            actualizacionFondoPensionalUseCase.actualizacionFondoPensional(afiliadoFondo.getIdentificacion(),afiliadoFondo.getIdfondo()).subscribe();
        return Mono.empty();

        }
        ,AfiliadoFondo.class);
    }

}
