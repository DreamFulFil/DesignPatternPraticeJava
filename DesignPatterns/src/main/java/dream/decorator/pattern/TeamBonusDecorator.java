package dream.decorator.pattern;

import java.util.Date;

public class TeamBonusDecorator extends BonusDecorator{

	public TeamBonusDecorator(BaseComponent c){super(c);}
	
	@Override
	public double calculateBonus(String user, Date begin, Date end){
		double originalBonus = super.calculateBonus(user, begin, end);
		double teamBonus = 0.0d;
		
		for(Double temp:LocalClassDB.monthlySalesAmount.values()){
			teamBonus += temp.doubleValue();
		}
		
		teamBonus*=0.001;
		System.out.println("¹Î¶¤¼úª÷:"+teamBonus);
		
		return originalBonus + teamBonus;
	}
}
