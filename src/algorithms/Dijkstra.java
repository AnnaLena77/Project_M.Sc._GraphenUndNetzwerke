package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import graph.Adjazenzliste;
import graph.Adjazenzmatrix;

public class Dijkstra {
	
	int[][] adjm;
	int numberOfNodes;
	Set<Integer> menge;
	List<Vertex> allNodes;
	PriorityQueue<Vertex> pq;
	
	public void dijkstraalgorithmus(Adjazenzmatrix a, int start) {
		
		adjm = a.getAdjazenzmatrix();
		numberOfNodes = adjm.length;
		
		allNodes = new ArrayList<Vertex>();
		for(int i = 0; i<numberOfNodes; i++) {
			allNodes.add(new Vertex());
			allNodes.get(i).setNode(i+1);
		}
		
		Vertex startvertex = allNodes.get(start-1);
		
		//Implementierung eines Hash-Sets, um die Menge der Knoten, die abgearbeitet wurden, darzustellen
		menge = new LinkedHashSet<Integer>();
		//System.out.println(Arrays.deepToString(adjm));
		
		 pq = new PriorityQueue<Vertex>(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex v1, Vertex v2) {
				return v1.getDist()-v2.getDist();
			}
		});
		
		//Startvertex in Priority Queue
		startvertex.setDist(0);
		pq.add(startvertex);
		
		while(menge.size()<numberOfNodes) {
			Vertex ver = pq.remove();
			menge.add(ver.getNode());
			nachbarknoten(ver);
		}
		System.out.println(menge);
		
	}
	
	public void nachbarknoten(Vertex ver) {
		int distAlt=0;
		int distNeu=0;
		
		for(int i=0; i<numberOfNodes; i++) {
			if((adjm[ver.getNode()-1][i])!=0){
				Vertex v = allNodes.get(i);
				
				if(!menge.contains(v.getNode())) {
					distAlt = v.getDist();
					distNeu = ver.getDist()+ adjm[ver.getNode()-1][i];
				
					if(distNeu<distAlt) {
						v.setDist(distNeu);
					}
					if(!pq.contains(v)) {
						pq.add(v);
					} else {
						System.out.println(v.getNode()+" Schon drin");
						for(Vertex vi : pq) {
							System.out.println("Knoten: " + vi.getNode()+ " mit Dist " + vi.getDist());
						}
					}
				}
			}
		}
	}

}
