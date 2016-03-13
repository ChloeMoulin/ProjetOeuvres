package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import meserreurs.MonException;
import metier.Oeuvrepret;
import metier.Proprietaire;

@WebServlet("/ControleurOeuvrePret")
public class ControleurOeuvrePret extends Controleur {
	private static final long serialVersionUID = 1L;

	public ControleurOeuvrePret() {
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
			case "ajouterOeuvre" : {
				try {
					Service s = new Service();
					request.setAttribute("mesProprietaires", s.consulterListeProprietaires());
	
				} catch (MonException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				destinationPage = "/ajouterOeuvre.jsp";
				break;
			}			
			case "insererOeuvrePret" : {
				try {					
					Service s = new Service();					
					Proprietaire p = s.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));					
					Oeuvrepret o = new Oeuvrepret(request.getParameter("txtTitre"),p);					
					s.insertOeuvrePret(o);	
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerOeuvresPret.jsp";
				break;
			}	
			case "supprimerOeuvrePret" : {
				try {
					String id = request.getParameter("id");
					Oeuvrepret o = new Oeuvrepret();
					o.setId(Integer.parseInt(id));
					Service s = new Service();
					s.deleteOeuvrePret(o);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerOeuvresPret.jsp";
				break;
			}			
			case "modifierOeuvrePret" : {
				String id = request.getParameter("id");
				int numero = new Integer(id);
				try {
					Service s = new Service();
					request.setAttribute("mesProprietaires", s.consulterListeProprietaires());
					request.setAttribute("oeuvre", s.consulterOeuvrePret(numero));
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/modifierOeuvrePret.jsp";
				break;
			}
			case "validerModifOeuvrePret" : {
				try {
					Service s = new Service();
					String id = request.getParameter("id");
					int numero = new Integer(id);
					Proprietaire p = s.consulterProprietaire(Integer.parseInt(request.getParameter("proprietaire")));
					Oeuvrepret o = new Oeuvrepret(request.getParameter("txtTitre"), p);
					o.setId(numero);
					s.updateOeuvrePret(o, p);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/index.jsp";
				break;
			}		
			case "listerOeuvresPret" : {
				try {
					Service s = new Service();
					request.setAttribute("mesOeuvres", s.consulterListeOeuvresPret());
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerOeuvresPret.jsp";
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