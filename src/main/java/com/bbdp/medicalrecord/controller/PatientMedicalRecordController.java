/*
This code is generated from JMMA (Java Microservice migration assistant).
JMMA is a tiny widget that helps with generating controller templates from existing models.
The users only need to add some annotations.
For more information and source code, you are able to find them on Github.
(https://github.com/570gina/JMMA)

Author: CHIAYU LI
National Taiwan Ocean University - SOSELab
*/
package com.bbdp.medicalrecord.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bbdp.medicalrecord.model.PatientMedicalRecordServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

// Source: PatientMedicalRecordServer.java
@RestController
@RequestMapping(value = "/PatientMedicalRecord")
public class PatientMedicalRecordController {

    @Autowired
    DataSource dataSource;

  // Original method: newMedicalRecord
    @RequestMapping(value = "/newMedicalRecord", method = RequestMethod.POST)
    public int newMedicalRecord(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String medicalRecord) throws SQLException {
        return PatientMedicalRecordServer.newMedicalRecord(dataSource.getConnection(), doctorID, patientID, medicalRecord);
    }

    // Original method: selectMedicalRecordDate
    @RequestMapping(value = "/selectMedicalRecordDate", method = RequestMethod.GET)
    public ArrayList selectMedicalRecordDate(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String dateRange) throws SQLException {
        return PatientMedicalRecordServer.selectMedicalRecordDate(dataSource.getConnection(), doctorID, patientID, dateRange);
    }

    // Original method: getMedicalRecordList
    @RequestMapping(value = "/getMedicalRecordList", method = RequestMethod.GET)
    public ArrayList getMedicalRecordList(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String dateRange, @RequestParam String date) throws SQLException {
        return PatientMedicalRecordServer.getMedicalRecordList(dataSource.getConnection(), doctorID, patientID, dateRange, date);
    }

    // Original method: checkMedicalRecordID
    @RequestMapping(value = "/checkMedicalRecordID", method = RequestMethod.GET)
    public String checkMedicalRecordID(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String medicalRecordID) throws SQLException {
        return PatientMedicalRecordServer.checkMedicalRecordID(dataSource.getConnection(), doctorID, patientID, medicalRecordID);
    }

    // Original method: getMedicalRecord
    @RequestMapping(value = "/getMedicalRecord", method = RequestMethod.GET)
    public ArrayList getMedicalRecord(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String medicalRecordID) throws SQLException {
        return PatientMedicalRecordServer.getMedicalRecord(dataSource.getConnection(), medicalRecordID);
    }

    // Original method: editMedicalRecord
    @RequestMapping(value = "/editMedicalRecord", method = RequestMethod.POST)
    public int editMedicalRecord(@RequestParam String doctorID, @RequestParam String patientID, @RequestParam String medicalRecordID, @RequestParam String medicalRecord) throws SQLException {
        return PatientMedicalRecordServer.editMedicalRecord(dataSource.getConnection(), medicalRecordID, medicalRecord);
    }
}
