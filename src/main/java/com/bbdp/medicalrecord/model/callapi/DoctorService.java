package com.bbdp.medicalrecord.model.callapi;

import org.apache.http.impl.client.HttpClients;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class DoctorService {
    public static String searchHospital() {
        String uri = "http://140.121.197.130:8004/BBDPDoctor/DoctorAggregateAPI?operation=getAllHospitals";
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate.getForObject(uri, String.class);
    }
    public static String searchDepartment(String hospital) {
        String uri = "http://140.121.197.130:8004/BBDPDoctor/DoctorAggregateAPI?operation=getDepartmentsByHospital&hospital="+hospital;
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate.getForObject(uri, String.class);
    }
    public static ArrayList searchDoctor(String hospital, String department) {
        String uri = "http://140.121.197.130:8004/BBDPDoctor/DoctorAggregateAPI?operation=getDepartmentsByHospital&hospital="+hospital;
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ArrayList doctorList = new ArrayList();
        try {
            JSONArray jsonArray = new JSONArray(restTemplate.getForObject(uri, String.class));
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                doctorList.add(jsonObject.get("doctorID"));
                doctorList.add(jsonObject.get("name"));
            }
        } catch (JSONException e) {
        }
        return doctorList;
    }
    public static JSONObject getDoctorInfoByID(String doctorID) throws JSONException {
        String uri = "http://140.121.197.130:8004/BBDPDoctor/DoctorAggregateAPI?operation=getDoctorInfoById&doctorID="+doctorID;
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return new JSONObject(restTemplate.getForObject(uri, String.class));
    }
}
