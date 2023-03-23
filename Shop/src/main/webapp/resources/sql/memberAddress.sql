CREATE TABLE "SSH"."MEMBERADDRESS" 
   (	"ID" VARCHAR2(100 BYTE), 
	"ADDRNAME" VARCHAR2(40 BYTE), 
	"ADDR" VARCHAR2(200 BYTE), 
	"PHONE" VARCHAR2(20 BYTE), 
	"MEMO" VARCHAR2(150 BYTE), 
	"DETAIL_ADDR" VARCHAR2(200 BYTE)
   );
   
drop table memberaddress;
      
delete from MEMBERADDRESS;

 
insert into MEMBERADDRESS (id, ADDRNAME, ADDR, PHONE, MEMO, detail_addr) 
    values ('gildong', '우리집', '은평구 역촌동', '010-9339-3402', '대문앞에 놔주세요', '1층대문');

select * from MEMBERADDRESS;
select count(*) from member;

select * from MEMBERADDRESS where ID='gildong';

commit;