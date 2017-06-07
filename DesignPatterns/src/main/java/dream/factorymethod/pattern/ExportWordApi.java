package dream.factorymethod.pattern;

public class ExportWordApi implements ExportDataApi{
	@Override
	public boolean export(String data){
		System.out.println("Exporting word file...Contents:"+data);
		return true;
	}
}
