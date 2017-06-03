package dream.test;

import java.util.Date;

import org.junit.Test;
import org.junit.Assert;

import dream.decorator.pattern.BaseComponent;
import dream.decorator.pattern.BonusDecorator;
import dream.decorator.pattern.DefaultBonusComponent;
import dream.decorator.pattern.MonthlyBonusDecorator;
import dream.decorator.pattern.TeamBonusDecorator;

public class TestDecoratorPattern {

	@Test
	public void TestBonusDecorator(){
		//Arrange
		BaseComponent c = new DefaultBonusComponent();
		
		BonusDecorator bd1 = new MonthlyBonusDecorator(c);
		BonusDecorator bd2 = new TeamBonusDecorator(bd1);
		
		//Act
		double finalBonus = bd2.calculateBonus("Tom", new Date(), new Date());
		
		//Assert
		Assert.assertEquals(575d, finalBonus, 0.01d);
	}
	
}
