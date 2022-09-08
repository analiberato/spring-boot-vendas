# Back End para aplicação de vendas com Spring Boot
Esse projeto foi feito com o objetivo de ser um Back End para uma aplicação de vendas com clientes, produtos e pedidos. Foi utilizado Java e Spring Boot, com Maven como gerenciador de dependências e SQL Server para o banco de dados.

## Estrutura e execução do projeto

#### Pré requisitos
Para rodar este projeto você precisa:
- Java
- Maven
- SQLServer
- Docker (Opcional)

#### Endpoints da aplicação:

http://localhost:8080/produtos -> Exporta os produtos já cadastrados na inicialização do sistema para o aplicativo mobile via API Rest;</br>
http://localhost:8080/clientes -> Exporta os clientes já cadastrados na inicialização do sistema para o aplicativo mobile via API Rest;</br>
http://localhost:8080/pedidos-> Endpoint que envia e recebe os pedidos do Front End.</br>

### Docker
Opcional, se quiser saber mais sobre como configurar a aplicação com SQLServer para subir no docker, é só seguir o tutorial:

https://medium.com/@analiberato7/subindo-aplica%C3%A7%C3%A3o-spring-boot-e-sql-server-com-docker-compose-71a30a0f1a50

## Modelagem Banco de Dados

[![](https://i.ibb.co/ZhY1Kzv/BD.png)](http://i.ibb.co/ZhY1Kzv/BD.png)
