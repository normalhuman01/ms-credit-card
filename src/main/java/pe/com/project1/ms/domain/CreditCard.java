package pe.com.project1.ms.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	private String creditCardNumber;
	private String name;
	private LocalDate expirationDate;
	private String customerId;
	private BigDecimal creditLimit;
	private BigDecimal balance;
}
