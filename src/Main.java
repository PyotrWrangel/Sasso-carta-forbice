import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String mosse[] = { "sasso", "carta", "forbice" };

		Random rand = new Random();

		Scanner sc = new Scanner(System.in);
		
		int punteggioUmano = 0;
		int punteggioAvversario = 0;
	

		System.out.println("Benvenuto in sasso carta forbice! scegli la tua mossa!");

		try {
			while (true) {
			
				System.out.println("1 SASSO 2 CARTA 3 FORBICE");
				int mano = sc.nextInt();
				sc.nextLine();

				int mossaComputer = rand.nextInt(3);
				String mossaComputerStr = mosse[mossaComputer];
				String mossaUmano = mosse[mano - 1];

				System.out.println("La tua mossa: " + mossaUmano);
				System.out.println("Mossa dell'avversario: " + mossaComputerStr);
				
				//logica mosse
				
				switch (mossaUmano) {
				case "sasso":
					switch (mosse[mossaComputer]) {
					case "sasso":
						System.out.println("Pareggio");
						break;
					case "carta":
						System.out.println("Hai perso! la carta avvolge il sasso!");
						punteggioAvversario++;
						break;
					case "forbice":
						System.out.println("Hai vinto! il sasso rompe le forbici!");
						punteggioUmano++;
						break;
					}
					break;
				case "carta":
					switch (mosse[mossaComputer]) {
					case "sasso":
						System.out.println("Hai vinto! la carta avvolge il sasso");
						punteggioUmano++;
						break;
					case "carta":
						System.out.println("Pareggio!");
						break;
					case "forbice":
						System.out.println("Hai perso! le forbici tagliano la carta");
						punteggioAvversario++;
					}
					break;
				case "forbice":
					switch (mosse[mossaComputer]) {
					case "sasso":
						System.out.println("Hai perso! il sasso rompe le forbici");
						punteggioAvversario++;
						break;
					case "carta":
						System.out.println("Hai vinto! le forbici tagliano la carta");
						punteggioUmano++;
						break;
					case "forbice":
						System.out.println("Pareggio!");
						break;
					}
				}

				System.out.println("Punteggio : UMANO " + punteggioUmano + " AVVERSARIO " + punteggioAvversario);
				
				if (punteggioUmano >= 3) {
					System.out.println("Hai vinto!");
				} else if (punteggioAvversario >= 3) {
					System.out.println("Hai perso!");
				} else {
					continue;
				}
				System.out.println("Vuoi continuare a giocare? si/no");
				String risposta = sc.nextLine().toLowerCase();
				if (risposta.equals("si")) {
					punteggioUmano = 0;
					punteggioAvversario = 0;
					continue;
				} else if (risposta.equals("no")) {
					System.out.println("Alla prossima!");
					break;
				} else {
					System.out.println("Inserisci si o no");
				}
			}
		} catch (Exception e) {
			System.err.println("Errore imprevisto");
		}
		sc.close();
	}
}
