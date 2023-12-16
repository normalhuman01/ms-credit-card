package pe.com.project1.ms.infraestructure.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreditCardRouter {

	private static final String CREDIT_CARDS = "/credit-cards";
	private static final String BY_CUSTOMER_ID = CREDIT_CARDS + "/customer-id/{customerId}";

	@Bean
	public RouterFunction<ServerResponse> routes(CreditCardHandler creditCardHandler) {
		return route(POST(CREDIT_CARDS).and(accept(APPLICATION_JSON)), creditCardHandler::postCreditCard)
				.andRoute(GET(BY_CUSTOMER_ID).and(accept(APPLICATION_JSON)), creditCardHandler::getAllByCustomerId);
	}

}
