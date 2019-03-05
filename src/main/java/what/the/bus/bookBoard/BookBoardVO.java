package what.the.bus.bookBoard;

import java.sql.Date;

public class BookBoardVO {
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private int best;
	private Date regDate;
	private int cnt;
	private String c_startdate;//차트 조회 날짜
	private String c_enddate;//차트 조회 날짜

	public String getC_startdate() {
		return c_startdate;
	}

	public void setC_startdate(String c_startdate) {
		this.c_startdate = c_startdate;
	}

	public String getC_enddate() {
		return c_enddate;
	}

	public void setC_enddate(String c_enddate) {
		this.c_enddate = c_enddate;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "BookBoardVO [seq=" + seq + ", id=" + id + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", best=" + best + ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}

}
