package dream.strategy.pattern;

public class CashPaymentStrategy implements PaymentStrategy{
	@Override
	public void pay(PaymentContext context){
		System.out.printf("User %s paid by cash!%n", context.getUserName());
	}
}
