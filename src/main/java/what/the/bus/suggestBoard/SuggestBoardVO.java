package what.the.bus.suggestBoard;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SuggestBoardVO {
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private int best;
	private Date regDate;
	private int cnt;
	private String start_wido;
	private String start_kyungdo;
	private String end_wido;
	private String end_kyungdo;

	@JsonIgnore
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@JsonIgnore
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonIgnore
	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}

	@JsonIgnore
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@JsonIgnore
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getStart_wido() {
		return start_wido;
	}

	public void setStart_wido(String start_wido) {
		this.start_wido = start_wido;
	}

	public String getStart_kyungdo() {
		return start_kyungdo;
	}

	public void setStart_kyungdo(String start_kyungdo) {
		this.start_kyungdo = start_kyungdo;
	}

	
	public String getEnd_wido() {
		return end_wido;
	}

	public void setEnd_wido(String end_wido) {
		this.end_wido = end_wido;
	}

	public String getEnd_kyungdo() {
		return end_kyungdo;
	}
	
	public void setEnd_kyungdo(String end_kyungdo) {
		this.end_kyungdo = end_kyungdo;
	}

	@Override
	public String toString() {
		return "SuggestBoardVO [seq=" + seq + ", id=" + id + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", best=" + best + ", regDate=" + regDate + ", cnt=" + cnt + ", start_wido=" + start_wido + ", start_kyungdo=" + start_kyungdo 
				+ ", end_wido=" + end_wido + ", end_kyungdo=" + end_kyungdo 
				+ "]";
	}
}