package dream.decorator.pattern;

import java.util.Date;

public class DefaultBonusComponent extends BaseComponent{
	@Override
	public double calculateBonus(String user, Date begin, Date end){
		return 0.0d;
	}
}
