package project.member;

//	회원가입할때 받지 않은 회원정보에 대한 VO
public class MemberAddressVO 
{
	private String id;
	private String addrName;
	private String addr;
	private String detail_addr;
	private String phone;
	private String memo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "MemberAddressVO [id=" + id + ", addrName=" + addrName + ", addr=" + addr + detail_addr + ", phone=" + phone
				+ ", memo=" + memo + "]";
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
		
	

}
