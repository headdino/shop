package project.member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO 
{

	private String id;
	private String password;
	private String nickname;
	private String name;
	private String email;
	private Date signdate;
	private String sSigndate;
	private char grade;
	private String renamingGrade;
	
	public MemberVO() {}
	
	public MemberVO(String id, String password, String nickname, String name, String email) 
	{
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
	}
	
//	기본생성자로 생성된 VObean을 초기화해주기 위해서 사용되는 메소드
	public void init(String id, String pss, String nick, String name, String email) 
	{
		this.id = id;
		this.password = pss;
		this.nickname = nick;
		this.name = name;
		this.email = email;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getNickname() 
	{
		return nickname;
	}
	
	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getSigndate() 
	{
		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		if (signdate != null)
		{
			sSigndate = dateFomatter.format(signdate.getTime());
		}
		 
		
		return sSigndate;
	}
	
	public void setSigndate(Date signdate) 
	{
		this.signdate = signdate;
	}
	
	public String getGrade() 
	{
		switch(grade)
		{
			case 'n':
				renamingGrade = "일반회원";
				break;
			case 'a':
				renamingGrade = "관리자";
				break;
			case 's':
				renamingGrade = "판매자";
				break;
		}
		return renamingGrade;
	}
	
	public void setGrade(char grade) 
	{
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", nickname=" + nickname + ", name=" + name
				+ ", email=" + email + ", signdate=" + signdate + ", grade=" + grade + "]";
	}

	
}
