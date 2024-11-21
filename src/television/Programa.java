package television;

public class Programa {

	private int canal;
	private String programa;
	private double rating;

	public Programa(int canal, String programa, double rating) {
		this.canal = canal;
		this.programa = programa;
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

}
