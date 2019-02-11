package what.the.bus.board;

import java.sql.Date;

public class BoardVO {
	private int seq;
	private String id;
	private String name;
	private String title;
	private String content;
	private int best;
	private Date regDate;
	private int cnt;
	private int cntPerPage;
	private int startIndex;
	private String searchOption;
	private String keyword;
	private int count;
	private String realregdate;
	private String start_wido;
	private String start_kyungdo;
	private String end_wido;
	private String end_kyungdo;
	

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

	public String getRealregdate() {
		return realregdate;
	}

	public void setRealregdate(String realregdate) {
		this.realregdate = realregdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
		return "BoardVO [seq=" + seq + ", id=" + id + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", best=" + best + ", regDate=" + regDate + ", cnt=" + cnt + ", cntPerPage=" + cntPerPage
				+ ", startIndex=" + startIndex + ", searchOption=" + searchOption + ", keyword=" + keyword + ", count="
				+ count + ", realregdate=" + realregdate + ", start_wido=" + start_wido + ", start_kyungdo="
				+ start_kyungdo + ", end_wido=" + end_wido + ", end_kyungdo=" + end_kyungdo + "]";
	}

	

}
