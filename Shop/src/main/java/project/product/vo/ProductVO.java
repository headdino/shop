package project.product.vo;

//	상품 단건이 가지는 정보
public class ProductVO 
{

	private String pd_code;		//	상품코드
	private String pd_name;		//	상품이름
	private char pd_option;		//	옵션 유무(예시-옵션이 있으면 y 없으면 n)
	private String pd_brand;	//	브랜드이름
	private int pd_score;		//	상품 평점
	private String pd_image;	//	상품 이미지
	
	public ProductVO() {}
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String pd_code, String pd_name, char pd_option, String pd_brand, int pd_score, String pd_image)
	{
		this.pd_code = pd_code;
		this.pd_name = pd_name;
		this.pd_option = pd_option;
		this.pd_brand = pd_brand;
		this.pd_score = pd_score;
		this.pd_image = pd_image;
	}

	public String getPd_code() {
		return pd_code;
	}

	public void setPd_code(String pd_code) {
		this.pd_code = pd_code;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public char getPd_option() {
		return pd_option;
	}

	public void setPd_option(char pd_option) {
		this.pd_option = pd_option;
	}

	public String getPd_brand() {
		return pd_brand;
	}

	public void setPd_brand(String pd_brand) {
		this.pd_brand = pd_brand;
	}

	public int getPd_score() {
		return pd_score;
	}

	public void setPd_score(int pd_score) {
		this.pd_score = pd_score;
	}

	public String getPd_image() {
		return pd_image;
	}

	public void setPd_image(String pd_image) {
		this.pd_image = pd_image;
	}

	@Override
	public String toString() {
		return "ProductVO [pd_code=" + pd_code + ", pd_name=" + pd_name + ", pd_option=" + pd_option + ", pd_brand="
				+ pd_brand + ", pd_score=" + pd_score + ", pd_image=" + pd_image + "]";
	}
	
	

	

	
}
