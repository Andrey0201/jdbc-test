-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_store.my_store_id_seq;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.customers
(
    id               integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq'),
    creation_date    date,
    email            text NOT NULL,
    name             text NOT NULL,
    age              int,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS my_store.orders
(
    id               serial,
    customer_id      integer,
    department_id    integer,
    creation_date    date,
    product          text NOT NULL,
    price            int,
    primary key (id),
    foreign key (customer_id) references my_store.customers (id)
);

-- Создание индекса
-- CREATE INDEX IF NOT EXISTS idx_user_status ON my_store.user USING hash (status);
