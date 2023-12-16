package pe.com.project1.ms.infraestructure.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.project1.ms.domain.CreditCard;

@Document("creditCards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDao {
	private String creditCardNumber;
	private String name;
	private LocalDate expirationDate;
	private String customerId;
	private BigDecimal creditLimit;
	private BigDecimal balance;

	public CreditCardDao(CreditCard creditCard) {
		creditCardNumber = creditCard.getCreditCardNumber();
		name = creditCard.getName();
		expirationDate = creditCard.getExpirationDate();
		customerId = creditCard.getCustomerId();
		creditLimit = creditCard.getCreditLimit();
		balance = creditCard.getCreditLimit();
	}
}
