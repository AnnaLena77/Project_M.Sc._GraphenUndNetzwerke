package graph;

public class Kante {
	private int startknoten;
	private int endknoten;

	public Kante(int startknoten, int endknoten) {
		this.setStartknoten(startknoten);
		this.setEndknoten(endknoten);
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
	
}
