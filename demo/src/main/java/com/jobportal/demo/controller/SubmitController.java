package com.jobportal.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.demo.model.SubmitReq;

@RestController
@RequestMapping("/v1")
public class SubmitController {
	@PostMapping("/submitJob")
	public ResponseEntity<String > submitJobReq(@RequestBody SubmitReq  submitReq){
		System.out.println(submitReq);
		HttpHeaders respHeader=new HttpHeaders();
		ResponseEntity<String> re=new ResponseEntity<String>("Success",respHeader,HttpStatus.OK);
		return re;
	}

}
