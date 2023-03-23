package project.product.vo;

//	상품 단건이 가지는 정보중 카테고리정보
public class ProductCodeVO 
{

	private String pd_code;			//	상품코드
	private String category;		//	카테고리
	
	public ProductCodeVO() {}
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String pd_code, String category)
	{
		this.pd_code = pd_code;
		this.category = category;
	}

	public String getPd_code() {
		return pd_code;
	}

	public void setPd_code(String pd_code) {
		this.pd_code = pd_code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductCodeVO [pd_code=" + pd_code + ", category=" + category + "]";
	}

	

	
}
