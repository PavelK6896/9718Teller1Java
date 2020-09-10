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
values ('1', 'Admin', 'Adminov', '$2y$12$xev0uCmEbGZ4auHkJxmEauyo4wddhir0qatdhObnoCsA9hhlM16J2', 'ADMIN', 'ACTIVE'),
       ('2', 'User', 'Userov', '$2y$12$xev0uCmEbGZ4auHkJxmEauyo4wddhir0qatdhObnoCsA9hhlM16J2', 'USER', 'ACTIVE');






