package project.member;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberDAO 
{

//	id값으로 DB에서 유저를 찾아내서 VO객체로 반환해주는 용도
	MemberVO mbSearch(String userID);
//	vo객체를 이용해 DB안에 insert 해주는 용도
	void mbInsert(MemberVO vo);
//	email String 값을 이용해 DB안에 ID값을 반환하는 함수
	ArrayList<String> findID(String email);
//	id값으로 DB에서 유저를 찾아내서 MemberAddressVO객체를 담은 ArrayList로 반환해주는 용도
	ArrayList<MemberAddressVO> addrSearch(String id);
//	DB에 주소록을 추가
	void saveAddress(MemberAddressVO vo);
//	DB에 주소록을 삭제
	void deleteAddress(MemberAddressVO vo);
//	해당 멤버의 정보를 변경
	void mbUpdate(MemberVO vo);
//	주소정보를 DB에서 업데이트 해주는 용도
	void updateAddress(HashMap<String, String> hmap);

}
