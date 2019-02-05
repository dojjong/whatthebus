package what.the.bus.comment;

import java.sql.Date;

public class CommentVO {
	private int cno;
	private int seq;
	private String id;
	private String name;
	private String content;
	private Date regdate;
	private String realregdate;
	
	public String getRealregdate() {
		return realregdate;
	}

	public void setRealregdate(String realregdate) {
		this.realregdate = realregdate;
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
		return "CommentVO [cno=" + cno + ", seq=" + seq + ", id=" + id + ", name=" + name + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}

}
