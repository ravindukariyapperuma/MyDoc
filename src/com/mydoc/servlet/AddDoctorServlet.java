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
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
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
		response.setContentType("text/html");
		Doctor doctor = new Doctor();
		
		doctor.setName(request.getParameter("doctorName"));
		doctor.setAvailableDay(request.getParameter("availableDay"));
		doctor.setHospital(request.getParameter("hospital"));
		doctor.setSpeciality(request.getParameter("speciality"));
		doctor.setTelNo(request.getParameter("telNo"));
		doctor.setAvailableTime(request.getParameter("availableTime"));
		doctor.setGender(request.getParameter("gender"));

		IDoctorService iDoctorService = new DoctorServiceImpl();
		iDoctorService.addDoctor(doctor);

		request.setAttribute("doctor", doctor);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListDoctors.jsp");
		dispatcher.forward(request, response);
	}

}
