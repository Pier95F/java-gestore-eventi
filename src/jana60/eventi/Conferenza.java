package jana60.eventi;

import java.time.LocalDate;

public class Conferenza extends Evento {
	
	// Definisco gli attributi della classe
	private String argomento;
	private Oratore oratore;
	
	// Costruttore
	public Conferenza(String titolo, LocalDate data, int nPostiTotali, String argomento, Oratore oratore) throws Exception {
		super(titolo, data, nPostiTotali);
		this.argomento = argomento;
		this.oratore = new Oratore (oratore.getNome(), oratore.getCognome(), oratore.getTitolo());
	}
	
	// Override per la restituzione della stringa
	@Override
	public String toString () {
		return super.toString() + " - conferenza su: " + argomento + "tenuta da: " + oratore; 
	}

}
