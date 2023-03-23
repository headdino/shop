  CREATE TABLE "SSH"."PRODUCT" 
   (	
    "PD_CODE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"PD_NAME" VARCHAR2(130 BYTE), 
	"PD_OPTION" CHAR(1 BYTE) DEFAULT 'n' NOT NULL ENABLE, 
	"PD_BRAND" VARCHAR2(50 BYTE), 
	"PD_SCORE" NUMBER, 
    "PD_IMAGE" VARCHAR2(500 BYTE),
	 CONSTRAINT "PRODUCT_PK" PRIMARY KEY ("PD_CODE")
   );
   
   
drop table product;
      
delete from product;

 
insert into product (pd_code, pd_name, pd_option, pd_brand, pd_score, pd_image) 
    values ('1', '캣타워', 'n', '잿투샵', 5, 'https://thumbnail7.coupangcdn.com/thumbnails/remote/492x492ex/image/vendor_inventory/7f4c/92070cfee07cf445a13a90228988a82d8dc91ab353d90b00719a73df545c.jpeg');

select * from product;
select count(*) from product;

select * from product where pd_name='캣타워';


update product set pd_score = 7 where pd_code = '0005050703700478'; 

update product set pd_score = 8 where pd_code ='0000000275770744';
update product set pd_score = 9 where pd_code ='0000001026247838';
update product set pd_score = 3 where pd_code ='0000002246047655';
update product set pd_score = 6 where pd_code ='0001010333885762';
update product set pd_score = 6 where pd_code ='0001011343850410';
update product set pd_score = 1 where pd_code ='0001012534203111';

update product set pd_score = 5 where pd_code ='0201010560558147';

commit;