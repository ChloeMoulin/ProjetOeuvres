package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Reservation;
import persistance.DialogueBd;

public class ServiceReservation {
	
	public void deleteReservation(Reservation r) throws MonException {
		String mysql;
		DialogueBd db = DialogueBd.getInstance();
		try {
			Oeuvrevente o = r.getOeuvrevente();
			o.setEtatOeuvrevente("L");
			Service.getInstance().updateOeuvreVente(o,o.getProprietaire());
			mysql = "DELETE FROM Reservation WHERE id_oeuvrevente= '"+r.getOeuvrevente().getId()+"';";
			db.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
	}	
	
	public void updateReservation(Reservation r) throws MonException {
		String mysql;
		DialogueBd db = DialogueBd.getInstance();
		try {
			mysql = "update reservation set statut='" + r.getStatut() + "' where id_oeuvrevente='" + r.getOeuvrevente().getId() + "'";
			db.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void reserverOeuvreVente(Reservation r) throws MonException {
		String mysql;
		DialogueBd db = DialogueBd.getInstance();
		try {
			mysql = "insert into reservation (id_oeuvrevente, id_adherent, date_reservation, statut) values ('" +
					r.getOeuvrevente().getId() + "','" + r.getAdherent().getIdAdherent() + "','"
					+ r.getDate() + "','reservee')";
			db.insertionBD(mysql);
			Oeuvrevente o = r.getOeuvrevente();
			o.setEtatOeuvrevente("R");
			Service.getInstance().updateOeuvreVente(o, o.getProprietaire());
		} catch (MonException e) {
			throw e;
		}
	}

	public Reservation consulterReservation(int numero) throws MonException {
		String mysql = "select * from reservation where id_oeuvrevente=" + numero;
		List<Reservation> mesRes = consulterListeReservations(mysql);
		if (mesRes.isEmpty())
			return null;
		else {
			return mesRes.get(0);
		}
	}
	
	public List<Reservation> consulterListeReservations() throws MonException {
		String mysql = "select * from reservation";
		return consulterListeReservations(mysql);
	}

	public List<Reservation> consulterListeReservations(String mysql) throws MonException {
		List<Object> rs;
		List<Reservation> mesReservations = new ArrayList<Reservation>();
		int index = 0;
		try {
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Service s = new Service();
				String date_replace = rs.get(index+2).toString().replaceAll("-", "/");
				Date date = new SimpleDateFormat("yyyy/MM/dd").parse(date_replace);
				Reservation unR = new Reservation(s.consulterOeuvreVente(Integer.parseInt(rs.get(index + 0).toString())),s.consulterAdherent(Integer.parseInt(rs.get(index+1).toString())),date,rs.get(index+3).toString());
				index = index + 4;
				mesReservations.add(unR);
			}
			return mesReservations;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
}
