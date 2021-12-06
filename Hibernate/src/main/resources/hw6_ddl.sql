
create table "order"
(
    id           bigserial
        primary key,
    order_number bigint not null
        unique,
    customer_id  bigint not null
        constraint fk_customer
            references customer
);

alter table "order"
    owner to geek_user;


create table customer
(
    id   bigserial
        primary key,
    name varchar(256) not null
);

alter table customer
    owner to geek_user;

create table product
(
    id   bigserial
        primary key,
    name varchar(256)   not null
        unique,
    cost numeric(10, 2) not null
);

alter table product
    owner to geek_user;

create table ln_order_product
(
    order_id   bigint not null
        constraint fk_order
            references "order",
    product_id bigint not null
        constraint fk_product
            references product,
    constraint pk_ln_order_product
        primary key (order_id, product_id)
);

alter table ln_order_product
    owner to geek_user;
