CREATE DATABASE spring_db;

USE spring_db;
DROP TABLE cliente;

USE spring_db;
SELECT * FROM clientes;

INSERT INTO clientes (nome, email, preferencia, filiacao) VALUES
("Clara", "clara@mail.com", "Brinquedos", "2021-10-10"),
("Davi", "davi@mail.com", "Jogos", "2022-10-10"),
("Estefane", "estafane@mail.com", "Tecnologia", "2022-10-10");


INSERT INTO filmes (titulo, descricao, estudio, classificacao) VALUES 
('O Senhor dos Anéis', 'Uma trilogia épica de fantasia', 'New Line Cinema', '9'),
('Pulp Fiction', 'Uma obra-prima de Quentin Tarantino', 'Miramax Films', '8'),
('Jurassic Park', 'Dinossauros ganham vida', 'Universal Pictures', '7'),
('Matrix', 'Um clássico de ficção científica', 'Warner Bros.', '10'),
('A Origem', 'Um filme de Christopher Nolan', 'Warner Bros.', '8'),
('Efeito Borboleta', 'Viagem no tempo e suas consequências', 'Universal Pictures', '12');