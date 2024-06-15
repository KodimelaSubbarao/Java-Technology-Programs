package product.user.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean2 implements Serializable
{
	private String uName,pWord,fName,mName,lName,uFather,uMother,uDob,mId,hNo,uVillage,uMandal,uDist,uState;
	private long pHno;
	private int pCode;
	
	public UserBean2() {}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuFather() {
		return uFather;
	}

	public void setuFather(String uFather) {
		this.uFather = uFather;
	}

	public String getuMother() {
		return uMother;
	}

	public void setuMother(String uMother) {
		this.uMother = uMother;
	}

	public String getuDob() {
		return uDob;
	}

	public void setuDob(String uDob) {
		this.uDob = uDob;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String gethNo() {
		return hNo;
	}

	public void sethNo(String hNo) {
		this.hNo = hNo;
	}

	public String getuVillage() {
		return uVillage;
	}

	public void setuVillage(String uVillage) {
		this.uVillage = uVillage;
	}

	public String getuMandal() {
		return uMandal;
	}

	public void setuMandal(String uMandal) {
		this.uMandal = uMandal;
	}

	public String getuDist() {
		return uDist;
	}

	public void setuDist(String uDist) {
		this.uDist = uDist;
	}

	public String getuState() {
		return uState;
	}

	public void setuState(String uState) {
		this.uState = uState;
	}

	public long getpHno() {
		return pHno;
	}

	public void setpHno(long pHno) {
		this.pHno = pHno;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	
}
