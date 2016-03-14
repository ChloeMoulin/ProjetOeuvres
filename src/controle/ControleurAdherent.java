package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import meserreurs.MonException;
import metier.Adherent;

@WebServlet("/ControleurAdherent")
public class ControleurAdherent extends Controleur {
	private static final long serialVersionUID = 1L;

	public ControleurAdherent() {
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
			case "modifierAdherent" : {
				String id = request.getParameter("id");
				int numero = new Integer(id);
				try {
					request.setAttribute("adherent", s.consulterAdherent(numero));
				} catch (MonException e) {
					e.printStackTrace();
				}			
				destinationPage = "/modifierAdherent.jsp";
				break;
			}
			case "validerModifAdherent" : {
				try {
					String id = request.getParameter("id");
					int numero = new Integer(id);
					Adherent a = new Adherent();
					a.setIdAdherent(numero);
					a.setNomAdherent(request.getParameter("txtnom"));
					a.setPrenomAdherent(request.getParameter("txtprenom"));
					a.setVilleAdherent(request.getParameter("txtville"));
					s.updateAdherent(a);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/ControleurAdherent?action=listerAdherent";
				break;
			}	
			case "supprimerAdherent" :{
				try {
					String id = request.getParameter("id");
					Adherent a = new Adherent();
					a.setIdAdherent(Integer.parseInt(id));
					s.deleteAdherent(a);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/ControleurAdherent?action=listerAdherent";
				break;
			}
			case "listerAdherent" : {
				try {
					
					request.setAttribute("mesAdherents", s.consulterListeAdherents());
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerAdherent.jsp";
				break;
			}
			case "ajouterAdherent" : {
				destinationPage = "/ajouterAdherent.jsp";
				break;
			} 
			case "insererAdherent" : {
				try {
					Adherent a = new Adherent();
					a.setNomAdherent(request.getParameter("txtnom"));
					a.setPrenomAdherent(request.getParameter("txtprenom"));
					a.setVilleAdherent(request.getParameter("txtville"));
					s.insertAdherent(a);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/ControleurAdherent?action=listerAdherent";
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