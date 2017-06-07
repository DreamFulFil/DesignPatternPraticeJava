package dream.test;

import org.junit.Assert;
import org.junit.Test;

import dream.factorymethod.pattern.ExportExcelOperator;
import dream.factorymethod.pattern.ExportOperator;

public class TestFactoryMethodPattern {
	@Test
	public void TestExportData(){
		//Arrange
		ExportOperator op = new ExportExcelOperator();
		String data = "Yaaaa boi";
		
		//Act
		op.doSomeExportOperation(data);
		
		//Assert
		Assert.assertEquals(ExportExcelOperator.class, op.getClass());
	}
}
