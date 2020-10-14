package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<ObserverIF> observers;
	private int eventNumber;
	
	public Subject() {
		this.observers = new ArrayList<ObserverIF>();
		this.eventNumber = 1;
		
	}
	
	public void addObserver(ObserverIF observer) {
		this.observers.add(observer);
	}
	
	
	public void doEvent() {
		for(ObserverIF observer : this.observers)
			observer.fire("Event " + this.eventNumber + "\n");
		this.eventNumber++;
	}
	
	
	
	
	

}
