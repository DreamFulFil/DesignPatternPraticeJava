package dream.decorator.pattern;

import java.util.Date;

public abstract class BaseComponent {
	public abstract double calculateBonus(String user, Date begin, Date end);
}
