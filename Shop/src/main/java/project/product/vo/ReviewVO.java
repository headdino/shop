package project.product.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//	상품평VO
public class ReviewVO 
{
	private String id;			//	리뷰를 남긴 아이디
	private String pd_code;		//	리뷰를 남긴 상품코드
	private int score;			//	평점(0~10) 최대 별 5개
	private String reviews;		//	리뷰내용
	private String seller_id;	//	리뷰를 남긴 상품의 판매자
	private Date write_date;	//	리뷰를 남긴 날짜
	private String sWrite_date;
	
	public ReviewVO() {}
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String id, String pd_code, int score, String reviews, String seller_id) 
	{
		this.id = id;
		this.pd_code = pd_code;
		this.score = score;
		this.reviews = reviews;
		this.seller_id = seller_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPd_code() {
		return pd_code;
	}

	public void setPd_code(String pd_code) {
		this.pd_code = pd_code;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getWrite_date() {
		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		if (write_date != null)
		{
			sWrite_date = dateFomatter.format(write_date.getTime());
		}
		 
		
		return sWrite_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "ReviewVO [id=" + id + ", pd_code=" + pd_code + ", score=" + score + ", reviews=" + reviews
				+ ", seller_id=" + seller_id + ", WRITE_DATE=" + sWrite_date + "]";
	}

	
}
