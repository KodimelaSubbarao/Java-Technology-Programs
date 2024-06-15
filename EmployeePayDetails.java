package com.sa.service;

import com.sa.beans.Employee;

public class EmployeePayDetails 
{
	public void getPaymentDetails(Employee emp)
	{
		double gsal=emp.getEmpSal()+emp.getEmpSal()*0.3;
		double nsal=gsal-(gsal*0.1);
		emp.setGrossSal(gsal);
		emp.setNetSal(nsal);
	}
}
