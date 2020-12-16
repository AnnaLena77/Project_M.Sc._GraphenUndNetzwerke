package algorithms;
import java.util.*;

import graph.Kante;
import graph.Kantenliste;


public class Kruskal {
	
	public static void Kruskalalgorithmus(Kantenliste k) {
		int knotenanzahl = k.getKnotenanzahl();
		ArrayList<Kante> klist = k.getKanten();
		
		//Kantenliste nach weight sortieren
		Collections.sort(klist, Comparator.comparingInt(e -> e.getWeight()));
		
		for(Kante kan:klist) {
			kan.printKante();
		}
		
		//Liste des minimalen Spanning trees
		List<Kante> mst = new ArrayList();
		
		Teilmenge tlm = new Teilmenge();
		tlm.makeset(knotenanzahl);
		
		int index = 0;
		
		while(mst.size()!= knotenanzahl-1) {
			Kante nextk = klist.get(index++);
			
			int startknoten = tlm.find(nextk.getStartknoten());
			int endknoten = tlm.find(nextk.getEndknoten());
			
			if(startknoten!=endknoten) {
				mst.add(nextk);
				tlm.union(startknoten, endknoten);
			}
			else {
				System.out.println("Zyklus! " + nextk.getStartknoten() + " " + nextk.getEndknoten());
			}
		}
		for(Kante kante: mst) {
			kante.printKante();
		}
	}

}
