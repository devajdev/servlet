package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class EmployeePayslipServiceImpl implements EmployeePaySlipService {

	@Override
	public void generatePayslip(EmployeeDTO dto) {
		float grossSalary=0.0f,netSalary=0.0f;
		//calculate Gross salary
		grossSalary=dto.getSalary()+(dto.getSalary()* 0.4f);
		//calculate Net salary
		netSalary=grossSalary-(grossSalary*0.2f);
		//set results to DTO
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
	}

}
