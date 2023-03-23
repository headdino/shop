package project.product.vo;

//	옵션으로 묶이는 상품이 가지는 정보와 같이 묶이는 상품코드정보(메인만)
public class OptionVO 
{

	private String main_pd_code;	//	옵션의 메인 상품코드
	private String pd_code;		//	상품코드
	private String option_name;	//	옵션이름(대, 중, 소, 빨강, 파랑 등)
	private int price;			//	옵션 추가비용(예시-메인이 중, 해당 vo가 대면 추가비용 1000)
	
	public OptionVO() {}
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String main_pd_code, String pd_code, String option_name, int price) 
	{
		this.main_pd_code = main_pd_code;
		this.pd_code = pd_code;
		this.option_name = option_name;
		this.price = price;
	}

	public String getMain_pd_code() {
		return main_pd_code;
	}

	public void setMain_pd_code(String main_pd_code) {
		this.main_pd_code = main_pd_code;
	}

	public String getPd_code() {
		return pd_code;
	}

	public void setPd_code(String pd_code) {
		this.pd_code = pd_code;
	}

	public String getOption_name() {
		return option_name;
	}

	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OptionVO [main_pd_code=" + main_pd_code + ", pd_code=" + pd_code + ", option_name=" + option_name
				+ ", price=" + price + "]";
	}
	

	
}
