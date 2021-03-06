package what.the.bus.member;

import java.sql.Date;

public class MemberVO {
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
	private int statecount;
	private String c_startdate;// 차트 조회 날짜
	private String c_enddate;// 차트 조회 날짜
	private int point;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getC_startdate() {
		return c_startdate;
	}

	public void setC_startdate(String c_startdate) {
		this.c_startdate = c_startdate;
	}

	public String getC_enddate() {
		return c_enddate;
	}

	public void setC_enddate(String c_enddate) {
		this.c_enddate = c_enddate;
	}

	public int getStatecount() {
		return statecount;
	}

	public void setStatecount(int statecount) {
		this.statecount = statecount;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", tel="
				+ tel + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", email=" + email + ", regdate="
				+ regdate + ", license=" + license + ", statecount=" + statecount + ", c_startdate=" + c_startdate
				+ ", c_enddate=" + c_enddate + "]";
	}

}
