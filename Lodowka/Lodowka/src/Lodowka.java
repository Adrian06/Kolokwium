import java.util.Scanner;

public class Lodowka {
		// TODO Auto-generated method stub
		private Kategoria mieso;
		private Kategoria nabial;
		private Kategoria warzywa;
		private Scanner sc;
		
		public Lodowka() {
			mieso = new Kategoria("Mieso");
			nabial = new Kategoria("Nabial");
			warzywa = new Kategoria("Warzywa");
			
			sc = new Scanner(System.in);
			
			init();
		}
		
	private void init() {
		mieso.dodajProdukt(new Produkt("Mieso", 5));
		mieso.dodajProdukt(new Produkt("Mieso", 8));
		mieso.dodajProdukt(new Produkt("Mieso", 14));
		mieso.dodajProdukt(new Produkt("Mieso", 1));
		mieso.dodajProdukt(new Produkt("Mieso", 4));
		
		nabial.dodajProdukt(new Produkt("Ser", 5));
		nabial.dodajProdukt(new Produkt("Jogurt", 20));
		nabial.dodajProdukt(new Produkt("Ser", 4));
		nabial.dodajProdukt(new Produkt("Jajka", 6));
		nabial.dodajProdukt(new Produkt("Mleko", 1));
		
		warzywa.dodajProdukt(new Produkt("Pomidor", 4));
		warzywa.dodajProdukt(new Produkt("Ogórek", 2));
		warzywa.dodajProdukt(new Produkt("Marchewka", 1));
		warzywa.dodajProdukt(new Produkt("Papryka", 5));
		warzywa.dodajProdukt(new Produkt("Szparagi", 3));

		
	}
	
		public void wlacz() {
			Kategoria u;
			while (true) {
				System.out.println("Co chcesz zrobic? Wybierz opcję:");
				System.out.println("\t(1) wyswietlic zawartosc lodowki");
				System.out.println("\t(2) dodac nowy produkt");
				System.out.println("\t(5) zabrac produkt");
				System.out.println("\t(6) zamknac lodowke");
				System.out.println("? ");
				byte o = sc.nextByte(); sc.nextLine();
				switch (o) {
					case 1 :
						u = wybierzKategorie();
						if(u!=null) {
							u.wyswietlProdukty();
						}
						break;
					case 2 :
						u = wybierzKategorie();
						if(u!=null) {
							System.out.print("Podaj nazwe produktu: ");
							String nazwa = sc.nextLine();
							System.out.print("Podaj ilosc produktu: ");
							int ilosc_produktu = sc.nextInt();
							u.dodajProdukt(new Produkt(nazwa, ilosc_produktu));
							u.wyswietlProdukty();
						}
						break;
					case 5 :
						u = wybierzKategorie();
						if(u!=null) {
							u.wyswietlProdukty();
							System.out.print("Który produkt zabrac? ");
							byte nr_produktu = sc.nextByte();
							u.usunProdukt(nr_produktu);
						}
						break;
					case 6 :
						return;
					default :
						System.err.println("Nie rozpoznaje opcji.");
				}
			}
		}
		
		private Kategoria wybierzKategorie() {
			Kategoria u = null;
			System.out.println("Ktora kategorie wyswietlic? Wybierz opcje:");
			System.out.println("\t(1) " + mieso.getNazwa());
			System.out.println("\t(2) " + nabial.getNazwa());
			System.out.println("\t(3) " + warzywa.getNazwa());
			System.out.println("? ");
			byte nr_u = sc.nextByte(); sc.nextLine();
			switch(nr_u) {
				case 1:
					u = mieso;
					break;
				case 2:
					u = nabial;
					break;
				case 3:
					u = warzywa;
					break;
				default :
					System.err.println("Nie ma takiej kategorii!");
			}
			return u;
		}
		public static void main(String[] args) {
			Lodowka p = new Lodowka();
			p.wlacz();
			System.out.println("---KONIEC---");
		}
}
