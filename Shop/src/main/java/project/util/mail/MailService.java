package project.util.mail;

import java.util.ArrayList;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import project.controller.Shop.HomeController;

@Component
public class MailService 
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private JavaMailSenderImpl mailSender;
	private int authNumber; 
	// 난수 발생
	
	public void makeRandomNumber()
	{
		// 난수의 범위 111111 ~ 999999 (6자리 난수)
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		logger.info("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
		
		
	//이메일 보낼 양식! 
	public String joinEmail(String email) 
	{
		makeRandomNumber();
		String setFrom = "headdino2@gmail.com"; // email-config에 설정한 자신의 이메일 주소를 입력 
		String toMail = email;
		String title = "회원 가입 인증 이메일 입니다."; // 이메일 제목 
		String content = 
				"<h1>" + "프리미엄 쇼핑몰 잿투샵입니다." + "</h1>" + 	//html 형식으로 작성 ! 
                "<br><br><br>" + 
			    "인증 번호는 " + "<h3>" + authNumber + "</h3>" + "입니다." + 
			    "<br>" + 
			    "해당 인증번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNumber);
	}
		
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) 
	{ 
		MimeMessage message = mailSender.createMimeMessage();
		// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
		try 
		{
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			logger.info("보내는 이메일 주소: " + setFrom);
			// true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
			helper.setText(content,true);
			mailSender.send(message);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}


//	id나 비밀번호 찾기로 얻은 값을 메일로 보내주는 함수
	public void findEmail(String email, ArrayList<String> findList) 
	{
		String info = "";
		for(String str : findList)
		{
			info += str;
			if(!str.equals(findList.get(findList.size() - 1)))
			{
				info += ", ";
			}
		}
		
		
		String setFrom = "headdino2@gmail.com"; // email-config에 설정한 자신의 이메일 주소를 입력 
		String toMail = email;
		String title = "회원 정보 찾기 이메일 입니다."; // 이메일 제목 
		String content = 
				"<h1>" + "프리미엄 쇼핑몰 잿투샵입니다." + "</h1>" + 	//html 형식으로 작성 ! 
                "<br><br><br>" + 
			    "요청하신 정보는 " + "<h3>" + info + "</h3>" + "입니다." + 
			    "<br>" + 
			    "감사합니다."; //이메일 내용 삽입
		mailSend(setFrom, toMail, title, content);
	}
	

}
