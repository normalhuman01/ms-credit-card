package pe.com.project1.ms.application.port.out;

import pe.com.project1.ms.domain.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardRepository {
	Mono<CreditCard> save(CreditCard creditCard);

	Mono<CreditCard> findByCreditCardNumber(String creditCardNumber);

	Flux<CreditCard> findByCustomerId(String customerId);
}
