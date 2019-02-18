package what.the.bus.admin;

public class AdminVO {
	private int bestcount;

	public int getBestcount() {
		return bestcount;
	}

	public void setBestcount(int bestcount) {
		this.bestcount = bestcount;
	}

	@Override
	public String toString() {
		return "AdminVO [bestcount=" + bestcount + ", getBestcount()=" + getBestcount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
