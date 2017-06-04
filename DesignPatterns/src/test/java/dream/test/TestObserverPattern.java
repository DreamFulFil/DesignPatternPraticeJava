package dream.test;

import org.junit.Test;
import org.junit.Assert;

import dream.observer.pattern.Newspaper;
import dream.observer.pattern.Observer;
import dream.observer.pattern.Subscribers;

public class TestObserverPattern {
	@Test
	public void TestSubscribe(){
		//Arrange
		Newspaper news = new Newspaper();
		Observer reader1 = new Subscribers("Tom");
		Observer reader2 = new Subscribers("Jack");
		
		news.subscribe(reader1);
		news.subscribe(reader2);
		//Act
		news.setContent("OH MY GOD!!!");
		
		//Assert
		Assert.assertEquals(2, news.getNumberOfSubscribers());
	}
}
