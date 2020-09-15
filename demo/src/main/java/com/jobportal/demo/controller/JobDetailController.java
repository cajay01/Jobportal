package com.jobportal.demo.controller;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.jobportal.demo.model.Car;
import com.jobportal.demo.model.JobDetails;
import com.jobportal.demo.model.JobRequirement;
import com.jobportal.demo.model.SubmitReq;

@CrossOrigin(origins = "http://localhost:3000" , allowedHeaders="*")
@RestController
@RequestMapping("/api")
class JobDetailController {
	List<JobRequirement> jobDetails=new ArrayList<JobRequirement>();
	
	

@GetMapping("/getAllJobRequirement")
public ResponseEntity<List<JobRequirement>> getAllJobs() throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper=new ObjectMapper();
	objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	String str="[\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"WIPRO\",\r\n" + 
			"			\"exp\": \"3-4\",\r\n" + 
			"			\"skills\": \"Fullstack\",\r\n" + 
			"			\"education\": \"B.E,B.Tech,any masters\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"Infosys\",\r\n" + 
			"			\"exp\": \"3-4\",\r\n" + 
			"			\"skills\": \"Big Data\",\r\n" + 
			"			\"education\": \"B.E.,B.Tech\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"Persistant\",\r\n" + 
			"			\"exp\": \"3-4\",\r\n" + 
			"			\"skills\": \"Automation\",\r\n" + 
			"			\"education\": \"B.E.\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"TCS\",\r\n" + 
			"			\"exp\": \"7-8\",\r\n" + 
			"			\"skills\": \"Informatica\",\r\n" + 
			"			\"education\": \"B.E,M.Tech\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"Atos\",\r\n" + 
			"			\"exp\": \"4-5\",\r\n" + 
			"			\"skills\": \"UI UX Design\",\r\n" + 
			"			\"education\": \"B.E,M.Tech\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"Syntel\",\r\n" + 
			"			\"exp\": \"2-3\",\r\n" + 
			"			\"skills\": \"Angular,HTML,Bottstrap,CSS\",\r\n" + 
			"			\"education\": \"B.Tech\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"Zensar\",\r\n" + 
			"			\"exp\": \"5-6\",\r\n" + 
			"			\"skills\": \"Testing Database,UI,webservice\",\r\n" + 
			"			\"education\": \"B.Tech\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"SoftGen\",\r\n" + 
			"			\"exp\": \"8-9\",\r\n" + 
			"			\"skills\": \"Mulesoft\",\r\n" + 
			"			\"education\": \"B.Tech,M.Tech\"\r\n" + 
			"		},\r\n" + 
			"		{\r\n" + 
			"			\"nameofcompany\": \"Extentia\",\r\n" + 
			"			\"exp\": \"2-3\",\r\n" + 
			"			\"skills\": \"Python\",\r\n" + 
			"			\"education\": \"B.Tech,M.Tech\"\r\n" + 
			"		}\r\n" + 
			"	]\r\n" + 
			"	\r\n" + 
			"";
	//ClassPathResource cpr=new ClassPathResource("jobdetails.json");
	TypeFactory typeFactory = objectMapper.getTypeFactory();
	 CollectionType collectionType = typeFactory.constructCollectionType(
             List.class, JobRequirement.class);
	jobDetails=objectMapper.readValue( str, collectionType);
	HttpHeaders respHeader=new HttpHeaders();
	ResponseEntity<List<JobRequirement>> reJobDetails=new ResponseEntity<>(jobDetails,respHeader,HttpStatus.OK);
	return reJobDetails ;
}

@GetMapping("/getAllCars")
public List<Car> getAllCars() throws JsonParseException, JsonMappingException, IOException {
	String jsonArray = "[{\"brand\":\"ford\"},"
			+ " {\"brand\":\"Fiat\"}]";

	ObjectMapper objectMapper = new ObjectMapper();
	TypeFactory typeFactory = objectMapper.getTypeFactory();
    CollectionType collectionType = typeFactory.constructCollectionType(
                                        List.class, Car.class);

	List<Car> cars2 = objectMapper.readValue(jsonArray, collectionType);
	return cars2;
}


@PostMapping("/submitJob")
public ResponseEntity<String > submitJobReq(@RequestBody SubmitReq  submitReq){
	System.out.println(submitReq.toString());
	HttpHeaders respHeader=new HttpHeaders();
	ResponseEntity<String> re=new ResponseEntity<String>("Success",respHeader,HttpStatus.OK);
	System.out.println(re);
	return re;
}
}
