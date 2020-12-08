import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import graph.Adjazenzliste;
import graph.Adjazenzmatrix;
import graph.Kante;
import graph.Kantenliste;

public class Start {
	
	public static void main(String[] args) {
		

		Dotformat dot = null;
		
		Kantenliste k = readFile("bellmannford");
		//Adjazenzmatrix ad = kantenlisteToAdjazenzmatrix(k);
		//dot.adjazenzmatrixToDotformat(ad, "bellmannford");
		//dot.kantenlisteToDotformat(k, "bellmannford");
		Adjazenzliste ali = kantenlisteToAdjazenzliste(k);
		dot.adjazenzlisteToDotformat(ali, "bellmannford");
		
		
	}
	
	public static Adjazenzmatrix kantenlisteToAdjazenzmatrix(Kantenliste k) {
		Adjazenzmatrix adj = new Adjazenzmatrix(k.getKnotenanzahl());
		for (int i = 0; i < k.size(); i++) {
			
			int startknoten = k.getKanten().get(i).getStartknoten()-1;
			int endknoten = k.getKanten().get(i).getEndknoten()-1;
			//ungerichtete Graphen
			if(k.getKanten().get(i).getWeight()==0) {
				adj.setGewichtet(false);
				adj.getAdjazenzmatrix()[startknoten][endknoten]=1;
			//gewichtete Graphen
			} else {
				adj.setGewichtet(true);
				adj.getAdjazenzmatrix()[startknoten][endknoten]= k.getKanten().get(i).getWeight();
			}
		}
		return adj;
	}
	
	public static Adjazenzliste kantenlisteToAdjazenzliste(Kantenliste k) {
		Adjazenzliste ali = new Adjazenzliste(k.getKnotenanzahl());
		if(k.getKanten().get(0).getWeight()==0) {
			ali.setGerichtet(false);
		}
		else {
			ali.setGerichtet(true);
		}
		for (int i = 0; i < k.size(); i++) {
			int startknoten = k.getKanten().get(i).getStartknoten()-1;
			int endknoten = k.getKanten().get(i).getEndknoten();
			ali.getAdjazenzliste()[startknoten].add(endknoten);
		}
		return ali;
	}
	
	public static Kantenliste readFile(String file) {
		Kantenliste k = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("files/"+file+".txt"));
			int knotenanzahl = Integer.parseInt(reader.readLine());
			k = new Kantenliste(knotenanzahl);
			
			String line = reader.readLine();
			
			while(line != null) {
				String[] splitline = line.split(" ");
				//Ungerichteter Graph
				if(splitline.length==2) {
					k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[1])));
				}
				//gewichteter Graph
				else {
					k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[2]), Integer.parseInt(splitline[1])));
				}
				line = reader.readLine();
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return k;
	}

}
