create schema if not exists challenge1;
set search_path to challenge1;
CREATE TABLE IF NOT EXISTS videos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    url VARCHAR(255) NOT NULL
);