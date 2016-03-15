package dao;

import java.util.ArrayList;
import java.util.List;

import meserreurs.MonException;
import metier.Oeuvrepret;
import metier.Proprietaire;
import persistance.DialogueBd;

public class ServiceOeuvrePret {
	
	public void insertOeuvrePret(Oeuvrepret o) throws MonException {
		String mysql;

		DialogueBd bd = DialogueBd.getInstance();
		if (!o.oeuvreNotEmpty())
			return;
		try {
			mysql = "insert into oeuvrepret  (titre_oeuvrepret,id_proprietaire)  values ('"
					+ o.getTitre()+ "','" + o.getProprietaire().getIdProprietaire()+ "')";

			bd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}
	
	public void deleteOeuvrePret(Oeuvrepret o) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		try {
			mysql = "DELETE FROM Oeuvrepret WHERE id_oeuvrepret = '"+o.getId()+"';";
			bd.execute(mysql);
		}catch (MonException e) {
			throw e;
		}
	}

	public void updateOeuvrePret(Oeuvrepret o, Proprietaire p) throws MonException {
		String mysql;
		DialogueBd bd = DialogueBd.getInstance();
		if (!o.oeuvreNotEmpty())
			return;
		try {
			mysql = "update oeuvrepret set titre_oeuvrepret='" + o.getTitre() + "', id_proprietaire='" + p.getIdProprietaire()
			+ "' where id_oeuvrepret='" + o.getId() + "'";
			bd.execute(mysql);
		} catch (MonException e) {
			throw e;
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
	
	public List<Oeuvrepret> consulterListeOeuvresPret() throws MonException {
		String mysql = "select * from oeuvrepret";
		return consulterListeOeuvresPret(mysql);
	}

	public List<Oeuvrepret> consulterListeOeuvresPret(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrepret> mesOeuvres = new ArrayList<Oeuvrepret>();
		int index = 0;
		try {
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Oeuvrepret o = new Oeuvrepret(rs.get(index + 1).toString(),Service.getInstance().consulterProprietaire(Integer.parseInt(rs.get(index +2).toString())));
				o.setId(Integer.parseInt(rs.get(index+0).toString()));
				index = index + 3;
				mesOeuvres.add(o);
			}
			return mesOeuvres;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
}
