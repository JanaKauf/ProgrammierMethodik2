package aufgabe3;

public class Simulation implements Runnable {

	@Override
	public void run() {
		RangierBahnhof bahnhof = new RangierBahnhof();
		
		while (true) {
			Lokfuehrer lokfuehrer = new Lokfuehrer(bahnhof);
			lokfuehrer.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
