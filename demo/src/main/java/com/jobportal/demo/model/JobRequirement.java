package com.jobportal.demo.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class JobRequirement {
	String nameofcompany;
	String exp;
	String skills;
	String education;
	public String getNameofcompany() {
		return nameofcompany;
	}
	public void setNameofcompany(String nameofcompany) {
		this.nameofcompany = nameofcompany;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	
}
