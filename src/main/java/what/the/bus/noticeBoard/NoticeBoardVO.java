package what.the.bus.noticeBoard;

import java.sql.Date;

public class NoticeBoardVO {
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private Date regdate;
	private int cnt;
	
	private int cntPerPage;
	private int startIndex;
	private String searchOption;
	private String keyword;
	private int count;
	private String realregdate;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getRealregdate() {
		return realregdate;
	}
	public void setRealregdate(String realregdate) {
		this.realregdate = realregdate;
	}
	@Override
	public String toString() {
		return "NoticeBoardVO [seq=" + seq + ", id=" + id + ", name=" + name + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", cnt=" + cnt + ", cntPerPage=" + cntPerPage + ", startIndex="
				+ startIndex + ", searchOption=" + searchOption + ", keyword=" + keyword + ", count=" + count
				+ ", realregdate=" + realregdate + "]";
	}
	
	
	
}
