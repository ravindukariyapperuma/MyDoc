package com.mydoc.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydoc.model.Doctor;
import com.mydoc.service.DoctorServiceImpl;
import com.mydoc.service.IDoctorService;
/**
 * Servlet implementation class GetDoctorServlet
 */
@WebServlet("/GetDoctorServlet")
public class GetDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String doctorID = request.getParameter("doctorID");
		IDoctorService iDoctorService = new DoctorServiceImpl();
		Doctor doctor = iDoctorService.getDoctorByID(doctorID);
		
		request.setAttribute("doctor", doctor);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetDoctor.jsp");
		dispatcher.forward(request, response);
	}

}
