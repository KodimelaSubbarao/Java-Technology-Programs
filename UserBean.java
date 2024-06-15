package user;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable
{
private String mailId,fName,mName,lName,fullName,fatherName,uName,pWord,address;
private long phNo,aPhNo;

public UserBean() {}

public String getMailId() {
	return mailId;
}

public void setMailId(String mailId) {
	this.mailId = mailId;
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

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public long getPhNo() {
	return phNo;
}

public void setPhNo(long phNo) {
	this.phNo = phNo;
}

public long getaPhNo() {
	return aPhNo;
}

public void setaPhNo(long aPhNo) {
	this.aPhNo = aPhNo;
}

}
