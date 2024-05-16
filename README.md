# Alura Challenge Backend

Este é um projeto desenvolvido para o Alura Challenge Backend. O projeto consiste em uma API REST para gerenciamento de vídeos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- SQL
- Maven

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot com Maven. Aqui estão os principais diretórios e suas funções:

- `src/main/java/br/com/alura/backend/challenge1/AluraChallenge`: Contém o código fonte do projeto.
- `src/main/java/br/com/alura/backend/challenge1/AluraChallenge/controller`: Contém os controladores da API REST.
- `src/main/java/br/com/alura/backend/challenge1/AluraChallenge/service`: Contém os serviços que contêm a lógica de negócios.
- `src/main/java/br/com/alura/backend/challenge1/AluraChallenge/repository`: Contém os repositórios para acesso ao banco de dados.
- `src/main/java/br/com/alura/backend/challenge1/AluraChallenge/dto`: Contém os Data Transfer Objects (DTOs) usados para transferir dados entre camadas.

## Como Executar

Para executar este projeto, você precisará ter o Java e o Maven instalados em seu sistema. Siga estas etapas:

1. Clone o repositório para o seu sistema.
2. Navegue até o diretório do projeto.
3. Execute o comando `mvn spring-boot:run`.

## Endpoints da API

Aqui estão os principais endpoints da API:

- `GET /videos`: Retorna uma lista de todos os vídeos.
- `GET /videos/{id}`: Retorna os detalhes de um vídeo específico.
- `POST /videos`: Cria um novo vídeo.
- `PUT /videos/{id}`: Atualiza um vídeo existente.
- `DELETE /videos/{id}`: Deleta um vídeo existente.

## Contribuição

Contribuições são bem-vindas. Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.