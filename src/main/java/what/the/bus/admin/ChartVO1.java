package what.the.bus.admin;

public class ChartVO1 {
	String date;
	int value;
	public ChartVO1() {
		super();
	
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ChartVO1(String date, int value) {
		super();
		this.date = date;
		this.value = value;
	}
	@Override
	public String toString() {
		return "ChartVO1 [date=" + date + ", value=" + value + "]";
	}
	
	
	
}
