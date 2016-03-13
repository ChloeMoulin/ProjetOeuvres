package dao;

import java.util.ArrayList;
import java.util.List;

import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;
import metier.Reservation;
import persistance.DialogueBd;

public class ServiceOeuvreVente {
	
	public void insertOeuvreVente(Oeuvrevente o) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		if(!o.oeuvreNotEmpty()) {
			return;
		}
		try {
			mysql = "insert into oeuvrevente  (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)  values ('"
					+ o.getTitre()+ "','L";
			mysql += "','" + o.getPrixOeuvrevente() + "','" + o.getProprietaire().getIdProprietaire() + "')";
			bd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void deleteOeuvreVente(Oeuvrevente o) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "select * from reservation WHERE id_oeuvrevente = '"+o.getId()+"';";
			List<Reservation> reservationsOeuvre = Service.getInstance().consulterListeReservations(mysql);
			for (Reservation r : reservationsOeuvre) {
				Service.getInstance().deleteReservation(r);
			}
			mysql = "DELETE FROM Oeuvrevente WHERE id_oeuvrevente = '"+o.getId()+"';";
			bd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
	}
	
	public void updateOeuvreVente(Oeuvrevente o, Proprietaire p) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "update oeuvrevente set titre_oeuvrevente='" + o.getTitre() + "', etat_oeuvrevente='" +
					o.getEtatOeuvrevente() + "', prix_oeuvrevente='" + o.getPrixOeuvrevente()
					+ "', id_proprietaire='" + p.getIdProprietaire() +"' where id_oeuvrevente='" + o.getId() + "'";
			bd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public Oeuvrevente consulterOeuvreVente(int numero) throws MonException {
		String mysql = "select * from oeuvrevente where id_oeuvrevente=" + numero;
		List<Oeuvrevente> mesOeuvres = consulterListeOeuvresVente(mysql);
		if (mesOeuvres.isEmpty())
			return null;
		else {
			return mesOeuvres.get(0);
		}
	}
	
	public List<Oeuvrevente> consulterListeOeuvresVente() throws MonException {
		String mysql = "select * from oeuvrevente";
		return consulterListeOeuvresVente(mysql);
	}

	public List<Oeuvrevente> consulterListeOeuvresVente(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
		int index = 0;
		try {
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Oeuvrevente o = new Oeuvrevente(rs.get(index + 2).toString(),Float.parseFloat(rs.get(index + 3).toString()),rs.get(index + 1).toString(),Service.getInstance().consulterProprietaire(Integer.parseInt(rs.get(index +4).toString())));
				o.setId(Integer.parseInt(rs.get(index+0).toString()));
				index = index + 5;
				mesOeuvres.add(o);
			}

			return mesOeuvres;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
}
