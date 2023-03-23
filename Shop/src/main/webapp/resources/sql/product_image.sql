  CREATE TABLE "SSH"."PRODUCT_IMAGE" 
   (	
    "PD_CODE" VARCHAR2(20 BYTE), 
	"ID" VARCHAR2(20 BYTE), 
	"IMG1" VARCHAR2(500 BYTE), 
	"IMG2" VARCHAR2(500 BYTE), 
	"IMG3" VARCHAR2(500 BYTE), 
	"IMG4" VARCHAR2(500 BYTE), 
	"DETAILIMG" VARCHAR2(500 BYTE)
   );
   
drop table PRODUCT_IMAGE;
      
delete from PRODUCT_IMAGE;

 
insert into PRODUCT_IMAGE (PD_CODE, ID, IMG1, IMG2, IMG3, IMG4, DETAILIMG) 
    values ('1', 'q', 'https://lh3.google.com/u/0/d/1oEXWJ9Rz_em1ex2jTkx_2pJlCCCocmNg=w1182-h902-iv1', '이미지링크2', '이미지링크3', '이미지링크4', '상세페이지');

select * from PRODUCT_IMAGE;
select count(*) from PRODUCT_IMAGE;

select * from PRODUCT_IMAGE where pd_code=1;

commit;