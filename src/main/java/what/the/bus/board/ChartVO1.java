package what.the.bus.board;

public class ChartVO1 {
	String condition;
	int count;
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ChartVO1 [condition=" + condition + ", count=" + count + ", getCondition()=" + getCondition()
				+ ", getCount()=" + getCount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
