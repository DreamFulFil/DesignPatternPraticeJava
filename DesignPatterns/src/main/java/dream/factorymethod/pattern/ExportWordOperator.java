package dream.factorymethod.pattern;

public class ExportWordOperator extends ExportOperator{
	@Override
	protected ExportDataApi factoryMethod(){
		return new ExportWordApi();
	}
}
