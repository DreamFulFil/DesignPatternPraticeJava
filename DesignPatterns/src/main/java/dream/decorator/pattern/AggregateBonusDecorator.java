package dream.decorator.pattern;

import java.util.Date;

public class AggregateBonusDecorator extends BonusDecorator{

	public AggregateBonusDecorator(BaseComponent c){super(c);}
	
	@Override
	public double calculateBonus(String user, Date begin, Date end){
		double originalBonus = super.calculateBonus(user, begin, end);
		double aggregateBonus = 5000000 * 0.01;
		System.out.println("²Ö¿n¼úª÷¡G"+ Double.toString(aggregateBonus));
		return originalBonus + aggregateBonus;
	}
}
