package dream.decorator.pattern;

import java.util.Date;

public abstract class BonusDecorator extends BaseComponent{
	
	//Base Compoment member used to be decorated
	protected BaseComponent c;
	
	//Constructor, sets the instance of base component
	public BonusDecorator(BaseComponent c){
		this.c = c;
	}
	
	//delegate calculation to member instance of baseComponent
	public double calculateBonus(String user, Date begin, Date end){
		return c.calculateBonus(user, begin, end);
	}
}
