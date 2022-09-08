## Back End para aplicação de vendas
Esse projeto foi feito com o objetivo de ser um Back End para uma aplicação de vendas com clientes, produtos e pedidos. Foi utilizado Java e Spring Boot, com Maven como gerenciador de dependências e SQL Server para o banco de dados.

### Estrutura e execução desse projeto

------------


#### Pré requisitos
Para rodar este projeto você precisa:
- Java
- Maven
- SQLServer
Opcionalmente:
- Docker

#### Modelagem Banco de Dados

------------


[![](https://i.ibb.co/ZhY1Kzv/BD.png)](http://i.ibb.co/ZhY1Kzv/BD.png)

#### Endpoints da aplicação:

http://localhost:8080/produtos -> Endpoint que exporta os produtos já cadastrados na inicialização do sistema para o aplicativo mobile via API Rest;
http://localhost:8080/clientes -> Endpoint que exporta os clientes já cadastrados na inicialização do sistema para o aplicativo mobile via API Rest;
http://localhost:8080/pedidos-> Endpoint que envia e recebe os pedidos do Front End.

### Docker
Opcional, se quiser saber mais sobre como configurar a aplicação com SQLServer para subir no docker, é só seguir o tutorial:
