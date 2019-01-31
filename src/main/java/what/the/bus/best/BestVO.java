package what.the.bus.best;

public class BestVO {
	private int bestno;
	private int seq;
	private String id;
	private int bestCheck;
	@Override
	public String toString() {
		return "BestVO [bestno=" + bestno + ", seq=" + seq + ", id=" + id + ", bestCheck=" + bestCheck + "]";
	}
	public int getBestno() {
		return bestno;
	}
	public void setBestno(int bestno) {
		this.bestno = bestno;
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
	public int getBestCheck() {
		return bestCheck;
	}
	public void setBestCheck(int bestCheck) {
		this.bestCheck = bestCheck;
	}
}
