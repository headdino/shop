package project.product.vo;

public class CartVO 
{
	private String pd_code;
	private String id;
	private String seller_id;
	private int count;
	
	public void init(String pd_code, String id, String seller_id, int count) 
	{
		this.pd_code = pd_code;
		this.id = id;
		this.seller_id = seller_id;
		this.count = count;
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
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartVO [pd_code=" + pd_code + ", id=" + id + ", seller_id=" + seller_id + ", count=" + count + "]";
	}
	
	

}
