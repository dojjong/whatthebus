package what.the.bus.member;

public class DriverVO {
	private String did;
	private String dpassword;
	private String dname;
	private String dgender;
	private String dtel;
	private String demail;
	private String dlicense;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDpassword() {
		return dpassword;
	}

	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDgender() {
		return dgender;
	}

	public void setDgender(String dgender) {
		this.dgender = dgender;
	}

	public String getDtel() {
		return dtel;
	}

	public void setDtel(String dtel) {
		this.dtel = dtel;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getDlicense() {
		return dlicense;
	}

	public void setDlicense(String dlicense) {
		this.dlicense = dlicense;
	}

	@Override
	public String toString() {
		return "DriverVO [did=" + did + ", dpassword=" + dpassword + ", dname=" + dname + ", dgender=" + dgender
				+ ", dtel=" + dtel + ", demail=" + demail + ", dlicense=" + dlicense + "]";
	}

}
