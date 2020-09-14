create table accounts
(
    id      bigserial,
    bill    bigint not null,
    user_id bigint not null,
    primary key (id),
    constraint fk_user_id foreign key (user_id) references users (id)
);



