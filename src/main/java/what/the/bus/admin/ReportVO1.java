package what.the.bus.admin;

public class ReportVO1 {

	private int rank;
	private String drivername;
	private String avg;
	private int count;
	private String grade;
	
	@Override
	public String toString() {
		return "ReportVO1 [rank=" + rank + ", drivername=" + drivername + ", avg=" + avg + ", count=" + count
				+ ", grade=" + grade + "]";
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
