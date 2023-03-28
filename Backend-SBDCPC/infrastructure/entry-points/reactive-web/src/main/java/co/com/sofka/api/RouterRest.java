package co.com.sofka.api;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
@CrossOrigin(origins = "http://localhost:4200")
@Configuration
public class RouterRest {
    @Bean
    public WebProperties.Resources resources(){
        return new WebProperties.Resources();
    }
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerFondoPensional handlerFondoPensional,HandlerGenero handlerGenero, HandlerTipoIdenficacion handlerTipoIdenficacion,HandlerPensionado handlerPensionado) {
    return route(POST("/api/crearFondoPensional"), handlerFondoPensional::crearFondoPensionalPOSTUseCase).andRoute
            (PUT("/api/actualizarFondoPensional"), handlerFondoPensional::actualizarFondoPensionalPUTUseCase).andRoute
            (POST("/api/crearGenero"), handlerGenero::crearGeneroPOSTUseCase).andRoute
            (PUT("/api/actualizarGenero"), handlerGenero::actualizarGeneroPUTUseCase).andRoute
            (POST("/api/crearTipoIdentificacion"), handlerTipoIdenficacion::crearTipoIdentificacionPOSTUseCase).andRoute
            (PUT("/api/actualizarTipoIdentificacion"), handlerTipoIdenficacion::actualizarTipoIdentificacionPUTUseCase).andRoute
            (POST("/api/crearPensionado"), handlerPensionado::crearPensionadoPOSTUseCase).andRoute
            (PUT("/api/actualizarPensionado/{id}"), handlerPensionado::actualizarPensionadoPUTUseCase).andRoute
            (GET("/api/listaPensionado"), handlerPensionado::listaPensionadosGETUseCase).andRoute
            (GET("/api/buscarPensionado/{identificacion}"), handlerPensionado::buscarPensionadoGETUseCase).andRoute
            (GET("/api/verificarPensionado/{identificacion}"), handlerPensionado::verificarPensionadoGETUseCase).andRoute
            (GET("/api/datosPensionado/{identificacion}"), handlerPensionado::datosRentaPensionadoGETUseCase);
    }
}
