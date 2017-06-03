package dream.decorator.pattern;

import java.util.Date;

public class MonthlyBonusDecorator extends BonusDecorator {

	public MonthlyBonusDecorator(BaseComponent c){ super(c);}
	
	@Override
	public double calculateBonus(String user, Date begin, Date end){
		double originalBonus = super.calculateBonus(user, begin, end);		
		double monthlyBonus = LocalClassDB.monthlySalesAmount.get(user) * 0.03;
		System.out.println("¤ë¼úª÷¡G"+ Double.toString(monthlyBonus));
		return originalBonus + monthlyBonus;
	}
}
