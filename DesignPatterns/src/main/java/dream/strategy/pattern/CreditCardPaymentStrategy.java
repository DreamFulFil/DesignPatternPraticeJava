package dream.strategy.pattern;

public class CreditCardPaymentStrategy implements PaymentStrategy{
	@Override
	public void pay(PaymentContext context){
		System.out.printf("User %s paid by credit card!%n", context.getUserName());
	}
}
