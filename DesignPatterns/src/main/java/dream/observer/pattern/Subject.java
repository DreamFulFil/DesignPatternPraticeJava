package dream.observer.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subject {
	private List<Observer> subscribers = new ArrayList<>();
	
	public int getNumberOfSubscribers(){
		return subscribers.size();
	}
	
	public void subscribe(Observer o){
		this.subscribers.add(o);
	}
	
	public void unsubscribe(Observer o){
		this.subscribers.remove(o);
	}
	
	protected void notifyObservers(){
		Iterator<Observer> it = subscribers.iterator();
		while(it.hasNext()){
			Observer subscriber = it.next();
			subscriber.update(this);
		}
	}
}
