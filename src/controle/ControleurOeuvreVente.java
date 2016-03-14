package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;

@WebServlet("/ControleurOeuvreVente")
public class ControleurOeuvreVente extends Controleur {
	private static final long serialVersionUID = 1L;

	public ControleurOeuvreVente() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}
	
	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String actionName = request.getParameter("action");
		String destinationPage = "/erreur.jsp";
		Service s = Service.getInstance();
		switch(actionName) {
		case "ajouterOeuvre" : {
			try {
				request.setAttribute("mesProprietaires", s.consulterListeProprietaires());
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/ajouterOeuvreVente.jsp";
			break;
		}
		case "insererOeuvreVente" : {
			try {
				Proprietaire p = s.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				Float prix = (float) ((request.getParameter("numberPrix") == "") ?  0.0 : Float.parseFloat(request.getParameter("numberPrix")));
				Oeuvrevente o = new Oeuvrevente(request.getParameter("etatOeuvre"),prix, request.getParameter("txtTitre"),p);
				s.insertOeuvreVente(o);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/ControleurOeuvreVente?action=listerOeuvresVente";
			break;
		}
		case "supprimerOeuvreVente" : {
			try {
				String id = request.getParameter("id");
				Oeuvrevente o = new Oeuvrevente();
				o.setId(Integer.parseInt(id));
				s.deleteOeuvreVente(o);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage =  "/ControleurOeuvreVente?action=listerOeuvresVente";
			break;
		}
		case "validerModifOeuvreVente" : {
			try {
				String id = request.getParameter("id");
				int numero = new Integer(id);
				Proprietaire proprietaire = s.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
				Oeuvrevente o = new Oeuvrevente(request.getParameter("etatOeuvre"), Float.parseFloat(request.getParameter("numberPrix")),
						request.getParameter("txtTitre"), proprietaire);
				o.setId(numero);
				s.updateOeuvreVente(o, proprietaire);
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage =  "/ControleurOeuvreVente?action=listerOeuvresVente";
			break;
		}
		case "modifierOeuvreVente" : {
			String id = request.getParameter("id");
			int numero = new Integer(id);
			try {
				request.setAttribute("mesProprietaires", s.consulterListeProprietaires());
				request.setAttribute("oeuvre", s.consulterOeuvreVente(numero));
			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage = "/modifierOeuvreVente.jsp";
			break;

		} 
		case "listerOeuvresVente" : {
			try {
				request.setAttribute("mesOeuvres", s.consulterListeOeuvresVente());

			} catch (MonException e) {
				e.printStackTrace();
			}
			destinationPage =  "/listerOeuvresVente.jsp";
			break;
		}
			default : {
				String messageErreur = "[" + actionName + "] n'est pas une action valide.";
				request.setAttribute("messageErreur", messageErreur);
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}
}