<%@page import="com.mydoc.model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Doctor.css" />
<meta charset="UTF-8">
<title>Doctor Management</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Get Doctor Page</h2>

	MyDoc Doctor
	<br>
	<br>
	<%
		Doctor doctor = (Doctor) request.getAttribute("doctor");
	%>

	<form method="POST" action="UpdateDoctorServlet">
		<table>
			<tr>
				<td>Doctor ID</td>
				<td><input type="text" name="doctorID" disabled="disabled"
					value="<%=doctor.getDoctorID()%>" /></td>
			</tr>
			<tr>
				<td>Doctor Name</td>
				<td><input type="text" name="doctorName"
					value="<%=doctor.getName()%>" /></td>
			</tr>
			<tr>
				<td>Available Day</td>
				<td><input type="text" name="availableDay"
					value="<%=doctor.getAvailableDay()%>" /></td>
			</tr>
			<tr>
				<td>Hospital</td>
				<td><input type="text" name="hospital"
					value="<%=doctor.getHospital()%>" /></td>
			</tr>
			<tr>
				<td>Speciality</td>
				<td><input type="text" name="speciality"
					value="<%=doctor.getSpeciality()%>" /></td>
			</tr>
			<tr>
				<td>Telephone No</td>
				<td><input type="text" name="telNo"
					value="<%=doctor.getTelNo()%>" /></td>
			</tr>
			<tr>
				<td>Available Time</td>
				<td><input type="text" name="availableTime"
					value="<%=doctor.getAvailableTime()%>" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="gender" value="female"
					tabindex="2" /> Female</td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="doctorID"
					value="<%=doctor.getDoctorID()%>" /> <input type="submit"
					value="Update Doctor" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteDoctorServlet">
					<input type="hidden" name="doctorID"
						value="<%=doctor.getDoctorID()%>" /> <input type="submit"
						value="Delete Doctor" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>