alter table comercial.public.product_offer add column id_product_offer int4; 
alter table comercial.public.product_offer add column id_product int4; 
update product_offer set  id_product_offer = "idProductOffer", id_product = "idProduct" 
alter table comercial.public.product_offer drop column "idProduct";
alter table comercial.public.product_offer drop column "idProductOffer";

ALTER TABLE public.product_offer ADD PRIMARY KEY (id_product_offer) ;
create sequence id_product_offer_seq  start with 1  increment by 1  maxvalue 99999  minvalue 1;
ALTER TABLE public.product_offer alter column id_product_offer SET DEFAULT NEXTVAL('id_product_offer_seq') ;


alter table public.products add column id_product int4; 
update products set id_product = "idProduct";

ALTER TABLE public.order_detail  DROP CONSTRAINT order_detail_id_product_fkey
alter table public.products drop column "idProduct";

ALTER TABLE public.products ADD PRIMARY KEY (id_product) ;
create sequence id_product_seq  start with 1  increment by 1  maxvalue 99999  minvalue 1;
ALTER TABLE public.products alter column id_product SET DEFAULT NEXTVAL('id_product_seq') ;

alter table order_detail add CONSTRAINT order_detail_id_product_fkey FOREIGN KEY (id_product)
      REFERENCES public.products (id_product) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
      
CREATE OR REPLACE VIEW public.view_products AS 
 SELECT ps.id_product,
    ps.name,
    ps.description,
    ps.code,
    ps.id_color,
    ps.price,
    ps.stock,
    ps.measure,
    ps.id_category,
    ps.status,
    ps.id_image,
    ps.created_at,
    ps.updated_at,
    ps.material,
    ps.finish,
    ps.id_purpose,
    ps.size,
    ps.item_box,
    ps.kg_meter,
    ps.id_enviroment,
    ps.price_sample,
    ps.name_clean
   FROM ( SELECT products.id_product,
            products.name,
            products.description,
            products.code,
            products.id_color,
            products.price,
            products.stock,
            products.measure,
            products.id_category,
            products.status,
            products.id_image,
            products.created_at,
            products.updated_at,
            products.material,
            products.finish,
            products.id_purpose,
            products.size,
            products.item_box,
            products.kg_meter,
            products.id_enviroment,
            products.price_sample,
            translate(products.name::text, 'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ'::text, 'aeiouAEIOUaeiouAEIOUNN'::text) AS name_clean
           FROM products) ps;

ALTER TABLE public.view_products
  OWNER TO postgres;


-- Table: public.relationated_product

-- DROP TABLE public.relationated_product;

alter TABLE public.relationated_product add column id_relationated_product int4; 
alter TABLE public.relationated_product add column id_product int4; 
alter TABLE public.relationated_product add column id_product_relation int4; 

update public.relationated_product set id_relationated_product = "idRelationatedProduct", id_product =   "idProduct" , id_product_relation =  "idProductRelation";

ALTER TABLE public.relationated_product  DROP CONSTRAINT relationated_product_pkey

alter table public.relationated_product drop column "idRelationatedProduct";
alter table public.relationated_product drop column "idProduct";
alter table public.relationated_product drop column "idProductRelation";

ALTER TABLE public.relationated_product ADD PRIMARY KEY (id_relationated_product) ;
create sequence id_relationated_product_seq  start with 1  increment by 1  maxvalue 99999  minvalue 1;
ALTER TABLE public.relationated_product alter column id_relationated_product SET DEFAULT NEXTVAL('id_relationated_product_seq') ;






select * from relationated_product

select * from offer
select * from products