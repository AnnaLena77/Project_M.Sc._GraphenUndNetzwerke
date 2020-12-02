import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import graph.Adjazenzmatrix;
import graph.Kante;
import graph.Kantenliste;

public class Start {
	
	public static void main(String[] args) {
		

		Dotformat dot = null;
		
		Kantenliste k = readFile("k5");
		Adjazenzmatrix adj = kantenlisteToAdjazenzmatrix(k);
		System.out.println(Arrays.deepToString(adj.getAdjazenzmatrix()));
		dot.adjazenzmatrixToDotformat(adj, "k5");
	}
	
	public static Adjazenzmatrix kantenlisteToAdjazenzmatrix(Kantenliste k) {
		Adjazenzmatrix adj = new Adjazenzmatrix(k.getKnotenanzahl());
		for (int i = 0; i < k.size(); i++) {
			
			int startknoten = k.getKanten().get(i).getStartknoten()-1;
			int endknoten = k.getKanten().get(i).getEndknoten()-1;
			adj.getAdjazenzmatrix()[startknoten][endknoten]=1;
			//adj.getAdjazenzmatrix()[endknoten][startknoten]=1; Achtung! Wird für gerichtete Graphen gebraucht!
		}
		return adj;
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
				k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[1])));
				line = reader.readLine();
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return k;
	}

}
