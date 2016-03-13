package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import meserreurs.MonException;
import metier.Proprietaire;

@WebServlet("/ControleurProprietaire")
public class ControleurProprietaire extends Controleur {
	private static final long serialVersionUID = 1L;

	public ControleurProprietaire() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}
	
	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String actionName = request.getParameter("action");
		String destinationPage = "/erreur.jsp";
		
		switch(actionName) {
			case "ajouterProprietaire" : {
				destinationPage = "/ajouterProprietaire.jsp";
				break;
			}
			case "insererProprietaire" : {
				try {
					
					Service s = new Service();
					Proprietaire p = new Proprietaire(request.getParameter("txtnom"),request.getParameter("txtprenom"));							
					s.insertProprietaire(p);

				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				destinationPage = "/listerProprietaires.jsp";
				break;
			}
			case "modifierProprietaire" : {
				String id = request.getParameter("id");
				int numero = new Integer(id);
				try {
					Service s = new Service();
					request.setAttribute("proprietaire", s.consulterProprietaire(numero));
				} catch (MonException e) {
					e.printStackTrace();
				}
				
				destinationPage = "/modifierProprietaire.jsp";
				break;
			}
			case "validerModifProprietaire" : {
				try {
					String id = request.getParameter("id");
					int numero = new Integer(id);
					Proprietaire p = new Proprietaire(request.getParameter("txtnom"),request.getParameter("txtprenom"));
					p.setIdProprietaire(numero);
					Service s = new Service();
					s.updateProprietaire(p);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerProprietaires.jsp";
				break;
			}
			case "supprimerProprietaire" : {
				try {
					String id = request.getParameter("id");
					Proprietaire p = new Proprietaire();
					p.setIdProprietaire(Integer.parseInt(id));
					Service s = new Service();
					s.deleteProprietaire(p);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerProprietaires.jsp";
				break;
			}
			case "listerProprietaires" : {
				try {
					Service s = new Service();
					request.setAttribute("mesProprietaires", s.consulterListeProprietaires());

				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerProprietaires.jsp";
				break;
			}
			default :
			{
				String messageErreur = "[" + actionName + "] n'est pas une action valide.";
				request.setAttribute("messageErreur", messageErreur);
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
		
	}
}