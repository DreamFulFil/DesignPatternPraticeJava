package dream.test;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import dream.template.pattern.JDBCTemplate;
import dream.template.pattern.UserDataModel;
import dream.template.pattern.UserJDBC;

public class TestTemplateMethodPattern {
	@Test
	public void testCreate(){
		//Arrange
		JDBCTemplate<UserDataModel> userJDBC = new UserJDBC();
		UserDataModel udm = new UserDataModel();
		udm.setAge(30);
		udm.setName("Tom");
		udm.setUuid("A001");
		
		//Act
		int rows = userJDBC.create(udm);
		
		//Assert
		Assert.assertEquals(1, rows);
	}
	
	@Test
	public void testUpdate(){
		//Arrange
		JDBCTemplate<UserDataModel> userJDBC = new UserJDBC();
		UserDataModel udm = new UserDataModel();
		udm.setAge(50);
		udm.setName("Jack");
		udm.setUuid("A001");
		
		//Act
		int rows = userJDBC.create(udm);
		
		//Assert
		Assert.assertEquals(1, rows);
	}
	
	@Test
	public void testSelect(){
		//Arrange
		JDBCTemplate<UserDataModel> userJDBC = new UserJDBC();
		UserDataModel udm = new UserDataModel();
		udm.setUuid("A001");
		
		//Act
		Collection<UserDataModel> result = userJDBC.findByCondition(udm);
		
		//Assert
		Assert.assertEquals("Tom", ((ArrayList<UserDataModel>)result).get(0).getName());
	}
}
