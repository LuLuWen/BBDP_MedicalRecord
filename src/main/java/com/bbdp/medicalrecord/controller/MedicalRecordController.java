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

import com.bbdp.medicalrecord.model.MedicalRecordServer;
import com.bbdp.medicalrecord.model.callapi.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

//Source: MedicalRecordServer.java

@RestController
@RequestMapping(value = "/MedicalRecord")
public class MedicalRecordController {

    @Autowired
    DataSource dataSource;

    //取得所有醫生
    // Original method: searchHospital
    @RequestMapping(value = "/searchHospital", method = RequestMethod.GET)
    public String searchHospital() {
        return DoctorService.searchHospital();
    }

    // Original method: searchDepartment
    @RequestMapping(value = "/searchDepartment", method = RequestMethod.GET)
    public String searchDepartment(@RequestParam String hospital) {
        return DoctorService.searchDepartment(hospital);
    }

    // Original method: searchDoctor
    @RequestMapping(value = "/searchDoctor", method = RequestMethod.GET)
    public ArrayList searchDoctor(@RequestParam String hospital, @RequestParam String department) {
        return DoctorService.searchDoctor(hospital, department);
    }

    // Original method: searchDate
    @RequestMapping(value = "/searchDate", method = RequestMethod.GET)
    public ArrayList searchDate(@RequestParam String patientID, @RequestParam String doctorID) throws SQLException {
        return MedicalRecordServer.searchDate(dataSource.getConnection(), patientID, doctorID);
    }

    // Original method: getMedicalRecord
    @RequestMapping(value = "/getMedicalRecord", method = RequestMethod.GET)
    public ArrayList getMedicalRecord(@RequestParam String medicalRecordID) throws SQLException {
        return MedicalRecordServer.getMedicalRecord(dataSource.getConnection(), medicalRecordID);
    }

}
