import java.util.Arrays;

public class Playlista {
	String nazwa;
	Utwor[] lista_utworow;
	int ile_utworow;
	
	public Playlista(String n) {
		nazwa = n;
		lista_utworow = new Utwor [10];
		ile_utworow = 0;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void dodajUtwor(Utwor u) {
		if(u == null){
			System.err.println(nazwa + ": Nie można dodać utworu o pustej nazwie");
			return;
		}
		if (ile_utworow >= lista_utworow.length) {
			System.err.println(nazwa + ": Nie mozna dodac wiecej utworow");
			return;
		}
		lista_utworow[ile_utworow++] = u;
	}
	
	public void wyswietlUtwory() {
		if(ile_utworow == 0) {
			System.out.println(nazwa + ": Brak utworow na liscie");
			return;
		}
		System.out.println(nazwa + " - lista utworow:");
		
		for(int i = 0; i < ile_utworow; i++) {
			System.out.println(i+1 + ". " + lista_utworow[i].toString());
		}
	}
	
	public Utwor utwor(int nr_utworu) {
		if (nr_utworu < 0 || nr_utworu > ile_utworow) {
			System.err.println(nazwa + ": Nie ma takiego utworu na liscie");
			return null;
		}
		return lista_utworow[nr_utworu-1];
	}
	
	public Utwor usunUtwor(int nr_utworu) {
		if (nr_utworu < 0 || nr_utworu > ile_utworow) {
			System.err.println(nazwa + ": Nie ma takiego utworu na liscie");
			return null;
		}
		Utwor utwor = lista_utworow[nr_utworu-1];
		lista_utworow[nr_utworu-1] = null;
		ile_utworow--;
		for(int i = nr_utworu-1; i < ile_utworow; i++) {
			lista_utworow[i] = lista_utworow[i+1];
		}
		return utwor;
	}
	
	public void posortujUtwory() {
		Arrays.sort(lista_utworow, 0, ile_utworow);
	}
}
