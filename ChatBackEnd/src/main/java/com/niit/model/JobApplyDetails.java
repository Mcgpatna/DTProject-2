package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name="jobapplyidseq",sequenceName="jobapply_seq")
public class JobApplyDetails 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobapplyidseq")
	int jobApplyId;
	int jobId;
	String userName;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date applyDate;
	
	

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public int getJobApplyId() {
		return jobApplyId;
	}

	public void setJobApplyId(int jobApplyId) {
		this.jobApplyId = jobApplyId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
