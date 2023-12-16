package pe.com.project1.ms.application.port.in;

import pe.com.project1.ms.domain.CreditCard;
import reactor.core.publisher.Flux;

public interface FindByCustomerIdCreditCardUseCase {
	Flux<CreditCard> findByCustomerId(String customerId);
}
