import java.util.Scanner;

public class ZarzadzaniePlaylistami {
		// TODO Auto-generated method stub
		private Playlista pop;
		private Playlista rock;
		private Scanner sc;
		
		public ZarzadzaniePlaylistami() {
			pop = new Playlista("Pop");
			rock = new Playlista("Rock");
			
			sc = new Scanner(System.in);
			
			init();
		}
		
	private void init() {
		pop.dodajUtwor(new Utwor("Toxic", "Britney Spears", 2003));
		pop.dodajUtwor(new Utwor("Shake It Off", "Taylor Swift", 2014));
		pop.dodajUtwor(new Utwor("Barbie Girl", "Aqua", 1997));
		pop.dodajUtwor(new Utwor("Every Night", "Madonna", 2005));
		pop.dodajUtwor(new Utwor("Baby", "Justin Bieber", 2010));
		pop.dodajUtwor(new Utwor("Like a Virgin", "Madonna", 1984));
		pop.dodajUtwor(new Utwor("Waka Waka", "Shakira", 2010));
		pop.dodajUtwor(new Utwor("Take on Me", "AHA", 1985));
		
		rock.dodajUtwor(new Utwor("Highway to Hell", "ACDC", 1979));
		rock.dodajUtwor(new Utwor("Smells Like a Teen Spirit", "Nirvana", 1991));
		rock.dodajUtwor(new Utwor("Piece of My Heart", " Jenice Joplin", 1967));
		rock.dodajUtwor(new Utwor("Nothing Else Matters", "Metallica", 1991));
		rock.dodajUtwor(new Utwor("Keine Lust", "Rammstein", 2004));
		rock.dodajUtwor(new Utwor("TNT", "ACDC", 1975));
		rock.dodajUtwor(new Utwor("Bohemian Rhapsody", "Queen", 1975));
	}
	
		public void wlacz() {
			Playlista p;
			while (true) {
				System.out.println("Co chcesz zrobic? Wybierz opcję:");
				System.out.println("\t(1) wyswietlic playliste");
				System.out.println("\t(2) dodac nowy utwor");
				System.out.println("\t(3) przeniesc utwor");
				System.out.println("\t(4) skopiowac utwor");
				System.out.println("\t(5) skasowac utwor");
				System.out.println("\t(6) wylaczyc odtwarzacz");
				System.out.println("? ");
				byte o = sc.nextByte(); sc.nextLine();
				switch (o) {
					case 1 :
						p = wybierzPlayliste();
						if(p!=null) {
							p.wyswietlUtwory();
						}
						break;
					case 2 :
						p = wybierzPlayliste();
						if(p!=null) {
							System.out.print("Podaj tytul utworu: ");
							String tytul = sc.nextLine();
							System.out.print("Podaj wykonawce utworu: ");
							String wykonawca = sc.nextLine();
							System.out.print("Podaj rok wydania utworu: ");
							int rok_wydania = sc.nextInt();
							p.dodajUtwor(new Utwor(tytul, wykonawca, rok_wydania));
							p.wyswietlUtwory();
						}
						break;
					case 3 :
						p = wybierzPlayliste();
						if(p!=null) {
							p.wyswietlUtwory();
							System.out.print("Który utwór przeniesc do drugiej playlisty? ");
							byte nr_utworu = sc.nextByte();
							Utwor u = p.usunUtwor(nr_utworu);
							if(u!=null) {
								Playlista p_do = p.equals(pop) ? rock : pop;
								p_do.dodajUtwor(u);
							}
						}
						break;
					case 4 :
						p = wybierzPlayliste();
						if(p!=null) {
							p.wyswietlUtwory();
							System.out.print("Który utwór skopiowac do drugiej playlisty? ");
							byte nr_utworu = sc.nextByte();
							Utwor u = p.utwor(nr_utworu);
							if(u!=null) {
								Playlista p_do = p.equals(pop) ? rock : pop;
								p_do.dodajUtwor(u);
							}
						}
						break;
					case 5 :
						p = wybierzPlayliste();
						if(p!=null) {
							p.wyswietlUtwory();
							System.out.print("Który utwór skasować? ");
							byte nr_utworu = sc.nextByte();
							p.usunUtwor(nr_utworu);
						}
						break;
					case 6 :
						return;
					default :
						System.err.println("Nie rozpoznaje opcji.");
				}
			}
		}
		
		private Playlista wybierzPlayliste() {
			Playlista p = null;
			System.out.println("Ktorej playlisty uzyc? Wybierz opcje:");
			System.out.println("\t(1) " + pop.getNazwa());
			System.out.println("\t(2) " + rock.getNazwa());
			System.out.println("? ");
			byte nr_p = sc.nextByte(); sc.nextLine();
			switch(nr_p) {
				case 1:
					p = pop;
					break;
				case 2:
					p = rock;
					break;
				default :
					System.err.println("Nie ma takiej playlisty!");
			}
			return p;
		}
		public static void main(String[] args) {
			ZarzadzaniePlaylistami o = new ZarzadzaniePlaylistami();
			o.wlacz();
			System.out.println("---KONIEC---");
		}
}
