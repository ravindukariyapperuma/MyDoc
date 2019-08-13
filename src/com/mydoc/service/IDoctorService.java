package com.mydoc.service;

import java.util.ArrayList;

import com.mydoc.model.Doctor;
import com.sun.istack.internal.logging.Logger;

public interface IDoctorService {
	
		public static final Logger log = Logger.getLogger(IDoctorService.class.getName(), null);
		
		public void addDoctor(Doctor doctor);
		
		public Doctor getDoctorByID(String doctorID);
		
		public ArrayList<Doctor> getDoctors();
		
		public Doctor updateDoctor(String doctorID, Doctor doctor);
		
		public void removeDoctor(String doctorID);
		
}
