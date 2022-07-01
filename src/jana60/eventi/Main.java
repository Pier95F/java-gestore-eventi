package jana60.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
/*  1.   Creare una classe  Main  di test, in cui si chiede all’utente  di inserire un nuovo evento 
 		 con tutti i parametri. 
 	2.   Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni 
 		 vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo 
 		 eventuali eccezioni. 
 	3.   Stampare a video il numero di posti prenotati e quelli disponibili 
 	4.   Chiedere all’utente se e quanti posti vuole disdire 
 	5.   Provare ad effettuare le disdette, implementando opportuni controlli e gestendo 
 		 eventuali eccezioni 
 	6.   Stampare a video il numero di posti prenotati e quelli disponibili. */

		// Importo lo scanner per richiedere i dati all'utente
		Scanner scan = new Scanner (System.in);
		
		/* Chiedo all'utente di inserire i dati dell'evento:
		 	- Nome dell'evento: */
		System.out.println("Inserisci il nome dell'evento: ");
		String titolo = scan.nextLine();
		
		//	- Numero di posti totali
		System.out.println("Inserisci il numero di posti totali: ");
		int nPostiTotali = scan.nextInt();
		
		// 	- Data dell'evento
		System.out.println("Inserisci il giorno dell'evento: ");
		int giorno = scan.nextInt();
		System.out.println("Inserisci il mese dell'evento (da 1 a 12): ");
		int mese = scan.nextInt();
		System.out.println("Inserisci l'anno dell'evento: ");
		int anno = scan.nextInt();
		LocalDate data = LocalDate.of(anno, mese, giorno);
		System.out.println("La data dell'evento è: " + data.toString());

		// Inizializzo l'evento 
		try {
				Evento evento = new Evento(titolo, data, nPostiTotali);
				String risposta;
				boolean flag = false;
				System.out.println("Vuoi partecipare all'evento? Si/No");
				scan.nextLine();
				do {
					risposta = scan.nextLine();
					if (risposta.equals("No")) {
						System.out.println("Grazie ed arrivederci.");
						flag = true;
						break;
					}
					System.out.println("Inserisci il numero di prenotazioni che vuoi effettuare: ");
					int nPostiPrenotati = scan.nextInt();
					for (int i = 0; i<nPostiPrenotati; i++) {
						evento.prenota();
					}
					System.out.println("Hai effettuato " + nPostiPrenotati + " prenotazioni per l'evento " + titolo + ", sono disponibili ancora " + evento.nPostiDisponibili() + " posti.");
					
					System.out.println("Vuoi disdire dei biglietti? Si/No");
					scan.nextLine();
					risposta = scan.nextLine();
					if (risposta.equals("No")) {
						System.out.println("Non hai effettuato disdette. I posti disponibili sono ancora " + evento.nPostiDisponibili());
						flag = true;
						break;
					}
					System.out.println("Quanti biglietti vuoi disdire?");
					int nPostiDisdetti = scan.nextInt();		
					for (int i=0; i<nPostiDisdetti; i++) {
						evento.disdici();
					}
					System.out.println("Hai disdetto " +  nPostiDisdetti + " biglietti per l'evento " + titolo + ", sono disponibili ancora " + evento.nPostiDisponibili() + " posti.");
					break; 
				} while (risposta.equals("Si"));
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			} 
		
		
				
	
	 scan.close();
	}
	}


