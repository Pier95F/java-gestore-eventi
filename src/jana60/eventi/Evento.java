package jana60.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

/* La consegna � di creare una classe  Evento  che abbia  le seguenti propriet�: 
 	-   titolo 
 	-   data 
 	-   numero di posti totali (cio� la capienza della location) 
 	-   numero di posti prenotati 
 	
   Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel 
   costruttore  , tranne posti prenotati   che va inizializzato a 0. 
   
   Inserire il controllo che la data non sia gi� passata e che il numero di posti totali sia un 
   numero positivo. In caso contrario sollevare opportune eccezioni. 
   
   Aggiungere metodi  getter  e  setter  in modo che: 
 	-   titolo sia in lettura e in scrittura 
 	-   data sia in lettura e scrittura 
 	-   numero di posti totali sia solo in lettura 
 	-   numero di posti prenotati sia solo in lettura.
 	
   Vanno inoltre implementati dei  metodi public  che svolgono  le seguenti funzioni: 
 	1.   prenota  : aggiunge uno ai posti prenotati. Se l�evento � gi� passato o non ha pi� 
 		 posti disponibili deve sollevare un�eccezione. 
 	2.   disdici  : riduce di uno i posti prenotati. Se l�evento  � gi� passato o non ci sono 
 		 prenotazioni deve sollevare un�eccezione. 
 	3.   l�override  del metodo  toString()  in modo che venga  restituita una stringa 
 		 contenente: data formattata - titolo.  */
	
	// Determino gli attributi della classe
	private String titolo;
	private LocalDate data;
	private int nPostiTotali, nPostiPrenotati;
	
	// Costruttore con relative eccezioni
	public Evento(String titolo, LocalDate data, int nPostiTotali, int nPostiPrenotati) throws Exception{
		
		// Controllo dei posti totali
		if (nPostiTotali >0) {
			this.nPostiTotali = nPostiTotali;
		} else {
			throw new Exception("Errore: il numero dei posti totali deve essere maggiore di 0.");
		}
		// Controllo della data
		if (data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Errore: inserire una data valida.");
		}
		
		this.titolo = titolo;
		this.nPostiPrenotati = 0;
	}

	// Imposto i getter e i setter 

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getnPostiTotali() {
		return nPostiTotali;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}
	
	// Implementazione dei metodi
	public void prenota() throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("Errore: non � possibile prenotare eventi passati.");
		} else if (nPostiTotali == nPostiPrenotati) {
			throw new Exception("L'evento � gi� al completo, non ci sono posti disponibili.");
		} else 
			nPostiPrenotati ++;
	}
	
	public void disdici() throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("Errore: non � possibile disdire eventi passati.");
		} else if (nPostiPrenotati <1) {
			throw new Exception("Non ci sono prenotazioni effettuate.");
		} else
			nPostiPrenotati --;
	}
	
	//Ovverride per la restituzione della stringa
	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(df);
		return this.titolo + " - " + dataFormattata;
	}
	
	
}
