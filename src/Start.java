import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import graph.Kante;
import graph.Kantenliste;

public class Start {
	
	public static void main(String[] args) {
		
		Dotformat dotformat = null;
		Kantenliste k = null;
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("files/k3_3.txt"));
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
		

		dotformat.kantenlisteToDotformat(k, "k3_3");
	}

}
