-- auto-generated definition
create table bed
(
    b_id    int auto_increment comment '编号id'
        primary key,
    b_type  varchar(30)   not null comment '床位类型',
    b_price decimal(5, 2) not null comment '床位价格'
)ENGINE = InnoDb
comment '床位';

create table custom
(
    c_id        int auto_increment comment '客户自动编号'
        primary key,
    c_name      varchar(255) null comment '客户姓名',
    c_nick_name varchar(255) null comment '客户昵称',
    c_pwd       varchar(255) not null comment '密码',
    c_phone     varchar(15)  not null comment '客户联系方式',
    c_email     varchar(255) null comment '邮箱地址'
)engine=InnoDb comment '客户';

create table custom_address
(
    ca_id      int auto_increment comment '收货地址编号'
        primary key,
    ca_name    varchar(255) not null comment '收件人姓名',
    ca_phone   varchar(14)  not null comment '联系电话',
    ca_address varchar(255) not null comment '详细地址',
    c_id       int          not null comment '客户id'
)engine=InnoDb comment'';
