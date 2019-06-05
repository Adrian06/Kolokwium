
public class Produkt implements Comparable {
	private String nazwa;
	private double ilosc;
	
	public Produkt(String n, double i) {
		nazwa = n;
		ilosc = i;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public double getIlosc() {
		return ilosc;
	}
	
	public String toString() {
		return getNazwa() + " ilosc: " + getIlosc(); 
	}
	
	@Override
	public int compareTo(Object p) {
		Produkt u = (Produkt) p;
		return this.getNazwa().compareTo(u.getNazwa());
	}
}
