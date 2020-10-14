package observer;

public class AppObserver {
	
	
	public static void main(String[] args) {
		ObserverA observerA = new ObserverA();
		Subject s = new Subject();
		
		s.addObserver(observerA);
		
		for(int i = 0; i < 10; i++) {
			s.doEvent();
		}
		System.out.println(">>>FIM<<<");
	}


}
