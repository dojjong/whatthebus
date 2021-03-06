package what.the.bus.driver;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class DriverVO {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String tel;
	private String tel1;
	private String tel2;
	private String tel3;
	private String email;
	private Date regdate;
	private String license;
	private MultipartFile uploadFile;
	private int statecount;
	private int point;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getStatecount() {
		return statecount;
	}

	public void setStatecount(int statecount) {
		this.statecount = statecount;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DriverVO [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", tel="
				+ tel + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", email=" + email + ", regdate="
				+ regdate + ", license=" + license + ", uploadFile=" + uploadFile + ", statecount=" + statecount
				+ ", point=" + point + "]";
	}

}
