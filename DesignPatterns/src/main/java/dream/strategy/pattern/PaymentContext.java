package dream.strategy.pattern;

public class PaymentContext {
	private String userName = null;
	private double money = 0.0;
	private PaymentStrategy strategy;
	
	public PaymentContext(PaymentStrategy strategy, String userName, double money){
		this.strategy = strategy;
		this.userName = userName;
		this.money = money;
	}
	
	public String getUserName(){return userName;}
	public double getMoney(){return money;}
	
	public void payNow(){
		this.strategy.pay(this);
	}
}
