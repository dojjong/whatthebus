package what.the.bus.board;

import java.sql.Date;

public class BoardVO {
	private int seq;// 글번호
	private String mid;// 글쓴사람 id(pk)
	private String mname;// 글쓴이 이름
	private String title;// 제목
	private String content;// 내용
	private int best;// 추천수
	private Date regDate;// 등록일
	private int cnt;// 조회수

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", mid=" + mid + ", mname=" + mname + ", title=" + title + ", content=" + content
				+ ", best=" + best + ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}

}
