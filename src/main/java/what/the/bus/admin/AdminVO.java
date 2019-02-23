package what.the.bus.admin;

import org.springframework.web.multipart.MultipartFile;

public class AdminVO {
	private int bestcount;
	private MultipartFile uploadBanner;
	private String bannername;
	private String searchOption;
	private String keyword;

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

	public int getBestcount() {
		return bestcount;
	}

	public void setBestcount(int bestcount) {
		this.bestcount = bestcount;
	}

	public MultipartFile getUploadBanner() {
		return uploadBanner;
	}

	public void setUploadBanner(MultipartFile uploadBanner) {
		this.uploadBanner = uploadBanner;
	}

	public String getBannername() {
		return bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

	@Override
	public String toString() {
		return "AdminVO [bestcount=" + bestcount + ", uploadBanner=" + uploadBanner + ", bannername=" + bannername
				+ "]";
	}

}
