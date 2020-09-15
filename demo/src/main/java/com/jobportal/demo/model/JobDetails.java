package com.jobportal.demo.model;


import java.util.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobDetails{
	List<JobRequirement> jobrequirement;
}