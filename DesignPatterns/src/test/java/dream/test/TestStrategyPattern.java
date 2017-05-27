package dream.test;

import org.junit.Test;
import org.junit.Assert;

import dream.strategy.pattern.CashPaymentStrategy;
import dream.strategy.pattern.CreditCardPaymentStrategy;
import dream.strategy.pattern.PaymentContext;
import dream.strategy.pattern.PaymentStrategy;

public class TestStrategyPattern {
	@Test
	public void testStrategies(){
		//Arrange
		PaymentStrategy cashStrategy = new CashPaymentStrategy();
		PaymentStrategy creditCardStrategy = new CreditCardPaymentStrategy();
		
		//Act
		PaymentContext context1= new PaymentContext(cashStrategy, "Tom", 50.30);
		PaymentContext context2= new PaymentContext(creditCardStrategy, "Jack", 60.75);
		
		context1.payNow();
		context2.payNow();
		
		//Assert
		Assert.assertEquals("Tom", context1.getUserName());
		Assert.assertEquals("Jack", context2.getUserName());
	}
}
