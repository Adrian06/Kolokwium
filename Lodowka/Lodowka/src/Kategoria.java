import java.util.Arrays;

public class Kategoria {
	String nazwa;
	Produkt[] lista_produktow;
	int ile_produktow;
	
	public Kategoria(String n) {
		nazwa = n;
		lista_produktow = new Produkt [5];
		ile_produktow = 0;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void dodajProdukt(Produkt u) {
		if(u == null){
			System.err.println(nazwa + ": Nie można dodać produktu bez nazwy");
			return;
		}
		if (ile_produktow >= lista_produktow.length) {
			System.err.println(nazwa + ": Nie mozna dodac wiecej produktow");
			return;
		}
		lista_produktow[ile_produktow++] = u;
	}
	
	public void wyswietlProdukty() {
		if(ile_produktow == 0) {
			System.out.println(nazwa + ": Brak produktow w lodowce");
			return;
		}
		System.out.println(nazwa + " - lista produktow:");
		
		for(int i = 0; i < ile_produktow; i++) {
			System.out.println(i+1 + ". " + lista_produktow[i].toString());
		}
	}
	
	public Produkt produkt(int nr_produktu) {
		if (nr_produktu < 0 || nr_produktu > ile_produktow) {
			System.err.println(nazwa + ": Nie ma takiego produktu w lodowce");
			return null;
		}
		return lista_produktow[nr_produktu-1];
	}
	
	public Produkt usunProdukt(int nr_produktu) {
		if (nr_produktu < 0 || nr_produktu > ile_produktow) {
			System.err.println(nazwa + ": Nie ma takiego produktu w lodowce");
			return null;
		}
		Produkt produkt = lista_produktow[nr_produktu-1];
		lista_produktow[nr_produktu-1] = null;
		ile_produktow--;
		for(int i = nr_produktu-1; i < ile_produktow; i++) {
			lista_produktow[i] = lista_produktow[i+1];
		}
		return produkt;
	}
}
