package aufgabe3;

import java.util.Observable;


public class RangierBahnhof extends Observable{
	
	private final int GLEIS_ANZAHL = 4;
	private Zug[] gleise;
	
	
	public RangierBahnhof() {
		gleise = new Zug[GLEIS_ANZAHL];
	}
	
	
	public synchronized void zugEinfahren(Zug zug, int gleisNummer ) {
		if(gleise[gleisNummer] == null) {
			gleise[gleisNummer] = zug;
			setChanged();
			notifyObservers();
		} else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("Lokfuehrer mit Zug " + zug.hashCode() + " fahrt in Gleis " + gleisNummer + " ein. \n");
		System.out.println(this.toString());
		
	}
	
	public synchronized Zug zugAusfahren(int gleisNummer) {
		if(gleise[gleisNummer] != null) {
			Zug ausgefahreneZug = gleise[gleisNummer];
			gleise[gleisNummer] = null;
			setChanged();
			notifyObservers();
			System.out.println("Lokfuehrer mit Zug " + ausgefahreneZug.hashCode() + " fahrt in Gleis " + gleisNummer + " aus. \n");
			System.out.println(this.toString());
			return ausgefahreneZug;
		} else {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		return null;
		
	}
	
	public Zug[] getGleise() {
		return gleise;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" _________________________BAHNHOF___________________________\n");
		for (int i = 0; i < GLEIS_ANZAHL; i++) {
			if (gleise[i] == null) {
				sb.append("|-----------------------------------------------------------|\n");
			} else {
				sb.append("|[XXXXXXX][XXXXXX][XXXXXXXXXX][XXXXXX][XXXXXXXX][" + gleise[i].hashCode() + "]|\n");
			}
		}
		sb.append("|___________________________________________________________|\n");
		return sb.toString();
	}
	
	public final class Zug{
		
	}

}