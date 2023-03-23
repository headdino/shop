 CREATE TABLE "SSH"."CART" 
   (	
    "PD_CODE" VARCHAR2(20 BYTE), 
	"ID" VARCHAR2(20 BYTE), 
	"SELLER_ID" VARCHAR2(20 BYTE), 
	"COUNT" NUMBER
   );
   
drop table CART;
      
delete from CART;

delete from cart where pd_code = '0005050703700478' and id = 'q';
 
insert into CART (ID, PD_CODE, SELLER_ID, COUNT) 
    values ('q', '0005050703700478', 'q', 1);

select * from CART;
select count(*) from CART;

select * from CART where pd_code=1;

select count(*) from CART where pd_code = 0005050703700478;

commit;