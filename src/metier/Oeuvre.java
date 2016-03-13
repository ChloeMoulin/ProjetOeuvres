package metier;

import java.io.Serializable;

public class Oeuvre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titre;
	private Proprietaire proprietaire;
	
	public Oeuvre(String titre, Proprietaire proprietaire) {

		this.titre = titre;
		this.proprietaire = proprietaire;
	}
	
	public Oeuvre() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public boolean oeuvreNotEmpty() {
		if(titre == null || titre.equals("")) 
			return false;
		if(proprietaire == null)
			return false;
		return true;
	}

}