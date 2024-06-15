package emp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeBean implements Serializable
{
	private int eid;
	private String ename,ejob;
	private float esal,ehra,eda,etotsal;
	public EmployeeBean() {}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
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
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public float getEhra() {
		return ehra;
	}
	public void setEhra(float ehra) {
		this.ehra = ehra;
	}
	public float getEda() {
		return eda;
	}
	public void setEda(float eda) {
		this.eda = eda;
	}
	public float getEtotsal() {
		return etotsal;
	}
	public void setEtotsal(float etotsal) {
		this.etotsal = etotsal;
	}
	
}
