-- V1__create_pizza_table.sql

CREATE TABLE IF NOT EXISTS Pizza (
                                     id bigint not null auto_increment,
                                     nome VARCHAR(255) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    disponivel BOOLEAN NOT NULL,
    pizza_tamanho VARCHAR(50) NOT NULL,
    pizza_sabor VARCHAR(50) NOT NULL,

    primary Key(id)
    );