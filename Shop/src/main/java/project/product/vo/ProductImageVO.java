package project.product.vo;

public class ProductImageVO 
{

	private String pd_code;		//	상품코드
	private String id;			//	판매자 아이디
	private String img1;		//	이미지1
	private String img2;		//	이미지2...
	private String img3;
	private String img4;
	private String detailimg;	//	상세페이지
	
	public ProductImageVO() {}
	
	
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String pd_code, String id, String img1, String img2, String img3, String img4,
			String detailimg) 
	{
		this.pd_code = pd_code;
		this.id = id;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.detailimg = detailimg;
	}



	public String getPd_code() {
		return pd_code;
	}



	public void setPd_code(String pd_code) {
		this.pd_code = pd_code;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getImg1() {
		return img1;
	}



	public void setImg1(String img1) {
		this.img1 = img1;
	}



	public String getImg2() {
		return img2;
	}



	public void setImg2(String img2) {
		this.img2 = img2;
	}



	public String getImg3() {
		return img3;
	}



	public void setImg3(String img3) {
		this.img3 = img3;
	}



	public String getImg4() {
		return img4;
	}



	public void setImg4(String img4) {
		this.img4 = img4;
	}



	public String getDetailimg() {
		return detailimg;
	}



	public void setDetailimg(String detailimg) {
		this.detailimg = detailimg;
	}



	@Override
	public String toString() {
		return "ProductImageVO [pd_code=" + pd_code + ", id=" + id + ", img1=" + img1 + ", img2=" + img2 + ", img3="
				+ img3 + ", img4=" + img4 + ", detailimg=" + detailimg + "]";
	}
	
	



	
}
