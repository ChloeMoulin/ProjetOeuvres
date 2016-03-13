package dao;

import meserreurs.MonException;
import java.util.*;
import metier.*;


public class Service {
	
	private static Service instance = null;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}
	
	private ServiceAdherent sa;
	private ServiceOeuvrePret sop;
	private ServiceOeuvreVente sov;
	private ServiceProprietaire sp;
	private ServiceReservation sr;
	
	public Service() {
		sa = new ServiceAdherent();
		sop = new ServiceOeuvrePret();
		sov = new ServiceOeuvreVente();
		sp = new ServiceProprietaire();
		sr = new ServiceReservation();
	}

	public void insertAdherent(Adherent a) throws MonException {
		sa.insertAdherent(a);
	}
	
	public void deleteAdherent(Adherent a) throws MonException {
		sa.deleteAdherent(a);
	}
	
	public void updateAdherent(Adherent a) throws MonException {
		sa.updateAdherent(a);
	}
	
	public Adherent consulterAdherent(int numero) throws MonException {
		return sa.consulterAdherent(numero);
	}
	
	public List<Adherent> consulterListeAdherents() throws MonException {
		return sa.consulterListeAdherents();
	}
	
	public void insertOeuvrePret(Oeuvrepret o) throws MonException {
		sop.insertOeuvrePret(o);
	}
	
	public void deleteOeuvrePret(Oeuvrepret o) throws MonException {
		sop.deleteOeuvrePret(o);
	}
	
	public void updateOeuvrePret(Oeuvrepret o, Proprietaire p) throws MonException {
		sop.updateOeuvrePret(o, p);
	}
	
	public Oeuvrepret consulterOeuvrePret(int numero) throws MonException {	
		return sop.consulterOeuvrePret(numero);
	}
	
	public List<Oeuvrepret> consulterListeOeuvresPret() throws MonException {	
		return sop.consulterListeOeuvresPret();
	}
	
	public List<Oeuvrepret> consulterListeOeuvresPret(String mysql) throws MonException {
		return sop.consulterListeOeuvresPret(mysql);
	}
		
	public void insertOeuvreVente(Oeuvrevente o) throws MonException {
		sov.insertOeuvreVente(o);
	}
	
	public void deleteOeuvreVente(Oeuvrevente o) throws MonException {
		sov.deleteOeuvreVente(o);
	}
	
	public void updateOeuvreVente(Oeuvrevente o, Proprietaire p) throws MonException {
		sov.updateOeuvreVente(o, p);
	}
	
	public Oeuvrevente consulterOeuvreVente(int numero) throws MonException {
		return sov.consulterOeuvreVente(numero);
	}
	
	public List<Oeuvrevente> consulterListeOeuvresVente() throws MonException {
		return sov.consulterListeOeuvresVente();
	}
	
	public List<Oeuvrevente> consulterListeOeuvresVente(String mysql) throws MonException {
		return sov.consulterListeOeuvresVente(mysql);
	}
	
	public void insertProprietaire(Proprietaire p) throws MonException {
		sp.insertProprietaire(p);
	}
	
	public void deleteProprietaire(Proprietaire p) throws MonException {
		sp.deleteProprietaire(p);
	}
	
	public void updateProprietaire(Proprietaire p) throws MonException {
		sp.updateProprietaire(p);
	}
	
	public Proprietaire consulterProprietaire(int numero) throws MonException {
		return sp.consulterProprietaire(numero);
	}
	
	public List<Proprietaire> consulterListeProprietaires() throws MonException {
		return sp.consulterListeProprietaires();
	}
	
	public void deleteReservation(Reservation r) throws MonException {
		sr.deleteReservation(r);
	}
	
	public void updateReservation(Reservation r) throws MonException {
		sr.updateReservation(r);
	}
	
	public void reserverOeuvreVente(Reservation r) throws MonException {
		sr.reserverOeuvreVente(r);
	}
	
	public Reservation consulterReservation(int numero) throws MonException {
		return sr.consulterReservation(numero);
	};
	
	public List<Reservation> consulterListeReservations() throws MonException {
		return sr.consulterListeReservations();
	}
	
	public List<Reservation> consulterListeReservations(String mysql) throws MonException {
		return sr.consulterListeReservations(mysql);
	}
		
}

