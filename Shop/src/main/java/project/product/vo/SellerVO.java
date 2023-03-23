package project.product.vo;

//	판매자마다 다르게 설정한 상품 한건의 정보
public class SellerVO 
{
	private String pd_code;				//	상품 코드
	private String id;					//	판매자 id => 해당 id로 멤버중에서 찾아 nickname을 표기해줄거다.
	private int price;					//	상품의 가격
	private int delivery_charge;		//	배송비
	private String delivery_company;	//	택배회사이름
	private int stock;					//	재고 수 => 0이 되면 품절
	private int sale_count;				//	판매된 횟수
	private int rank_score;		//	랭킹점수 => 판매된 횟수 + ((상품평점 - 5) * 해당 평점 수) => 기본적으로 랭킹 점수순으로 정렬
	
	
	public SellerVO() {}
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String pd_code, String id, int price, int delivery_charge, String delivery_company,
			int stock, int sale_count, int rank_score) 
	{
		this.pd_code = pd_code;
		this.id = id;
		this.price = price;
		this.delivery_charge = delivery_charge;
		this.delivery_company = delivery_company;
		this.stock = stock;
		this.sale_count = sale_count;
		this.rank_score = rank_score;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDelivery_charge() {
		return delivery_charge;
	}

	public void setDelivery_charge(int delivery_charge) {
		this.delivery_charge = delivery_charge;
	}

	public String getDelivery_company() {
		return delivery_company;
	}

	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	public int getRank_score() {
		return rank_score;
	}

	public void setRank_score(int rank_score) {
		this.rank_score = rank_score;
	}

	@Override
	public String toString() {
		return "SellerVO [pd_code=" + pd_code + ", id=" + id + ", price=" + price + ", delivery_charge="
				+ delivery_charge + ", delivery_company=" + delivery_company + ", stock=" + stock + ", sale_count="
				+ sale_count + ", rank_score=" + rank_score + "]";
	}
	
	
	

}
