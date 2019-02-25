package what.the.bus.booking;

import java.sql.Date;

public class BookingPayVO {
	private int seq;
	private int busseq;
	private String id;
	private String name;
	private String tel;
	private String selectpay;
	private int sitnum;
	private int pay;
	private Date regdate;
	private String realregdate;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBusseq() {
		return busseq;
	}
	public void setBusseq(int busseq) {
		this.busseq = busseq;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSelectpay() {
		return selectpay;
	}
	public void setSelectpay(String selectpay) {
		this.selectpay = selectpay;
	}
	public int getSitnum() {
		return sitnum;
	}
	public void setSitnum(int sitnum) {
		this.sitnum = sitnum;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getRealregdate() {
		return realregdate;
	}
	public void setRealregdate(String realregdate) {
		this.realregdate = realregdate;
	}
	@Override
	public String toString() {
		return "BookingPayVO [seq=" + seq + ", busseq=" + busseq + ", id=" + id + ", name=" + name + ", tel=" + tel
				+ ", selectpay=" + selectpay + ", sitnum=" + sitnum + ", pay=" + pay + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
	
	
}