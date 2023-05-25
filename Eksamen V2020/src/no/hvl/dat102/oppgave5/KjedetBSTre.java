package no.hvl.dat102.oppgave5;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
	private int antall;
	private BinaerTreNode<T> rot;

	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	// ... get- og set metoder kan du anta
	public String toString() {
		return toString(rot);
	}

	private String toString(BinaerTreNode<T> p) {
		// ... Fyll ut
		String string = "";
		if(p != null) {
			toString(p.getVenstre());
			string += p.getElement().toString() + "\n";
			toString(p.getHoyre());
		}
		return string;
	}

	public static <T extends Comparable<T>> boolean verifiserBSTre(BinaerTre<T> detAndre) {
		return verifiserBSTre(detAndre.getRot());
	}

	private static <T extends Comparable<T>> boolean verifiserBSTre(BinaerTreNode<T> p) {
		// ... Fyll ut
		if (p == null) {
			return true;
			}
			if (p.getElement().compareTo(p.getVenstre().getElement()) <= 0) {
			return false;
			}
			if (p.getElement().compareTo(p.getHoyre().getElement()) > 0) {
			return false;
			}
			return verifiserBSTre(p.getVenstre()) &&
			verifiserBSTre(p.getHoyre());
		
	}
	// ... andre metode

}
