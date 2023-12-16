package pe.com.project1.ms.infraestructure.persistence.mongodb;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.port.out.CreditCardRepository;
import pe.com.project1.ms.domain.CreditCard;
import pe.com.project1.ms.infraestructure.persistence.model.CreditCardDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CreditCardReactiveMongoRepository implements CreditCardRepository {

	private final ICreditCardReactiveMongoRepository creditCardReactiveMongoRepository;

	@Override
	public Mono<CreditCard> save(CreditCard creditCard) {

		return creditCardReactiveMongoRepository.save(new CreditCardDao(creditCard))
				.map(this::mapCreditCardDaoToCreditCard);
	}

	@Override
	public Mono<CreditCard> findByCreditCardNumber(String creditCardNumber) {
		return creditCardReactiveMongoRepository.findByCreditCardNumber(creditCardNumber)
				.map(this::mapCreditCardDaoToCreditCard);
	}

	@Override
	public Flux<CreditCard> findByCustomerId(String customerId) {
		return creditCardReactiveMongoRepository.findByCustomerId(customerId).map(this::mapCreditCardDaoToCreditCard);
	}

	private CreditCard mapCreditCardDaoToCreditCard(CreditCardDao creditCardDao) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardNumber(creditCardDao.getCreditCardNumber());
		creditCard.setName(creditCardDao.getName());
		creditCard.setExpirationDate(creditCardDao.getExpirationDate());
		creditCard.setCustomerId(creditCardDao.getCustomerId());
		creditCard.setCreditLimit(creditCardDao.getCreditLimit());
		creditCard.setBalance(creditCardDao.getBalance());
		return creditCard;
	}

}
