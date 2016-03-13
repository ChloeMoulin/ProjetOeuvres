package dao;

import meserreurs.MonException;

import java.text.SimpleDateFormat;
import java.util.*;

import metier.*;
import persistance.*;

public class Service {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insertAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		 if (!unAdherent.adherentNotEmpty())
			 return;
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public void insertOeuvreVente(Oeuvrevente uneOeuvre) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		if(!uneOeuvre.oeuvreNotEmpty()) {
			return;
		}
		try {
			mysql = "insert into oeuvrevente  (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)  values ('"
					+ uneOeuvre.getTitre()+ "','L";
			mysql += "','" + uneOeuvre.getPrixOeuvrevente() + "','" + uneOeuvre.getProprietaire().getIdProprietaire() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	public void insertOeuvrePret(Oeuvrepret uneOeuvre) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into oeuvrepret  (titre_oeuvrepret,id_proprietaire)  values ('"
					+ uneOeuvre.getTitre()+ "','" + uneOeuvre.getProprietaire().getIdProprietaire()+ "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	public void insertProprietaire(Proprietaire p) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into proprietaire  (nom_proprietaire,prenom_proprietaire)  values ('"
					+ p.getNomProprietaire()+ "','" + p.getPrenomProprietaire()+ "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}	
	public void deleteOeuvreVente(Oeuvrevente uneOeuvre) throws MonException {
		String mysql;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "select * from reservation WHERE id_oeuvrevente = '"+uneOeuvre.getId()+"';";
			List<Reservation> reservationsOeuvre = consulterListeReservations(mysql);
			for (Reservation r : reservationsOeuvre) {
				this.deleteReservation(r);
			}
			mysql = "DELETE FROM Oeuvrevente WHERE id_oeuvrevente = '"+uneOeuvre.getId()+"';";
			unDialogueBd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
	}
	public void deleteOeuvrePret(Oeuvrepret uneOeuvre) throws MonException {
		String mysql;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "DELETE FROM Oeuvrepret WHERE id_oeuvrepret = '"+uneOeuvre.getId()+"';";
			unDialogueBd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
	}
	public void deleteAdherent(Adherent unAdherent) throws MonException {
		String mysql;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "select * from reservation WHERE id_adherent = '"+unAdherent.getIdAdherent()+"';";
			List<Reservation> reservationsAdherent = consulterListeReservations(mysql);
			for (Reservation r : reservationsAdherent) {
				this.deleteReservation(r);
			}
			mysql = "DELETE FROM Adherent WHERE id_adherent = '"+unAdherent.getIdAdherent()+"';";
			unDialogueBd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
	}
	
	public void deleteReservation(Reservation r) throws MonException {
		String mysql;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			Oeuvrevente o = r.getOeuvrevente();
			o.setEtatOeuvrevente("L");
			this.updateOeuvreVente(o,o.getProprietaire());
			mysql = "DELETE FROM Reservation WHERE id_oeuvrevente= '"+r.getOeuvrevente().getId()+"';";
			unDialogueBd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
	}
	public void deleteProprietaire(Proprietaire p) throws MonException {
		String mysql;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "select * from oeuvrevente WHERE id_proprietaire = '"+p.getIdProprietaire()+"';";
			List<Oeuvrevente> oeuvres_vente = consulterListeOeuvresVente(mysql);
			for (Oeuvrevente o : oeuvres_vente) {
				this.deleteOeuvreVente(o);
			}
			mysql = "select * from oeuvrepret WHERE id_proprietaire = '"+p.getIdProprietaire()+"';";
			List<Oeuvrepret> oeuvres_pret = consulterListeOeuvresPret(mysql);
			for (Oeuvrepret o : oeuvres_pret) {
				this.deleteOeuvrePret(o);
			}
			mysql = "DELETE FROM Proprietaire WHERE id_proprietaire= '"+p.getIdProprietaire()+"';";
			unDialogueBd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
		
	}
	public void updateAdherent(Adherent unAdherent) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update adherent set nom_adherent='" + unAdherent.getNomAdherent() + "', prenom_adherent='" +
					unAdherent.getPrenomAdherent() + "', ville_adherent='" + unAdherent.getVilleAdherent()
					+ "' where id_adherent='" + unAdherent.getIdAdherent() + "'";
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void updateOeuvreVente(Oeuvrevente uneOeuvre, Proprietaire p) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update oeuvrevente set titre_oeuvrevente='" + uneOeuvre.getTitre() + "', etat_oeuvrevente='" +
					uneOeuvre.getEtatOeuvrevente() + "', prix_oeuvrevente='" + uneOeuvre.getPrixOeuvrevente()
					+ "', id_proprietaire='" + p.getIdProprietaire() +"' where id_oeuvrevente='" + uneOeuvre.getId() + "'";
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void updateOeuvrePret(Oeuvrepret uneOeuvre, Proprietaire p) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update oeuvrepret set titre_oeuvrepret='" + uneOeuvre.getTitre() + "', id_proprietaire='" + p.getIdProprietaire()
			+ "' where id_oeuvrepret='" + uneOeuvre.getId() + "'";
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void updateReservation(Reservation r) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update reservation set statut='" + r.getStatut() + "' where id_oeuvrevente='" + r.getOeuvrevente().getId() + "'";
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	public void updateProprietaire(Proprietaire p) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update proprietaire set nom_proprietaire='" + p.getNomProprietaire() + "',prenom_proprietaire = '"+p.getPrenomProprietaire()+"' where id_proprietaire='" + p.getIdProprietaire() + "'";
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
		
	public void reserverOeuvreVente(Reservation reservation) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into reservation (id_oeuvrevente, id_adherent, date_reservation, statut) values ('" +
					reservation.getOeuvrevente().getId() + "','" + reservation.getAdherent().getIdAdherent() + "','"
					+ reservation.getDate() + "','reservee')";
			unDialogueBd.insertionBD(mysql);
			Oeuvrevente o = reservation.getOeuvrevente();
			o.setEtatOeuvrevente("R");
			this.updateOeuvreVente(o, o.getProprietaire());
		} catch (MonException e) {
			throw e;
		}
	}
	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Adherent consulterAdherent(int numero) throws MonException {
		String mysql = "select * from adherent where id_adherent=" + numero;
		List<Adherent> mesAdh = consulterListeAdherents(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	}
	
	public Proprietaire consulterProprietaire(int numero) throws MonException {
		String mysql = "select * from proprietaire where id_proprietaire=" + numero;
		List<Proprietaire> mesProp = consulterListeProprietaires(mysql);
		if (mesProp.isEmpty())
			return null;
		else {
			return mesProp.get(0);
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
	
	public Oeuvrevente consulterOeuvreVente(int numero) throws MonException {
		String mysql = "select * from oeuvrevente where id_oeuvrevente=" + numero;
		List<Oeuvrevente> mesOeuvres = consulterListeOeuvresVente(mysql);
		if (mesOeuvres.isEmpty())
			return null;
		else {
			return mesOeuvres.get(0);
		}
	}
	
	public Oeuvrepret consulterOeuvrePret(int numero) throws MonException {
		String mysql = "select * from oeuvrepret where id_oeuvrepret=" + numero;
		List<Oeuvrepret> mesOeuvres = consulterListeOeuvresPret(mysql);
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

	private List<Oeuvrevente> consulterListeOeuvresVente(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Oeuvrevente unO = new Oeuvrevente(rs.get(index + 2).toString(),Float.parseFloat(rs.get(index + 3).toString()),rs.get(index + 1).toString(),this.consulterProprietaire(Integer.parseInt(rs.get(index +4).toString())));
				// On incr�mente tous les 3 champs
				unO.setId(Integer.parseInt(rs.get(index+0).toString()));
				index = index + 5;
				mesOeuvres.add(unO);
			}

			return mesOeuvres;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
	public List<Reservation> consulterListeReservations() throws MonException {
		String mysql = "select * from reservation";
		return consulterListeReservations(mysql);
	}

	private List<Reservation> consulterListeReservations(String mysql) throws MonException {
		List<Object> rs;
		List<Reservation> mesReservations = new ArrayList<Reservation>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Service unService = new Service();
				String date_replace = rs.get(index+2).toString().replaceAll("-", "/");
				
				Date date = new SimpleDateFormat("yyyy/MM/dd").parse(date_replace);
				Reservation unR = new Reservation(unService.consulterOeuvreVente(Integer.parseInt(rs.get(index + 0).toString())),unService.consulterAdherent(Integer.parseInt(rs.get(index+1).toString())),date,rs.get(index+3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				mesReservations.add(unR);
			}

			return mesReservations;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public List<Oeuvrepret> consulterListeOeuvresPret() throws MonException {
		String mysql = "select * from oeuvrepret";
		return consulterListeOeuvresPret(mysql);
	}

	private List<Oeuvrepret> consulterListeOeuvresPret(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrepret> mesOeuvres = new ArrayList<Oeuvrepret>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Oeuvrepret unO = new Oeuvrepret(rs.get(index + 1).toString(),this.consulterProprietaire(Integer.parseInt(rs.get(index +2).toString())));
				// On incr�mente tous les 3 champs
				unO.setId(Integer.parseInt(rs.get(index+0).toString()));
				index = index + 3;
				mesOeuvres.add(unO);
			}

			return mesOeuvres;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Adherent unA = new Adherent();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomAdherent(rs.get(index + 1).toString());
				unA.setPrenomAdherent(rs.get(index + 2).toString());
				unA.setVilleAdherent(rs.get(index + 3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				mesAdherents.add(unA);
			}

			return mesAdherents;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
	public List<Proprietaire> consulterListeProprietaires() throws MonException {
		String mysql = "select * from proprietaire";
		return consulterListeProprietaires(mysql);
	}

	private List<Proprietaire> consulterListeProprietaires(String mysql) throws MonException {
		List<Object> rs;
		List<Proprietaire> mesProprietaires = new ArrayList<Proprietaire>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Proprietaire unP = new Proprietaire();
				unP.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
				unP.setNomProprietaire(rs.get(index + 1).toString());
				unP.setPrenomProprietaire(rs.get(index + 2).toString());
				index = index + 3;
				mesProprietaires.add(unP);
			}

			return mesProprietaires;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

}
