package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerFondoPensional handlerFondoPensional,HandlerGenero handlerGenero, HandlerTipoIdenficacion handlerTipoIdenficacion,HandlerPensionado handlerPensionado) {
    return route(POST("/api/crearFondoPensional"), handlerFondoPensional::crearFondoPensionalPOSTUseCase).andRoute
            (POST("/api/actualizarFondoPensional"), handlerFondoPensional::actualizarFondoPensionalPOSTUseCase).andRoute
            (POST("/api/crearGenero"), handlerGenero::crearGeneroPOSTUseCase).andRoute
            (POST("/api/actualizarGenero"), handlerGenero::actualizarGeneroPOSTUseCase).andRoute
            (POST("/api/crearTipoIdentificacion"), handlerTipoIdenficacion::crearTipoIdentificacionPOSTUseCase).andRoute
            (POST("/api/actualizarTipoIdentificacion"), handlerTipoIdenficacion::actualizarTipoIdentificacionPOSTUseCase).andRoute
            (POST("/api/crearPensionado"), handlerPensionado::crearPensionadoPOSTUseCase).andRoute
            (PUT("/api/actualizarPensionado/{id}"), handlerPensionado::actualizarPensionadoPUTUseCase).andRoute
            (GET("/api/listaPensionado"), handlerPensionado::listaPensionadosGETUseCase).andRoute
            (GET("/api/buscarPensionado/{identificacion}"), handlerPensionado::buscarPensionadoGETUseCase);
    }
}
