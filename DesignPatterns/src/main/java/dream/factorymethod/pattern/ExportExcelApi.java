package dream.factorymethod.pattern;

public class ExportExcelApi implements ExportDataApi{
	@Override
	public boolean export(String data){
		System.out.println("Exporting excel file...Contents:"+data);
		return true;
	}
}
