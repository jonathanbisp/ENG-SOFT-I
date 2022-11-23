

public class Biblioteca {
	
	private Biblioteca() {};
	
	private static Biblioteca instance;
	
	public static Biblioteca getInstance() {
		if (instance == null) {
			instance = new Biblioteca();
		}
		return instance;
	}

}
