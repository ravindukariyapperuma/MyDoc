package com.mydoc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mydoc.service.IDoctorService;
import com.mydoc.util.CommonConstants;
import com.mydoc.util.QueryUtil;

public class CommonUtil {
	public static final Logger log = Logger.getLogger(IDoctorService.class.getName());
	public static final Properties properties = new Properties();
	static {
		try {
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
			
	}
	
	public static String generateIDs(ArrayList<String> arrayList) {
		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.DOCTOR_ID_PREFIX + next;
		if(arrayList.contains(id)) {
			next++;
			id = CommonConstants.DOCTOR_ID_PREFIX + next;
		}
		return id;
	}
}
