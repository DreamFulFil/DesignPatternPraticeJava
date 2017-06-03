package dream.decorator.pattern;

import java.util.HashMap;
import java.util.Map;

public class LocalClassDB {
	
	//private constructor
	private LocalClassDB(){}
	
	public static Map<String, Double> monthlySalesAmount = new HashMap<>();
	static{
		monthlySalesAmount.put("Tom", 15000.0);
		monthlySalesAmount.put("Jack", 35000.0);
		monthlySalesAmount.put("Andrew", 75000.0);
	}
}
