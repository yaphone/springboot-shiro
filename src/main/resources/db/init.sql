/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/7 16:24:34                           */
/*==============================================================*/


drop table if exists tb_permission;

drop table if exists tb_role;

drop table if exists tb_role_permission;

drop table if exists tb_user;

drop table if exists tb_user_role;

/*==============================================================*/
/* Table: tb_permission                                         */
/*==============================================================*/
create table tb_permission
(
   id                   bigint not null,
   permission_id        varchar(32),
   permission_name      varchar(32),
   resource_code        varchar(32),
   resorce_name         varchar(32),
   required_permission  bigint,
   primary key (id)
);

alter table tb_permission comment '权限';

/*==============================================================*/
/* Table: tb_role                                               */
/*==============================================================*/
create table tb_role
(
   id                   bigint not null,
   role_id              varchar(32),
   role_name            varchar(128),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_role_permission                                    */
/*==============================================================*/
create table tb_role_permission
(
   id                   bigint not null,
   role_id              varchar(32),
   permission_id        varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   ID                   bigint not null auto_increment,
   username             varchar(64),
   nickname             varchar(64),
   password             varchar(64),
   salt                 varchar(128),
   primary key (ID)
)
auto_increment = 110000;

/*==============================================================*/
/* Table: tb_user_role                                          */
/*==============================================================*/
create table tb_user_role
(
   id                   bigint not null,
   user_id              bigint,
   role_id              varchar(32),
   primary key (id)
);

