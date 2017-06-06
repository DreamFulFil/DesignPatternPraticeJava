package dream.test;

import dream.simplefactory.pattern.ExportApi;
import dream.simplefactory.pattern.ExportExcel;
import dream.simplefactory.pattern.ExportFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestSimpleFactory {
	@Test
	public void TestExportApi(){
		//Arrange
		ExportApi api = ExportFactory.createExportApi();
		
	    //Act
		api.export();
		Class<?> apiClass = api.getClass();
		
		//Assert
		Assert.assertEquals(ExportExcel.class, apiClass);
	}   
}
