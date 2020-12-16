package graph;

public class Kante {
	private int startknoten;
	private int endknoten;
	private int weight;

	public Kante(int startknoten, int endknoten) {
		this.setStartknoten(startknoten);
		this.setEndknoten(endknoten);
	}
	
	public Kante(int startknoten, int endknoten, int weight) {
		this.setStartknoten(startknoten);
		this.setEndknoten(endknoten);
		this.setWeight(weight);
	}

	public int getStartknoten() {
		return startknoten;
	}

	public void setStartknoten(int startknoten) {
		this.startknoten = startknoten;
	}

	public int getEndknoten() {
		return endknoten;
	}

	public void setEndknoten(int endknoten) {
		this.endknoten = endknoten;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void printKante() {
		System.out.println(this.startknoten + " " + this.endknoten + " " + this.weight);
	}
	
}
