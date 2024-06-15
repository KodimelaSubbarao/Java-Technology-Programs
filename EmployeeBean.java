package com.sa.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeBean implements Serializable
{
	private Integer empno;
	private String ename;
	
	private String ejob;
	private Double esal;
	
	public EmployeeBean() {
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEjob() {
		return ejob;
	}
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}
	public Double getEsal() {
		return esal;
	}
	public void setEsal(Double esal) {
		this.esal = esal;
	}
}
