package com.bbdp.medicalrecord.model;

import com.bbdp.medicalrecord.model.callapi.DoctorService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MedicalRecordServer {

	public static ArrayList searchDate(Connection conn, String patientID, String doctorID) {
		ArrayList searchList = new ArrayList();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM medicalrecord where doctorID = '"+doctorID+"' and patientID = '"+patientID+"' ORDER BY addTime DESC");
		    while (rs.next()) {
		    	searchList.add(rs.getString("medicalRecordID"));
		    	searchList.add(rs.getString("addTime"));
		    }
			rs.close();
		    st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return searchList;
	}
	public static ArrayList getMedicalRecord(Connection conn, String medicalRecordID) {
		ArrayList searchList = new ArrayList();
		try {
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * FROM medicalrecord where medicalRecordID = '"+medicalRecordID+"'");
		    while (rs.next()) {
		    	String doctorID = rs.getString("doctorID");
				JSONObject doctor = DoctorService.getDoctorInfoByID(doctorID);
				searchList.add(doctor.get("hospital"));//0
		    	searchList.add(doctor.get("department"));//1
		    	searchList.add(doctor.get("name"));//2
		    	searchList.add(rs.getString("addTime"));//3
		    	searchList.add(rs.getString("editTime"));//4
		    	searchList.add(rs.getString("content"));//5
		    	searchList.add(doctorID);//6
		    }
			rs.close();
		    st.close();
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		} finally {
		      if (conn!=null) try {conn.close();}catch (Exception ignore) {}
		}
		return searchList;
	}
}
