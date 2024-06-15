package com.sa.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable
{
	private int empId;
	private String empName;
	private String empAddr;
	private double empSal;
	private double grossSal;
	private double netSal;
	
	public Employee()
	{
		System.out.println("Employee.Employee()");
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public double getGrossSal() {
		return grossSal;
	}

	public void setGrossSal(double grossSal) {
		this.grossSal = grossSal;
	}

	public double getNetSal() {
		return netSal;
	}

	public void setNetSal(double netSal) {
		this.netSal = netSal;
	}
	
	
}
