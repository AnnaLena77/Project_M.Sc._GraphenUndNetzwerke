package graph;

public class Adjazenzmatrix {
	private int[][] adjazenzmatrix;
	private boolean gewichtet;
	
	public Adjazenzmatrix(int knotenanzahl) {
		this.adjazenzmatrix = new int[knotenanzahl][knotenanzahl];
		for(int i=0; i<knotenanzahl-1; i++) {
			for(int j = 0; j<knotenanzahl-1; j++) {
				this.adjazenzmatrix[i][j] = 0;
			}
		}
	}
	
	public int[][] getAdjazenzmatrix() {
		return this.adjazenzmatrix;
	}

	public boolean isGewichtet() {
		return gewichtet;
	}

	public void setGewichtet(boolean gewichtet) {
		this.gewichtet = gewichtet;
	}
}
