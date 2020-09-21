create table users
(
    id         bigserial    not null,
    email      varchar(250) not null,
    first_name varchar(50)  not null,
    last_name  varchar(100) not null,
    password   varchar(255) not null,
    role       varchar(20)  not null,
    status     varchar(20)  not null,
    primary key (id)
);

insert into users (email, first_name, last_name, password, role, status)
values ('1', 'Admin', 'Adminov', '$2y$12$mZ43YcISK3cCFYwVxrRMD.ZpNPGq8ABR038sLAhvctoQ0LG584UVq', 'ADMIN', 'ACTIVE'),
       ('2', 'User', 'Userov', '$2y$12$mZ43YcISK3cCFYwVxrRMD.ZpNPGq8ABR038sLAhvctoQ0LG584UVq', 'USER', 'ACTIVE');


create table accounts
(
    id      bigserial,
    bill    bigint not null,
    user_id bigint not null,
    primary key (id),
    constraint fk_user_id foreign key (user_id) references users (id)
);

insert into accounts (bill, user_id)
values ('100','1'),
       ('102','1'),
       ('200','2'),
       ('202','2');




