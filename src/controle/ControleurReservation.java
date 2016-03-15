package controle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Reservation;

@WebServlet("/ControleurReservation")
public class ControleurReservation extends Controleur {
	private static final long serialVersionUID = 1L;

	public ControleurReservation() {
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
			case "confirmerReservation" : {
				try {
					String id = request.getParameter("id");
					int numero = new Integer(id);
					Reservation r = s.consulterReservation(numero);
					if (r.getStatut() != "confirmee"){
						r.setStatut("confirmee");
						s.updateReservation(r);
					}
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/ControleurReservation?action=listerReservations";
				break;
			}
			case "supprimerReservation" : {
				try {
					String id = request.getParameter("id");
					if (id.equals("")) {
						destinationPage = "/ControleurReservation?action=listerReservations";
						break;
					}
					Reservation r = new Reservation();
					r.setOeuvrevente(s.consulterOeuvreVente(Integer.parseInt(id)));
					s.deleteReservation(r);
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/ControleurReservation?action=listerReservations";
				break;
			}
			case "listerReservations" : {
				try {
					request.setAttribute("mesReservations", s.consulterListeReservations());
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/listerReservations.jsp";
				break;
			}
			case "reserverOeuvreVente" : {
				try {
					String id = request.getParameter("id");
					int numero = new Integer(id);
					request.setAttribute("adherents", s.consulterListeAdherents());
					request.setAttribute("oeuvre", s.consulterOeuvreVente(numero));
					
				    Date date = Calendar.getInstance().getTime();
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    
					request.setAttribute("dateToday",sdf.format(date) );
				} catch (MonException e) {
					e.printStackTrace();
				}
				destinationPage = "/reserverOeuvreVente.jsp";
				break;
			} 
			case "validerReserverOeuvreVente" : {
				try {
					String id = request.getParameter("id");
					int numero = new Integer(id);
					Adherent a = s.consulterAdherent(Integer.parseInt(request.getParameter("adherent")));
					Oeuvrevente o = s.consulterOeuvreVente(numero);
					String date_replace = request.getParameter("dateReservation").toString().replaceAll("-", "/");
					Date date = new SimpleDateFormat("yyyy/MM/dd").parse(date_replace);
					java.sql.Date vraieDate = new java.sql.Date(date.getTime());
					Reservation r = new Reservation(o, a, vraieDate, "reservee");
					s.reserverOeuvreVente(r);
				} catch (Exception e) {
					e.printStackTrace();
				}
				destinationPage = "/ControleurReservation?action=listerReservations";;
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