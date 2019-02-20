package what.the.bus.member;

import java.util.Date;

public class ChartVO2 {
	private Date dateValue;
	private int count;
	public Date getDateValue() {
		return dateValue;
	}
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ChartVO2 [dateValue=" + dateValue + ", count=" + count + "]";
	}
	public ChartVO2(Date dateValue, int count) {
		super();
		this.dateValue = dateValue;
		this.count = count;
	}
	
	
	
}