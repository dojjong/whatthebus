package what.the.bus.reply;

import java.sql.Date;

public class ReplyVO {
	private int rno; //댓글 번호
	private int seq; //게시글 번호
	private String id; //댓글작성자아이디
	private String name; //댓글작성자이름
	private String content; //댓글내용
	private Date regdate; //댓글작성일1
	private String realregdate; //댓글작성일2
	private Date updateRegdate; //댓글업데이트일1
	private String updateRealregdate; //댓글업데이트일2
	private String searchOption; // 검색조건
	private String keyword; // 키워드
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	public String getRealregdate() {
		return realregdate;
	}
	public void setRealregdate(String realregdate) {
		this.realregdate = realregdate;
	}
	public Date getUpdateRegdate() {
		return updateRegdate;
	}
	public void setUpdateRegdate(Date updateRegdate) {
		this.updateRegdate = updateRegdate;
	}
	public String getUpdateRealregdate() {
		return updateRealregdate;
	}
	public void setUpdateRealregdate(String updateRealregdate) {
		this.updateRealregdate = updateRealregdate;
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
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", seq=" + seq + ", id=" + id + ", name=" + name + ", content=" + content
				+ ", regdate=" + regdate + ", realregdate=" + realregdate + ", updateRegdate=" + updateRegdate
				+ ", updateRealregdate=" + updateRealregdate + ", searchOption=" + searchOption + ", keyword=" + keyword
				+ "]";
	}
	
	
	
	
}
