package what.the.bus.review;

import java.sql.Date;

public class ReviewVO {

	private int seq;
	private int busseq;
	private String id;
	private String name;
	private String content;
	private int star;
	private Date regdate;
	private String driverid;
	private String drivername;
	private String c_startdate;//차트 조회 날짜
	private String c_enddate;//차트 조회 날짜
	

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

	public String getDriverid() {
		return driverid;
	}

	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getBusseq() {
		return busseq;
	}

	public void setBusseq(int busseq) {
		this.busseq = busseq;
	}

	@Override
	public String toString() {
		return "ReviewVO [seq=" + seq + ", busseq=" + busseq + ", id=" + id + ", name=" + name + ", content=" + content
				+ ", star=" + star + ", regdate=" + regdate + ", driverid=" + driverid + ", drivername=" + drivername
				+ "]";
	}

}
