package algorithms;

public class Vertex {
	
	private int node;
	private int dist;
	
	public Vertex(){
		this.dist = Integer.MAX_VALUE;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}
}
