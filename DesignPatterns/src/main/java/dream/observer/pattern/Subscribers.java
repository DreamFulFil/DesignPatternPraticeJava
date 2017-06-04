package dream.observer.pattern;

public class Subscribers implements Observer{
	
	private String name;
	
	public Subscribers(String name){
		this.name = name;
	}
	
	@Override
	public void update(Subject s){
		System.out.println(name + " recieved newspaper with content "+((Newspaper)s).getContent());
	}
}
