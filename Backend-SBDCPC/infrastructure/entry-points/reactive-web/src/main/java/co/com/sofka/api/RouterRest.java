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
public RouterFunction<ServerResponse> routerFunction(HandlerFondoPensional handlerFondoPensional) {
    return route(POST("/api/crearFondoPensional"), handlerFondoPensional::crearFondoPensionalPOSTUseCase).andRoute
            (GET("/api/listaFondoPensiones"), handlerFondoPensional::listaFondoPensionalGETUseCase).andRoute
            (GET("/api/fondoPensional/{id}"), handlerFondoPensional::buscarFondoPensionalGETUseCase).andRoute
            (POST("/api/actualizarfondopensional"), handlerFondoPensional::crearFondoPensionalPOSTUseCase);

    }
}
