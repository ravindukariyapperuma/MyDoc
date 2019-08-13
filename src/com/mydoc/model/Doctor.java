package com.mydoc.model;
/**
 * This is the Doctor model class
 */
public class Doctor {
	private String DoctorID;
	private String Name;
	private String Hospital;
	private String Speciality;
	private String TelNo;
	private String AvailableDay;
	private String AvailableTime;
	private String Gender;
	
	
	public String getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getHospital() {
		return Hospital;
	}
	public void setHospital(String hospital) {
		Hospital = hospital;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public String getTelNo() {
		return TelNo;
	}
	public void setTelNo(String telNo) {
		TelNo = telNo;
	}
	public String getAvailableDay() {
		return AvailableDay;
	}
	public void setAvailableDay(String availableDay) {
		AvailableDay = availableDay;
	}
	public String getAvailableTime() {
		return AvailableTime;
	}
	public void setAvailableTime(String availableTime) {
		AvailableTime = availableTime;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String toString() {
		return "Doctor ID = " + DoctorID + "\n" + "Doctor Name = " + Name + "\n" + "Available Day = " + AvailableDay + "\n"
				+ "Speciality = " + Speciality + "\n" + "Telephone No = " + TelNo + "\n" + "Hospital = " + Hospital +
				"\n" + "Available Time = " + AvailableTime + "\n" + "Gender = " + Gender;
	}
}
