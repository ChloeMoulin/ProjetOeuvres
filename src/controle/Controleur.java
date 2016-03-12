package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.*;
import dao.Service;
import meserreurs.*;

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
	private static final String VALIDER_MODIF_OEUVRE_VENTE = "validerModifOeuvreVente";
	private static final String VALIDER_MODIF_OEUVRE_PRET = "validerModifOeuvrePret";
	private static final String VALIDER_MODIF_ADHERENT = "validerModifAdherent";
	private static final String AJOUTER_OEUVRE = "ajouterOeuvre";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";
	
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
		
		if (AJOUTER_OEUVRE.equals(actionName)) {
			try {

				Service unService = new Service();
				request.setAttribute("mesProprietaires", unService.consulterListeProprietaires());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/ajouterOeuvre.jsp";
		}
		
		if (INSERER_OEUVRE_VENTE.equals(actionName)) {
			try {
				
				Service unService = new Service();
				Proprietaire p = unService.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				
				Oeuvrevente uneOeuvre = new Oeuvrevente(request.getParameter("etatOeuvre"),Float.parseFloat(request.getParameter("numberPrix")), request.getParameter("txtTitre"),p);

				
				unService.insertOeuvreVente(uneOeuvre);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
		}
		
		if (INSERER_OEUVRE_PRET.equals(actionName)) {
			try {
				
				Service unService = new Service();
				Proprietaire p = unService.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				
				Oeuvrepret uneOeuvre = new Oeuvrepret(request.getParameter("txtTitre"),p);

				
				unService.insertOeuvrePret(uneOeuvre);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
		}
		if (MODIFIER_ADHERENT.equals(actionName)) {
			String id = request.getParameter("id");
			int numero = new Integer(id);
			try {
				Service service = new Service();
				request.setAttribute("adherent", service.consulterAdherent(numero));
			} catch (MonException e) {
				e.printStackTrace();
			}
			
			destinationPage = "/modifierAdherent.jsp";
		} else if (VALIDER_MODIF_ADHERENT.equals(actionName)) {
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
			destinationPage = "/index.jsp";
		}
		
		if (MODIFIER_OEUVRE_VENTE.equals(actionName)) {
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

		} else if (VALIDER_MODIF_OEUVRE_VENTE.equals(actionName)) {
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
		}
		
		if (MODIFIER_OEUVRE_PRET.equals(actionName)) {
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

		} else if (VALIDER_MODIF_OEUVRE_PRET.equals(actionName)) {
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
		}
		
		if (LISTER_ADHERENT.equals(actionName)) {
			try {

				Service unService = new Service();
				request.setAttribute("mesAdherents", unService.consulterListeAdherents());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerAdherent.jsp";
		}
		if (LISTER_OEUVRES_VENTE.equals(actionName)) {
			try {

				Service unService = new Service();
				request.setAttribute("mesOeuvres", unService.consulterListeOeuvresVente());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerOeuvresVentes.jsp";
		}
		if (LISTER_OEUVRES_PRET.equals(actionName)) {
			try {

				Service unService = new Service();
				request.setAttribute("mesOeuvres", unService.consulterListeOeuvresPret());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerOeuvresPret.jsp";
		}
		if (AJOUTER_ADHERENT.equals(actionName)) {

			destinationPage = "/ajouterAdherent.jsp";
		} else if (INSERER_ADHERENT.equals(actionName)) {
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
		}

		else {
			String messageErreur = "[" + actionName + "] n'est pas une action valide.";
			request.setAttribute(ERROR_KEY, messageErreur);
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

}
