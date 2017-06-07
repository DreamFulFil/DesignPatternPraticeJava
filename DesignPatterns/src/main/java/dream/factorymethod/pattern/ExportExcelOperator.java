package dream.factorymethod.pattern;

public class ExportExcelOperator extends ExportOperator{
	@Override
	protected ExportDataApi factoryMethod(){
		return new ExportExcelApi();
	}
}
