package graph;

import java.util.ArrayList;

public class Adjazenzliste {
	
	private ArrayList<Integer>[] adjazenzliste;
	
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
}
