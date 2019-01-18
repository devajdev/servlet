package com.nt.service;

import com.nt.bo.JobSeekerBO;
import com.nt.dao.JobSeekerDAO;
import com.nt.dao.JobSeekerDAOImpl;
import com.nt.dto.JobSeekerDTO;

public class JobSeekerServiceImpl implements JobSeekerService {

	

	@Override
	public String registerJobSeeker(JobSeekerDTO dto) throws Exception {
		JobSeekerBO bo=null;
		JobSeekerDAO dao=null;
		int count=0;
		//Convert DTO to BO
		bo=new JobSeekerBO();
		bo.setName(dto.getName());
		bo.setAge(dto.getAge());
		bo.setAddress(dto.getAddress());
		bo.setSkill(dto.getSkill());
		bo.setExp(dto.getExp());
		bo.setCtc(dto.getCtc());
		bo.setLocation(dto.getLocation());
		//create DAO class obj
		dao=new  JobSeekerDAOImpl();
		//use DAO
		count=dao.insert(bo);
		if(count==0)		
		   return "registration Failed";
		else
			return "registration Succeded";
	}//method
}//class
