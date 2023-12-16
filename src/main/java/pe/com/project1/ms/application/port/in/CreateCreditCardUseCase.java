package pe.com.project1.ms.application.port.in;

import pe.com.project1.ms.domain.CreditCard;
import reactor.core.publisher.Mono;

public interface CreateCreditCardUseCase {
	Mono<CreditCard> createCreditCard(CreditCard creditCard);
}
