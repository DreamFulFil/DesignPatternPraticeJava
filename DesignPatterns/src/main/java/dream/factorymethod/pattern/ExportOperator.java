package dream.factorymethod.pattern;

public abstract class ExportOperator {
	protected abstract ExportDataApi factoryMethod();
	
	public void doSomeExportOperation(String data){
		ExportDataApi dataExporter = factoryMethod();
		dataExporter.export(data);
	}
}
