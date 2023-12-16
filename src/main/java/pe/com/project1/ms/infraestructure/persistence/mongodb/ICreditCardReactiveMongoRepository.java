package pe.com.project1.ms.infraestructure.persistence.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.project1.ms.infraestructure.persistence.model.CreditCardDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditCardReactiveMongoRepository extends ReactiveMongoRepository<CreditCardDao, String> {

	Mono<CreditCardDao> findByCreditCardNumber(String creditCardNumber);

	Flux<CreditCardDao> findByCustomerId(String customerId);

}
