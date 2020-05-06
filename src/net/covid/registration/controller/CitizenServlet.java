package net.covid.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.covid.registration.model.Citizen;
import net.covid.registration.t.Citizent;

/**
 * Servlet implementation class CitizenServlet
 */
@WebServlet("/register")
public class CitizenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private Citizent citizent = new Citizent();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitizenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/look/citizenregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Citizen citizen = new Citizen();
		citizen.setFirstName(firstName);
		citizen.setLastName(lastName);
		citizen.setUsername(username);
		citizen.setPassword(password);
		citizen.setContact(contact);
		citizen.setAddress(address);
		
		try {
			citizent.registerCitizen(citizen);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/look/citizendetail.jsp");
		dispatcher.forward(request, response);

	}
}
