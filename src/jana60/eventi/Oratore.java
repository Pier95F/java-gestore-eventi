package jana60.eventi;

public class Oratore {
	// Definisco gli attributi della classe
	private String nome, cognome, titolo;

	// Costruttore
	public Oratore(String nome, String cognome, String titolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
	}
	
	public Oratore (Oratore oratore) {
		this.nome = oratore.getNome();
		this.cognome = oratore.getCognome();
		this.titolo = oratore.getTitolo();
		}

	// Imposto i getter e i setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	// Override per la restituzione della stringa
	@Override
	public String toString() {
		return "Oratore: " + nome + cognome;
	}
	
	
}
