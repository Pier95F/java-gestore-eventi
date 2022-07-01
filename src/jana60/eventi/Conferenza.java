package jana60.eventi;

import java.time.LocalDate;

public class Conferenza extends Evento {
	
	// Definisco gli attributi della classe
	private String argomento;
	private String oratore;
	
	// Costruttore
	public Conferenza(String titolo, LocalDate data, int nPostiTotali, String argomento, String oratore) throws Exception {
		super(titolo, data, nPostiTotali);
		this.argomento = argomento;
		this.oratore = oratore;
	}

	// Imposto getter e setter
	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	public String getOratore() {
		return oratore;
	}

	public void setOratore(String oratore) {
		this.oratore = oratore;
	}
	
	// Override per la restituzione della stringa
	@Override
	public String toString () {
		return super.toString() + " - conferenza su: " + argomento + "tenuta da: " + oratore; 
	}

}
