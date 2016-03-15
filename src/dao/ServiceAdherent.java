package dao;

import java.util.ArrayList;
import java.util.List;

import meserreurs.MonException;
import metier.Adherent;
import metier.Reservation;
import persistance.DialogueBd;

public class ServiceAdherent {
	
	public void insertAdherent(Adherent a) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		 if (!a.adherentNotEmpty())
			 return;
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ a.getNomAdherent();
			mysql += "'" + ",'" + a.getPrenomAdherent() + "','" +a.getVilleAdherent() + "')";
			bd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void deleteAdherent(Adherent a) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "select * from reservation WHERE id_adherent = '"+a.getIdAdherent()+"';";
			List<Reservation> reservationsAdherent = Service.getInstance().consulterListeReservations(mysql);
			for (Reservation r : reservationsAdherent) {
				Service.getInstance().deleteReservation(r);
			}
			mysql = "DELETE FROM Adherent WHERE id_adherent = '"+a.getIdAdherent()+"';";
			bd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
		
		
	}
	public void updateAdherent(Adherent a) throws MonException {
		String mysql;
		
		DialogueBd bd = DialogueBd.getInstance();
		 if (!a.adherentNotEmpty())
			 return;
		try {
			mysql = "update adherent set nom_adherent='" + a.getNomAdherent() + "', prenom_adherent='" +
					a.getPrenomAdherent() + "', ville_adherent='" + a.getVilleAdherent()
					+ "' where id_adherent='" + a.getIdAdherent() + "'";
			bd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	public Adherent consulterAdherent(int numero) throws MonException {
		String mysql = "select * from adherent where id_adherent=" + numero;
		List<Adherent> mesAdherents = consulterListeAdherents(mysql);
		if (mesAdherents.isEmpty())
			return null;
		else {
			return mesAdherents.get(0);
		}
	}
	
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Adherent a = new Adherent();
				a.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				a.setNomAdherent(rs.get(index + 1).toString());
				a.setPrenomAdherent(rs.get(index + 2).toString());
				a.setVilleAdherent(rs.get(index + 3).toString());
				index = index + 4;
				mesAdherents.add(a);
			}
			return mesAdherents;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
}
