package metier;



/**
 * The persistent class for the oeuvrevente database table.
 * 
 */

public class Oeuvrevente extends Oeuvre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String etatOeuvrevente;
	private float prixOeuvrevente;



	public Oeuvrevente(String etatOeuvrevente, float prixOeuvrevente, String titreOeuvrevente,
			Proprietaire proprietaire) {
		super(titreOeuvrevente, proprietaire);
		this.etatOeuvrevente = etatOeuvrevente;
		this.prixOeuvrevente = prixOeuvrevente;
	}
	
	public Oeuvrevente() {
		
	}

	public String getEtatOeuvrevente() {
		return this.etatOeuvrevente;
	}

	public void setEtatOeuvrevente(String etatOeuvrevente) {
		this.etatOeuvrevente = etatOeuvrevente;
	}

	public float getPrixOeuvrevente() {
		return this.prixOeuvrevente;
	}

	public void setPrixOeuvrevente(float prixOeuvrevente) {
		this.prixOeuvrevente = prixOeuvrevente;
	}
}