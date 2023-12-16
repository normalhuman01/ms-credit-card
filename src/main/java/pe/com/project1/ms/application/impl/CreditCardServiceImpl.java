package pe.com.project1.ms.application.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.CreditCardService;
import pe.com.project1.ms.application.port.out.CreditCardRepository;
import pe.com.project1.ms.domain.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

	private final CreditCardRepository creditCardRepository;

	@Override
	public Mono<CreditCard> save(CreditCard creditCard) {

		return null;
	}

	@Override
	public Mono<CreditCard> findByCreditCardNumber(String creditCardNumber) {

		return null;
	}

	@Override
	public Flux<CreditCard> findByCustomerId(String customerId) {
		return null;
	}

}
