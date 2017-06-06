package dream.simplefactory.pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExportFactory {
	public static ExportApi createExportApi(){
		Properties p = new Properties();
		InputStream in = null;
		
		try{
			in = ExportFactory.class.getResourceAsStream("FactorySettings.properties");
			p.load(in);
		}
		catch(IOException ex){
			System.out.println("Loading Factory Settings Failure!");
			ex.printStackTrace();
		}
		finally{
			if(in !=null){
				try{
					in.close();
				}
				catch(IOException ex){
					System.out.println("Error closing properties stream!");
					ex.printStackTrace();
				}
			}
		}
		
		ExportApi exportApi = null;
		try{
			exportApi = (ExportApi)Class.forName(p.getProperty("ImplClass")).newInstance();
		}
		catch(InstantiationException | IllegalAccessException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		return exportApi;
	}
}
