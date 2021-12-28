create table orders
(
    id           bigserial
        primary key,
    order_number bigint not null
        unique
);


create table ln_order_product
(
    order_id   bigint not null
        constraint fk_order
            references orders,
    product_id bigint not null
        constraint fk_product
            references product,
    constraint pk_ln_order_product
        primary key (order_id, product_id)
);

alter table ln_order_product
    owner to geek_user;

select * from orders;
select * from ln_order_product where order_id=6;

