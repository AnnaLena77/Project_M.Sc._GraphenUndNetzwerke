import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import graph.Kantenliste;

public class Dotformat {

	public static void kantenlisteToDotformat(Kantenliste k, String name) {
		try {
			File myObj = new File("filesDot/" + name + ".dot");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("filesDot/" + name + ".dot"));
			myWriter.write("graph{");
			myWriter.newLine();
			for (int i = 0; i < k.size(); i++) {
				myWriter.write(Integer.toString(k.getKanten().get(i).getStartknoten()));
				myWriter.write(" -- ");
				myWriter.write(Integer.toString(k.getKanten().get(i).getEndknoten()));
				myWriter.newLine();
			}
			myWriter.write("}");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
