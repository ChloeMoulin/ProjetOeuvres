package dao;

import java.util.ArrayList;
import java.util.List;

import meserreurs.MonException;
import metier.Oeuvrepret;
import metier.Oeuvrevente;
import metier.Proprietaire;
import persistance.DialogueBd;

public class ServiceProprietaire {
	
	public void insertProprietaire(Proprietaire p) throws MonException {
		String mysql;

		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "insert into proprietaire  (nom_proprietaire,prenom_proprietaire)  values ('"
					+ p.getNomProprietaire()+ "','" + p.getPrenomProprietaire()+ "')";

			bd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void deleteProprietaire(Proprietaire p) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "select * from oeuvrevente WHERE id_proprietaire = '"+p.getIdProprietaire()+"';";
			List<Oeuvrevente> oeuvres_vente = Service.getInstance().consulterListeOeuvresVente(mysql);
			for (Oeuvrevente o : oeuvres_vente) {
				Service.getInstance().deleteOeuvreVente(o);
			}
			mysql = "select * from oeuvrepret WHERE id_proprietaire = '"+p.getIdProprietaire()+"';";
			List<Oeuvrepret> oeuvres_pret = Service.getInstance().consulterListeOeuvresPret(mysql);
			for (Oeuvrepret o : oeuvres_pret) {
				Service.getInstance().deleteOeuvrePret(o);
			}
			mysql = "DELETE FROM Proprietaire WHERE id_proprietaire= '"+p.getIdProprietaire()+"';";
			bd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}		
	}
	
	public void updateProprietaire(Proprietaire p) throws MonException {
		String mysql;		
		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "update proprietaire set nom_proprietaire='" + p.getNomProprietaire() + "',prenom_proprietaire = '"+p.getPrenomProprietaire()+"' where id_proprietaire='" + p.getIdProprietaire() + "'";
			bd.execute(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	public Proprietaire consulterProprietaire(int numero) throws MonException {
		String mysql = "select * from proprietaire where id_proprietaire=" + numero;
		List<Proprietaire> mesProprietaires = consulterListeProprietaires(mysql);
		if (mesProprietaires.isEmpty())
			return null;
		else {
			return mesProprietaires.get(0);
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
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Proprietaire p = new Proprietaire();
				p.setIdProprietaire(Integer.parseInt(rs.get(index + 0).toString()));
				p.setNomProprietaire(rs.get(index + 1).toString());
				p.setPrenomProprietaire(rs.get(index + 2).toString());
				index = index + 3;
				mesProprietaires.add(p);
			}
			return mesProprietaires;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
}
