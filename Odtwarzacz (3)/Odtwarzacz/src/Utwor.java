
public class Utwor implements Comparable {
	private String tytul;
	private String wykonawca;
	private int rok_wydania;
	
	public Utwor(String t, String w, int r) {
		tytul = t;
		wykonawca = w;
		rok_wydania = r;
	}
	
	public String getTytul() {
		return tytul;
	}
	
	public String getWykonawca() {
		return wykonawca;
	}
	
	public int getRokWydania() {
		return rok_wydania;
	}
	
	public String toString() {
		return getTytul() + " (" + getWykonawca() + ") [" + getRokWydania() + "]"; 
	}
	
	@Override
	public int compareTo(Object o) {
		Utwor u = (Utwor) o;
		return this.getTytul().compareTo(u.getTytul());
	}
}
