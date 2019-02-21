package what.the.bus.admin;

import org.springframework.web.multipart.MultipartFile;

public class AdminVO {
	private int bestcount;
	private MultipartFile uploadBanner;
	private String bannername;
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

	
	
	