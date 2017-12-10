package aufgabe3;

public class Main {

	public static void main(String[] args) {
		Simulation simulation = new Simulation();

		Thread t = new Thread(simulation);
		
		t.start();
	}

}
