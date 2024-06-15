package product.user;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBeans implements Serializable
{
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
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getpHno() {
		return pHno;
	}
	public void setpHno(long pHno) {
		this.pHno = pHno;
	}
	private String uName,pWord,fName,lName,mId,addr;
	private long pHno;
	public UserBeans() {}
}
