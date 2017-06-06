package dream.simplefactory.pattern;

public class ExportExcel implements ExportApi{
	@Override
	public void export(){
		System.out.println("Output Excel Report!");
	}
}
