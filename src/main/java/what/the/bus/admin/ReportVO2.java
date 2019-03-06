package what.the.bus.admin;

public class ReportVO2 {
	private int num;
	private String title;
	private String name;
	private int bus;
	private int pay;
	private String realstartdate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBus() {
		return bus;
	}
	public void setBus(int bus) {
		this.bus = bus;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getRealstartdate() {
		return realstartdate;
	}
	public void setRealstartdate(String realstartdate) {
		this.realstartdate = realstartdate;
	}
	@Override
	public String toString() {
		return "ReportVO2 [num=" + num + ", title=" + title + ", name=" + name + ", bus=" + bus + ", pay=" + pay
				+ ", realstartdate=" + realstartdate + "]";
	}
	
	
	
}
