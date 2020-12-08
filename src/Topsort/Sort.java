package Topsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import graph.Adjazenzliste;

public class Sort {
	
	public Sort(){
		
	}
	
	public static void Topsort (Adjazenzliste adj) {
		ArrayList<Integer>[] ali = adj.getAdjazenzliste();
		Queue<Integer> q = new LinkedList<Integer>();
		int[] topsort = new int[ali.length];
	
		//Int-Array, in dem für jeden Knoten die Anzahl der Eingänge (indegrees) gespeichert werden
		int[] indegrees = new int[ali.length];
		
		//Gehe durch das Array von Listen und jeweils durch die entsprechende Liste
		for(int i=0; i<ali.length; i++) {
			for(int j=0; j<ali[i].size(); j++) {
				//Für jeden Knoten u, der an einem Knoten v hängt, zähle die Stelle im Array indegrees um 1 hoch
				indegrees[(ali[i].get(j))-1]++; //-1 damit Stelle 0 in Array
			}
		}
		//System.out.println(Arrays.toString(indegrees));
		
		//Erstes Element ohne indegree in Queue einfügen:
		for (int k=0; k<indegrees.length; k++) {
			if(indegrees[k]==0) {
				//Knoten immer 1 mehr, da kein Knoten 0
				q.add(k+1);
			}
		}
		
		//Jeder Knoten wird genau einmal in das Array Topsort geschrieben (Sortierung).
		for(int l = 0; l<indegrees.length; l++) {
			
			//Wenn Queue leer wird, bevor alle Knoten eingetragen wurden, gibt es einen Zyklus!
			if(q.isEmpty()) {
				System.out.println("Der Graph enthält einen Zyklus und kann nicht topologisch sortiert werden");
			}
			//Array topsort befüllen mit 1. Knoten aus der Queue
			topsort[l] = q.poll(); //Knoten löschen
			
			//Durch die Liste des entsprechenden 1. Knotens aus der Queue gehen
			for(int m : ali[topsort[l]-1]) {
				//System.out.println("Das ist m:" +m);
				indegrees[m-1]--; //Alle Kanten, mit denen der gelöschte Knoten verbunden war, werden aus der Liste gelöscht
				if(indegrees[m-1]==0) { //Wenn ein Knoten den Wert 0 bekommt, keine weitere Verbindung mehr hat, kommt dieser in die Queue
					//System.out.println(m);
					q.add(m);
					//System.out.println(m + " wurde zu topsort hinzugefügt");
				}
			}
		}
		
		System.out.println(Arrays.toString(topsort));
		
	}
}
