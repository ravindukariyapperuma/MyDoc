package com.mydoc.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.mydoc.model.Doctor;
import com.mydoc.util.CommonConstants;
import com.mydoc.util.CommonUtil;
import com.mydoc.util.DBConnectionUtil;
import com.mydoc.util.QueryUtil;

/**
 * Contract for the implementation of Doctor Service .
 */
public class DoctorServiceImpl implements IDoctorService{
	public static final Logger log = Logger.getLogger(DoctorServiceImpl.class.getName());
	private static final String DoctorID = null;
	private static Connection connection;
	private static Statement statement;
	
	static{
		createDoctorTable();
	}
	
	private PreparedStatement preparedStatement;
	
	public static void createDoctorTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void addDoctor(Doctor doctor) {
		String doctorID = CommonUtil.generateIDs(getDoctorIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_DOCTORS));
			connection.setAutoCommit(false);
			
			doctor.setDoctorID(doctorID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctor.getDoctorID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, doctor.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, doctor.getHospital());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, doctor.getSpeciality());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, doctor.getTelNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, doctor.getAvailableDay());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, doctor.getAvailableTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, doctor.getGender());
			
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	public Doctor getDoctorByID(String doctorID) {
		return actionOnDoctor(doctorID).get(0);
	}
	
	public ArrayList<Doctor> getDoctors(){
		return actionOnDoctor(null);
	}
	
	public void removeDoctor(String doctorID) {
		if(doctorID != null && !doctorID.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_DOCTOR));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctorID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
				
			}
		}
	}
	
	private ArrayList<Doctor> actionOnDoctor(String doctorID){
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (doctorID != null && !doctorID.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_DOCTOR));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctorID);
			}
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_DOCTORS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				doctor.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				doctor.setAvailableDay(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				doctor.setSpeciality(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				doctor.setTelNo(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				doctor.setHospital(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				doctor.setAvailableTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				doctor.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				doctorList.add(doctor);
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}  finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return doctorList;
	}
	public Doctor updateDoctor(String doctorID, Doctor doctor) {
		if (DoctorID != null && !doctorID.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_DOCTOR));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, doctor.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, doctor.getHospital());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, doctor.getSpeciality());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, doctor.getTelNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, doctor.getAvailableDay());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, doctor.getAvailableTime());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, doctor.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, doctor.getDoctorID());
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		return getDoctorByID(doctorID);
	}
	
	private ArrayList<String> getDoctorIDs(){
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_DOCTOR_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}

	
}
