package pe.com.project1.ms.infraestructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.service.CreditCardService;
import pe.com.project1.ms.domain.CreditCard;
import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreditCardHandler {

	private final CreditCardService creditCardService;

	public Mono<ServerResponse> postCreditCard(ServerRequest request) {
		return request.bodyToMono(CreditCard.class)
				.map(creditCard -> creditCardService.createCreditCard(creditCard))
				.flatMap(creditCard -> this.toServerResponse(creditCard, HttpStatus.CREATED));
	}

	public Mono<ServerResponse> getAllByCustomerId(ServerRequest request) {
		Flux<CreditCard> creditCards = creditCardService.findByCustomerId(request.pathVariable("customerId"));
		return this.toServerResponse(creditCards, HttpStatus.OK);
	}

	private Mono<ServerResponse> toServerResponse(CorePublisher<CreditCard> creditCard, HttpStatus status) {
		return ServerResponse
				.status(status)
				.contentType(MediaType.APPLICATION_JSON)
				.body(creditCard, CreditCard.class);
	}
	
}
