<%@page import="com.mydoc.model.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mydoc.service.DoctorServiceImpl"%>
<%@page import="com.mydoc.service.IDoctorService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Doctor.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyDoc</title>
</head>
<body>
	<h3>List of Doctors</h3>
	Doctor Management App for MyDoc jsp servlet.
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Doctors</h2></caption>
		 <a href="homeView.jsp">Add Doctor</a>
		  <tr>
                <th>Doctor ID</th>
                <th>Doctor Name</th>
                <th>Available Day</th>
                <th>Hospital</th>
                <th>Speciality</th>
                <th>Telephone No</th>
                <th>Available Time</th>
                <th>Gender</th>
                <th>Select</th>
            </tr>
            <%
            IDoctorService iDoctorService = new DoctorServiceImpl();
			ArrayList<Doctor> arrayList = iDoctorService.getDoctors();
			
			for(Doctor doctor : arrayList){
			%>
			 <tr>
				<td> <%=doctor.getDoctorID() %> </td>
				<td> <%=doctor.getName() %> </td>
				<td> <%=doctor.getAvailableDay() %> </td>
				<td> <%=doctor.getHospital() %> </td>
				<td> <%=doctor.getSpeciality() %> </td>
				<td> <%=doctor.getTelNo() %> </td>
				<td> <%=doctor.getAvailableTime() %> </td>
				<td> <%=doctor.getGender() %> </td>	
				<td> 
				<form method="POST" action="GetDoctorServlet">
				<input type="hidden" name="doctorID" value="<%=doctor.getDoctorID()%>"/>
				 <input type="submit" value= "Select Doctor" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		
</body>
</html>