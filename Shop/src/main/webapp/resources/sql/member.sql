  CREATE TABLE "MEMBER" 
   (	
    "ID" VARCHAR2(100 BYTE) NOT NULL, 
	"PASSWORD" VARCHAR2(100 BYTE) NOT NULL, 
	"EMAIL" VARCHAR2(100 BYTE) NOT NULL, 
	"NAME" VARCHAR2(20 BYTE) NOT NULL, 
	"NICKNAME" VARCHAR2(50 BYTE), 
	"SIGNDATE" DATE DEFAULT sysdate NOT NULL, 
	"GRADE" CHAR(1 BYTE) DEFAULT 'n' NOT NULL, 
	 CONSTRAINT "TABLE1_PK" PRIMARY KEY ("ID")
   );
   
   
delete from member;
drop sequence member_id_seq;
create sequence member_id_seq;   
insert into member (id, password, nickname, email, grade, name) 
    values ('gildong', '1111', '길동', 'gildong@naver.com', 'n', '홍길동');

select * from member order by id desc;
select count(*) from member;

select ID from member where email='headdino@naver.com';


update member set grade = 's' where id = 'q'; 
update member set grade = 's' where id = 'w'; 
update member set grade = 'a' where id = 'gildong'; 

commit;