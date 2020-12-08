package graph;

import java.util.ArrayList;

public class Adjazenzliste {
	
	private ArrayList<Integer>[] adjazenzliste;
	private boolean gerichtet;
	
	public Adjazenzliste(int knotenanzahl) {
		adjazenzliste = new ArrayList[knotenanzahl];
		for(int i=0; i<knotenanzahl; i++) {
			adjazenzliste[i] = new ArrayList<Integer>();
			adjazenzliste[i].add(i+1);
		}
	}
	public ArrayList<Integer>[] getAdjazenzliste(){
		return this.adjazenzliste;
	}
	public boolean isGerichtet() {
		return gerichtet;
	}
	public void setGerichtet(boolean gerichtet) {
		this.gerichtet = gerichtet;
	}
}
