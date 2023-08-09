create table child
(
    id      bigint generated by default as identity
        primary key,
    name    text,
    surname text
);

alter table child
    owner to postgres;

create table section_chief
(
    id      bigint not null
        constraint school_pkey
            primary key,
    name    text,
    surname text
);

alter table section_chief
    owner to postgres;

create table section
(
    id               bigint not null
        primary key,
    name             text,
    section_chief_id bigint generated always as identity
        constraint school_id
            references section_chief
);

alter table section
    owner to postgres;

create table child_section
(
    child_id   bigint not null
        constraint child_id
            references child,
    section_id bigint
        constraint section_id
            references section
);

alter table child_section
    owner to postgres;

