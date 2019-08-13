<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>MyDoc | Doctor Page</title>
		
		<link rel="stylesheet" type="text/css" href="Form.css">
		<script>
			function validateMyForm(){
				var x=document.forms["doctorform"]["availableDay"].value;
				if (x != "sunday" && x != "monday" && x!= "tuesday" && x != "wednesday" && x != "thuresday" && x != "friday" && x != "saturday"){
					alert("Available day is invalid");
					return false;
				}
			}
</script>
	</head>
<body background="">
<table border='0'width="50%" align="center" bgcolor="#E8E8FA">
<tr><td>
<img src="img/mydoc.PNG" width="100%"></td></tr>
	<tr><td bgcolor="#D8BFD8"><p align="center"><font color="" >Add Docter</font></p></td></tr><tr><td>
    <tr><td bgcolor="#f0f8ff"><p align="left"><font color="red" ><b>*Please enter the doctor details<b></font></p></td></tr><tr><td>
    <br>

    <form name="doctorform" method="post" action="AddDoctorServlet">
  <label for="doctorName">Doctor Name</label>
  <input type="text" name="doctorName" placeholder="Enter Doctor Name....">
  
    <label for="availableDay">Available Day</label>
    <input type="text" name="availableDay" placeholder="Enter Available Day....">
    
    <label for="hospital">Hospital</label>
    <input type="text" name="hospital" placeholder="Enter Hospital....">
    
  <label for="speciality">Speciality</label>
  <input type="text" name="speciality" placeholder="Enter Speciality of doctor....">
  
   <label for="telNo">Telephone No</label>
    <input type="text" name="telNo" placeholder="Enter Telephone No...." maxlength="10">
    
    <label for="availableTime">Available Time</label>
    <input type="text" name="availableTime" placeholder="Enter Doctor Available Time....">
    
    <label for="gender">Gender</label><br><br>
    <input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male<br>
	<input type="radio" name="gender" value="female"
					tabindex="2" /> Female<br>
    
    
  <br><br>
   <input type="submit" value="Add Doctor" class="add-button" onclick = "javascript: return validateMyForm();" />
   <input type="Reset" value="Reset">
</form>

<form method="POST" action="ListDoctorServlet">
		
				<input type="submit" value="List All Doctors" class="list-button" />
		
	</form>
</td></tr>
</table>


</body>
</html>