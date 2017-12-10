package aufgabe3;

import java.util.Observable;
import java.util.Observer;

public class Visualisierung implements Observer{

	public final RangierBahnhof bahnhof;
	
	public Visualisierung(RangierBahnhof bahnhof) {
		this.bahnhof = bahnhof;
		bahnhof.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		bahnhof.toString();
	}
	
	
}
