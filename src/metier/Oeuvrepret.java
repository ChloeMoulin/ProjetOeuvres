package metier;



/**
 * The persistent class for the oeuvrepret database table.
 * 
 */

public class Oeuvrepret extends Oeuvre {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Oeuvrepret( String titreOeuvrepret, Proprietaire proprietaire) {
		super(titreOeuvrepret, proprietaire);
	}
	
	public Oeuvrepret() {
		
	}


}