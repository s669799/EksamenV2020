package no.hvl.dat102.oppgave4;

public class KjedetUordnetListe<T extends Comparable<T>> implements UordnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste;

	public KjedetUordnetListe() {
		antall = 0;
		foerste = null;
	}

//... get- og set-metoder kan du anta
//... Andre metoder
	public String toString() {
		return toString(foerste);
	}

	private String toString(LinearNode<T> p) {
		// ...Fyll ut
		if (p == null) {
			return "";
		} else {
			return p.getElement() + "\n" + toString(p.getNeste());
		}
	}

	public void settInn(T el) {
		LinearNode<T> ny = new LinearNode(el);

		ny.setNeste(foerste);
		foerste = ny;
		antall++;
	}

	public void flyttFoersteTilSiste() {
		if (antall > 1) {
			LinearNode<T> flyttes = foerste;

			foerste = foerste.getNeste();
			LinearNode<T> denne = foerste;

			while (denne.getNeste() != null) {
				denne = denne.getNeste();
			}
			denne.setNeste(flyttes);
		}
	}

	public T finnNesteMinste() {
		LinearNode<T> minst = foerste;
		LinearNode<T> nestMinst = foerste;
		LinearNode<T> denne = foerste;

		while (denne.getNeste() != null) {
			if (denne.getElement().compareTo(minst.getElement()) < 0) {
				minst = denne;
				nestMinst = minst;
			} else if (denne.getElement().compareTo(nestMinst.getElement()) < 0) {
				nestMinst = denne;
			} 
			denne = denne.getNeste();

		}
		return nestMinst.getElement();
	}
}
