package product.user.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable
{
	private String uName,pWord,fName,lName,mId,uAddr;
	private long pHno;
	public UserBean() {}

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

	public String getuAddr() {
		return uAddr;
	}

	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}

	public long getpHno() {
		return pHno;
	}

	public void setpHno(long pHno) {
		this.pHno = pHno;
	}
	
}
