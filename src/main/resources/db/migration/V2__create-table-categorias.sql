create table if not exists categorias (
    id serial primary key,
    titulo varchar(255) not null,
    cor varchar(10) not null
);