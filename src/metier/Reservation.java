package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Adherent adherent;
	private Oeuvrevente oeuvrevente;
	private String statut;




	public Reservation(Oeuvrevente oeuvrevente, Adherent adherent, Date date, String statut) {
		super();
		this.date = date;
		this.adherent = adherent;
		this.oeuvrevente = oeuvrevente;
		this.statut = statut;
	}

	public Reservation() {
		
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Oeuvrevente getOeuvrevente() {
		return this.oeuvrevente;
	}

	public void setOeuvrevente(Oeuvrevente oeuvrevente) {
		this.oeuvrevente = oeuvrevente;
	}
	
	public String getStatut() {
		return this.statut;
	}
	
	public void setStatut(String statut) {
		this.statut = statut;
	}

}