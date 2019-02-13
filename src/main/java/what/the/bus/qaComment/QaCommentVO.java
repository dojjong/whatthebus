package what.the.bus.qaComment;

import java.sql.Date;

public class QaCommentVO {
	private int cno;
	private int seq;
	private String id;
	private String name;
	private String content;
	private Date regdate;
	
	private String realregdate;
	private String searchOption;
	private String keyword;
	
	
	
	
	public String getRealregdate() {
		return realregdate;
	}
	public void setRealregdate(String realregdate) {
		this.realregdate = realregdate;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "QaCommentVO [cno=" + cno + ", seq=" + seq + ", id=" + id + ", name=" + name + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	

}
