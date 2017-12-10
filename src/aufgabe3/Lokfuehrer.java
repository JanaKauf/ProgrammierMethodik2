package aufgabe3;

import java.util.Random;

public class Lokfuehrer extends Thread{
	private RangierBahnhof bahnhof;
	private Random r = new Random();
	private int einfahrenOderAusfahren;
	private int gleis;
	
	public Lokfuehrer (RangierBahnhof bahnhof) {
		this.bahnhof = bahnhof;
		this.einfahrenOderAusfahren = r.nextInt(2);
		this.gleis = r.nextInt(4);
	}

	@Override
	public void run() {		
		
		switch(einfahrenOderAusfahren) {
			case 0:
				bahnhof.zugEinfahren(bahnhof.new Zug() , gleis);
				break;
			case 1:
				bahnhof.zugAusfahren(gleis);
				break;
			default:
				break;
			}
		
	}
	
	public int getEinfahrenOderAusfahren() {
		return einfahrenOderAusfahren;
	}
	
	public int getGleis() {
		return gleis;
	}
	
	public RangierBahnhof getBahnhof() {
		return bahnhof;
	}

}
