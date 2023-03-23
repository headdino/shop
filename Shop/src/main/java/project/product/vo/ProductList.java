package project.product.vo;

import java.util.ArrayList;

public class ProductList {
	ArrayList<ProductVO> pdList = new ArrayList<ProductVO>();
	ArrayList<SellerVO> sellerList = new ArrayList<SellerVO>();
	ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
	ArrayList<CartVO> cartList = new ArrayList<CartVO>();
	private int pageSize = 12; 
	private int totalCount = 0; 
	private int totalPage = 0; 
	private int currentPage = 1; 
	private int startNo = 0; 
	private int endNo = 0; 
	private int startPage = 0;
	private int endPage = 0;	
	
	public ProductList() {
	
	}
	

	public void initMvcboardList(int pageSize, int totalCount, int currentPage) 
	{
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		calculator();
	}

	private void calculator() {
		totalPage = (totalCount-1) / pageSize + 1;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
		startNo = (currentPage - 1) * pageSize + 1;
		endNo = startNo + pageSize - 1 > totalCount ? totalCount : startNo + pageSize - 1;
		startPage = ((currentPage - 1) / 10) * 10 + 1 ;
		endPage = startPage + 9 > totalPage ? totalPage : startPage + 9;
	}

	public ArrayList<ProductVO> getPdList() {
		return pdList;
	}
	public void setList(ArrayList<ProductVO> pdList) {
		this.pdList = pdList;
	}
	
	public ArrayList<SellerVO> getSellerList() {
		return sellerList;
	}


	public void setSellerList(ArrayList<SellerVO> sellerList) {
		this.sellerList = sellerList;
	}

	public ArrayList<ReviewVO> getReviewList() {
		return reviewList;
	}


	public void setReviewList(ArrayList<ReviewVO> reviewList) {
		this.reviewList = reviewList;
	}


	public ArrayList<CartVO> getCartList() {
		return cartList;
	}


	public void setCartList(ArrayList<CartVO> cartList) {
		this.cartList = cartList;
	}


	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "ProductList [list=" + pdList + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo + ", endNo=" + endNo + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

}

