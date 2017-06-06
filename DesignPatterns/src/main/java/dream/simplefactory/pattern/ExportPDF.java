package dream.simplefactory.pattern;

public class ExportPDF implements ExportApi{
	@Override
	public void export(){
		System.out.println("Export PDF report!");
	}
}
