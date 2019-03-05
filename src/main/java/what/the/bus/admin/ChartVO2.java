package what.the.bus.admin;

import java.util.Date;

public class ChartVO2 {
	private Date date;
	private int value;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public ChartVO2(Date date) {
		super();
		this.date = date;
	}
	public ChartVO2(Date date, int value) {
		super();
		this.date = date;
		this.value = value;
	}
	public ChartVO2(int value) {
		super();
		this.value = value;
	}
	
	
	
}