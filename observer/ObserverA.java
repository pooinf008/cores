package observer;

public class ObserverA implements ObserverIF{
	
	
	public void ocorreuEvento(String s) {
		System.out.println("Observer A :" + s);
	}

	@Override
	public void fire(String string) {
		this.ocorreuEvento(string);
		
	}
	

}
