package dao;

import meserreurs.MonException;
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
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
<<<<<<< HEAD

	public void insertOeuvreVente(Oeuvrevente uneOeuvre) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into oeuvrevente  (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)  values ('"
					+ uneOeuvre.getTitre()+ "','" + uneOeuvre.getEtatOeuvrevente();
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
=======
	
	public void updateAdherent(Adherent unAdherent) throws MonException {
		String mysql;
		
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "update adherent set nom_adherent='" + unAdherent.getNomAdherent() + "', prenom_adherent='" +
					unAdherent.getPrenomAdherent() + "', ville_adherent='" + unAdherent.getVilleAdherent()
					+ "' where id_adherent='" + unAdherent.getIdAdherent() + "'";
			unDialogueBd.execute(mysql);
>>>>>>> 204eed5bf26a4a63759386db33c8b5b2b1c3478c
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