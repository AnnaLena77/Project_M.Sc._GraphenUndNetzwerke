package graph;

import java.util.ArrayList;

public class Kantenliste {
	
	private int knotenanzahl;
	private ArrayList<Kante> kanten;
	
	public Kantenliste(int knotenanzahl) {
		this.knotenanzahl = knotenanzahl;
		this.setKanten(new ArrayList<Kante>());
	}
	
	public void addKante(Kante k) {
		getKanten().add(k);
	}
	
	public void printListe() {
		for(int i=0; i<this.getKanten().size(); i++) {
			System.out.println(this.getKanten().get(i).getStartknoten());
			System.out.println(this.getKanten().get(i).getEndknoten());
		}
	}

	public int size() {
		return this.getKanten().size();
	}

	public ArrayList<Kante> getKanten() {
		return kanten;
	}

	public void setKanten(ArrayList<Kante> kanten) {
		this.kanten = kanten;
	
	}

}
