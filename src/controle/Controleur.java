package controle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrepret;
import metier.Oeuvrevente;
import metier.Proprietaire;
import metier.Reservation;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String LISTER_ADHERENT = "listerAdherent";
	private static final String LISTER_OEUVRES_VENTE = "listerOeuvresVente";
	private static final String LISTER_OEUVRES_PRET = "listerOeuvresPret";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_OEUVRE_VENTE = "insererOeuvreVente";
	private static final String INSERER_OEUVRE_PRET = "insererOeuvrePret";
	private static final String INSERER_ADHERENT = "insererAdherent";
	private static final String MODIFIER_ADHERENT = "modifierAdherent";
	private static final String MODIFIER_OEUVRE_VENTE = "modifierOeuvreVente";
	private static final String MODIFIER_OEUVRE_PRET = "modifierOeuvrePret";
	private static final String RESERVER_OEUVRE_VENTE = "reserverOeuvreVente";
	private static final String VALIDER_MODIF_OEUVRE_VENTE = "validerModifOeuvreVente";
	private static final String VALIDER_MODIF_OEUVRE_PRET = "validerModifOeuvrePret";
	private static final String VALIDER_MODIF_ADHERENT = "validerModifAdherent";
	private static final String VALIDER_RESERVER_OEUVRE_VENTE = "validerReserverOeuvreVente";
	private static final String AJOUTER_OEUVRE = "ajouterOeuvre";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";
	private static final String LISTER_RESERVATIONS = "listerReservations";
	private static final String CONFIRMER_RESERVATION = "confirmerReservation";
	private static final String SUPPRIMER_ADHERENT = "supprimerAdherent";
	private static final String SUPPRIMER_OEUVRE_VENTE = "supprimerOeuvreVente";
	private static final String SUPPRIMER_OEUVRE_PRET = "supprimerOeuvrePret";
	private static final String AJOUTER_PROPRIETAIRE = "ajouterProprietaire";
	private static final String INSERER_PROPRIETAIRE = "insererProprietaire";
	private static final String LISTER_PROPRIETAIRES = "listerProprietaires";
	private static final String MODIFIER_PROPRIETAIRE = "modifierProprietaire";
	private static final String VALIDER_MODIF_PROPRIETAIRE = "validerModifProprietaire";
	private static final String SUPPRIMER_PROPRIETAIRE = "supprimerProprietaire";
	private static final String SUPPRIMER_RESERVATION = "supprimerReservation";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
		// execute l'action
		
		switch (actionName) {
		case CONFIRMER_RESERVATION :
			{
			try {
				Service unService = new Service();
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Reservation r = unService.consulterReservation(numero);
				if (r.getStatut() != "confirmee"){
					r.setStatut("confirmee");
					unService.updateReservation(r);
				}
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerReservations.jsp";
			break;
		}
		case AJOUTER_OEUVRE : {
			try {

				Service unService = new Service();
				request.setAttribute("mesProprietaires", unService.consulterListeProprietaires());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/ajouterOeuvre.jsp";
			break;
		}
		case AJOUTER_PROPRIETAIRE : {

			destinationPage = "/ajouterProprietaire.jsp";
			break;
		}
				
		case INSERER_OEUVRE_VENTE : {
			try {
				
				Service unService = new Service();
				Proprietaire p = unService.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				Float prix = (float) ((request.getParameter("numberPrix") == "") ?  0.0 : Float.parseFloat(request.getParameter("numberPrix")));
				Oeuvrevente uneOeuvre = new Oeuvrevente(request.getParameter("etatOeuvre"),prix, request.getParameter("txtTitre"),p);

				
				unService.insertOeuvreVente(uneOeuvre);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
			break;
		}
		
		case INSERER_OEUVRE_PRET : {
			try {
				
				Service unService = new Service();
				
				Proprietaire p = unService.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				
				Oeuvrepret uneOeuvre = new Oeuvrepret(request.getParameter("txtTitre"),p);

				
				unService.insertOeuvrePret(uneOeuvre);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/listerOeuvrePret.jsp";
			break;
		}
		case INSERER_PROPRIETAIRE : {
			try {
				
				Service unService = new Service();
				Proprietaire p = new Proprietaire(request.getParameter("txtnom"),request.getParameter("txtprenom"));							
				unService.insertProprietaire(p);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/listerProprietaires.jsp";
			break;
		}
		case MODIFIER_PROPRIETAIRE : {
			String id = request.getParameter("id");
			int numero = new Integer(id);
			try {
				Service service = new Service();
				request.setAttribute("proprietaire", service.consulterProprietaire(numero));
			} catch (MonException e) {
				e.printStackTrace();
			}
			
			destinationPage = "/modifierProprietaire.jsp";
			break;
		}
		case MODIFIER_ADHERENT : {
			String id = request.getParameter("id");
			int numero = new Integer(id);
			try {
				Service service = new Service();
				request.setAttribute("adherent", service.consulterAdherent(numero));
			} catch (MonException e) {
				e.printStackTrace();
			}
			
			destinationPage = "/modifierAdherent.jsp";
			break;
		} 
		case VALIDER_MODIF_ADHERENT : {
			try {
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Adherent unAdherent = new Adherent();
				unAdherent.setIdAdherent(numero);
				unAdherent.setNomAdherent(request.getParameter("txtnom"));
				unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
				unAdherent.setVilleAdherent(request.getParameter("txtville"));
				Service unService = new Service();
				unService.updateAdherent(unAdherent);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerAdherent.jsp";
			break;
		}
		case VALIDER_MODIF_PROPRIETAIRE : {
			try {
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Proprietaire p = new Proprietaire(request.getParameter("txtnom"),request.getParameter("txtprenom"));
				p.setIdProprietaire(numero);
				Service unService = new Service();
				unService.updateProprietaire(p);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerProprietaires.jsp";
			break;
		}
		case SUPPRIMER_ADHERENT :{
			try {
				String id = request.getParameter("id");
				Adherent unAdherent = new Adherent();
				unAdherent.setIdAdherent(Integer.parseInt(id));
				Service unService = new Service();
				unService.deleteAdherent(unAdherent);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerAdherent.jsp";
			break;
		}
		case SUPPRIMER_PROPRIETAIRE : {
			try {
				String id = request.getParameter("id");
				Proprietaire p = new Proprietaire();
				p.setIdProprietaire(Integer.parseInt(id));
				Service unService = new Service();
				unService.deleteProprietaire(p);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerProprietaires.jsp";
			break;
		}
		case SUPPRIMER_OEUVRE_VENTE : {
			try {
				String id = request.getParameter("id");
				Oeuvrevente uneOeuvre = new Oeuvrevente();
				uneOeuvre.setId(Integer.parseInt(id));
				Service unService = new Service();
				unService.deleteOeuvreVente(uneOeuvre);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerOeuvresVentes.jsp";
			break;
		}
		case SUPPRIMER_OEUVRE_PRET : {
			try {
				String id = request.getParameter("id");
				Oeuvrepret uneOeuvre = new Oeuvrepret();
				uneOeuvre.setId(Integer.parseInt(id));
				Service unService = new Service();
				unService.deleteOeuvrePret(uneOeuvre);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerOeuvresPret.jsp";
			break;
		}
		case SUPPRIMER_RESERVATION : {
			try {
				String id = request.getParameter("id");
				Reservation r = new Reservation();
				Service unService = new Service();
				r.setOeuvrevente(unService.consulterOeuvreVente(Integer.parseInt(id)));
				unService.deleteReservation(r);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/listerOeuvresPret.jsp";
			break;
		}
		case MODIFIER_OEUVRE_VENTE : {
			String id = request.getParameter("id");
			int numero = new Integer(id);
			try {
				Service service = new Service();
				request.setAttribute("mesProprietaires", service.consulterListeProprietaires());
				request.setAttribute("oeuvre", service.consulterOeuvreVente(numero));
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/modifierOeuvreVente.jsp";
			break;

		} 
		case VALIDER_MODIF_OEUVRE_VENTE : {
			try {
				Service unService = new Service();
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Proprietaire proprietaire = unService.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				Oeuvrevente uneOeuvre = new Oeuvrevente(request.getParameter("etatOeuvre"), Float.parseFloat(request.getParameter("numberPrix")),
						request.getParameter("txtTitre"), proprietaire);
				uneOeuvre.setId(numero);
				unService.updateOeuvreVente(uneOeuvre, proprietaire);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
			break;
		}
		
		case MODIFIER_OEUVRE_PRET : {
			String id = request.getParameter("id");
			int numero = new Integer(id);
			try {
				Service service = new Service();
				request.setAttribute("mesProprietaires", service.consulterListeProprietaires());
				request.setAttribute("oeuvre", service.consulterOeuvrePret(numero));
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/modifierOeuvrePret.jsp";
			break;

		}
		case VALIDER_MODIF_OEUVRE_PRET : {
			try {
				Service unService = new Service();
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Proprietaire proprietaire = unService.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				Oeuvrepret uneOeuvre = new Oeuvrepret(request.getParameter("txtTitre"), proprietaire);
				uneOeuvre.setId(numero);
				unService.updateOeuvrePret(uneOeuvre, proprietaire);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
			break;
		}
		case LISTER_RESERVATIONS : {
			try {
				Service unService = new Service();
				request.setAttribute("mesReservations", unService.consulterListeReservations());
			} catch (MonException e) {
				e.printStackTrace();
			}
			
			destinationPage = "/listerReservations.jsp";
			break;
		}
		case LISTER_ADHERENT : {
			try {

				Service unService = new Service();
				request.setAttribute("mesAdherents", unService.consulterListeAdherents());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerAdherent.jsp";
			break;
		}
		case LISTER_PROPRIETAIRES : {
			try {

				Service unService = new Service();
				request.setAttribute("mesProprietaires", unService.consulterListeProprietaires());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerProprietaires.jsp";
			break;
		}
		case LISTER_OEUVRES_VENTE : {
			try {

				Service unService = new Service();
				request.setAttribute("mesOeuvres", unService.consulterListeOeuvresVente());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerOeuvresVentes.jsp";
			break;
		}
		case LISTER_OEUVRES_PRET : {
			try {
				Service unService = new Service();
				request.setAttribute("mesOeuvres", unService.consulterListeOeuvresPret());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerOeuvresPret.jsp";
			break;
		}
		
		case RESERVER_OEUVRE_VENTE : {
			try {
				Service unService = new Service();
				String id = request.getParameter("id");
				int numero = new Integer(id);
				request.setAttribute("adherents", unService.consulterListeAdherents());
				request.setAttribute("oeuvre", unService.consulterOeuvreVente(numero));
				
			} catch (MonException e) {
				e.printStackTrace();
			}
			
			destinationPage = "/reserverOeuvreVente.jsp";
			break;
		} 
		case VALIDER_RESERVER_OEUVRE_VENTE : {
			try {
				Service unService = new Service();
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Adherent adherent = unService.consulterAdherent(Integer.parseInt(request.getParameter("adherent")));
				Oeuvrevente oeuvre = unService.consulterOeuvreVente(numero);
				String date_replace = request.getParameter("dateReservation").toString().replaceAll("-", "/");
				Date date = new SimpleDateFormat("yyyy/MM/dd").parse(date_replace);
				java.sql.Date vraieDate = new java.sql.Date(date.getTime());
				Reservation reservation = new Reservation(oeuvre, adherent, vraieDate, "reservee");
				unService.reserverOeuvreVente(reservation);
			} catch (Exception e) {
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
			break;
		}
		
		case AJOUTER_ADHERENT : {

			destinationPage = "/ajouterAdherent.jsp";
			break;
		} 
		case INSERER_ADHERENT : {
			try {
				Adherent unAdherent = new Adherent();
				unAdherent.setNomAdherent(request.getParameter("txtnom"));
				unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
				unAdherent.setVilleAdherent(request.getParameter("txtville"));
				Service unService = new Service();
				unService.insertAdherent(unAdherent);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
			break;
		}

		default :
		{
			String messageErreur = "[" + actionName + "] n'est pas une action valide.";
			request.setAttribute(ERROR_KEY, messageErreur);
		}
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
		

	}

}
