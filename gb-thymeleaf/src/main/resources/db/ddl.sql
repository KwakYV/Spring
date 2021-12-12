CREATE TABLE HW8.PRODUCT
(
    ID                 BIGSERIAL      NOT NULL PRIMARY KEY,
    TITLE              VARCHAR(255)   NOT NULL,
    COST               DECIMAL(10, 2) NOT NULL,
    MANUFACTURE_DATE   DATE           NOT NULL,
    VERSION            INT            NOT NULL DEFAULT 0,
    CREATED_BY         VARCHAR(255),
    CREATED_DATE       TIMESTAMP,
    LAST_MODIFIED_BY   VARCHAR(255),
    LAST_MODIFIED_DATE TIMESTAMP,
    STATUS             VARCHAR(20)    NOT NULL DEFAULT 'ACTIVE',

    UNIQUE (TITLE)
);

create table hw8.cart(
   id bigserial not null primary key ,
   cart_number bigint not null
);
alter table hw8.cart owner to geek_user;

create table hw8.ln_cart_product(
    cart_id bigint not null constraint fk_cart references hw8.cart,
    product_id bigint not null constraint fk_product references hw8.product,
    quantity bigint not null,

    constraint pk_ln_cart_product primary key (cart_id, product_id)

);
alter table hw8.ln_cart_product owner to geek_user;



SELECT * FROM hw8.product;
select * from hw8.cart;
select * from hw8.ln_cart_product;
