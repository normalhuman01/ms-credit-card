package pe.com.project1.ms.application.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.port.in.CreateCreditCardUseCase;
import pe.com.project1.ms.application.port.in.FindByCustomerIdCreditCardUseCase;
import pe.com.project1.ms.application.port.out.CreditCardRepository;
import pe.com.project1.ms.domain.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardService implements CreateCreditCardUseCase, FindByCustomerIdCreditCardUseCase {

	private final CreditCardRepository creditCardRepository;

	@Override
	public Mono<CreditCard> createCreditCard(CreditCard creditCard) {
		return creditCardRepository.save(creditCard);
	}

	@Override
	public Flux<CreditCard> findByCustomerId(String customerId) {
		return creditCardRepository.findByCustomerId(customerId);
	}

}
