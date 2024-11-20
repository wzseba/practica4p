package television;

public class Programa {

	private String programa;
	private int numCanal;
	private double rating;

	public Programa(int numCanal, String programa, double rating) {
		this.numCanal = numCanal;
		this.programa = programa;
		this.rating = rating;
	}

	public void setCanal(int canal) {
		this.numCanal = canal;
	}

	public int getCanal() {
		return numCanal;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getPrograma() {
		return programa;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
