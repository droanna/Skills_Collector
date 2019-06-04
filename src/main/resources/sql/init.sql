CREATE SCHEMA `skills_collector` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

create table skills (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    );

    create table sources (
       id bigint not null auto_increment,
        description varchar(255),
        name varchar(255) not null,
        primary key (id)
    );

    create table sources_attached_skills (
       source_id bigint not null,
        skill_id bigint not null,
        primary key (source_id, skill_id)
    );

    create table users (
       id bigint not null auto_increment,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    );

    create table users_known_sources (
       user_id bigint not null,
        source_id bigint not null,
        primary key (user_id, source_id)
    );



