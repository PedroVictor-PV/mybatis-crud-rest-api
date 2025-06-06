# MyBatis CRUD API

## 📝 Descrição

Este projeto é uma API REST desenvolvida com Spring Boot e MyBatis para realizar operações CRUD (Create, Read, Update, Delete) em uma entidade User. O objetivo principal é servir como material de estudo e fixação dos conceitos fundamentais do framework MyBatis, demonstrando diferentes abordagens de mapeamento (XML e anotações).

## 🎯 Motivo da Criação

A API foi desenvolvida com o propósito educacional de:
- Consolidar conhecimentos sobre o framework MyBatis
- Praticar integração entre Spring Boot e MyBatis
- Demonstrar diferentes formas de mapeamento de consultas SQL
- Criar um exemplo prático de API REST com operações CRUD

## 🔧 Tecnologias Utilizadas

- **Spring Boot 3.5.0**
- **MyBatis Spring Boot Starter 3.0.3**
- **MySQL Connector/J**
- **Lombok**
- **Maven**
- **Java 17**

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/pedro/crud_mybatis/
│   │   ├── controller/
│   │   │   └── UserController.java
│   │   ├── mapper/
│   │   │   └── UserMapper.java
│   │   ├── model/
│   │   │   └── User.java
│   │   ├── service/
│   │   │   └── UserService.java
│   │   └── CrudMybatisApplication.java
│   └── resources/
│       ├── mappers/
│       │   └── UserMapper.xml
│       └── application.properties
└── test/
    └── java/br/com/pedro/crud_mybatis/
        └── CrudMybatisApplicationTests.java
```

## ⚡ Funcionalidades

### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/user` | Criar um novo usuário |
| `GET` | `/user` | Listar todos os usuários |
| `GET` | `/user/{id}` | Buscar usuário por ID |
| `PUT` | `/user/{id}` | Atualizar usuário existente |
| `DELETE` | `/user/{id}` | Deletar usuário por ID |

### Modelo de Dados

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

### Características Técnicas

- **Framework**: Spring Boot 3.5.0
- **ORM**: MyBatis 3.0.3
- **Banco de Dados**: MySQL
- **Mapeamento**: XML (arquivo UserMapper.xml)
- **Annotations**: Lombok para redução de boilerplate
- **Arquitetura**: Controller → Service → Mapper

## 🛠️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven 3.6+**
- **MySQL 8.0+**
- **IDE** de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Configuração do Banco de Dados

1. Crie um banco de dados MySQL:
```sql
CREATE DATABASE crud_mybatis;
```

2. Crie a tabela `user`:
```sql
USE crud_mybatis;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
```

3. Configure as credenciais de conexão no arquivo `application.properties`:
```properties
# Configurações do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/crud_mybatis
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configurações MyBatis
mybatis.mapper-locations=classpath:mappers/*.xml
mybatis.type-aliases-package=br.com.pedro.crud_mybatis.model
```

## 🚀 Como Executar

### Opção 1: Via Maven Wrapper (Recomendado)

```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

### Opção 2: Via Maven

```bash
mvn spring-boot:run
```

### Opção 3: Via JAR

```bash
# Compilar o projeto
mvn clean package

# Executar o JAR gerado
java -jar target/crud_mybatis-0.0.1-SNAPSHOT.jar
```

A aplicação será iniciada na porta `8080`. Acesse: `http://localhost:8080`

## 📋 Exemplos de Uso

### Criar Usuário
```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@email.com"
  }'
```

### Listar Todos os Usuários
```bash
curl -X GET http://localhost:8080/user
```

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com"
  },
  {
    "id": 2,
    "nome": "Maria Santos",
    "email": "maria@email.com"
  }
]
```

### Buscar Usuário por ID
```bash
curl -X GET http://localhost:8080/user/1
```

**Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

### Atualizar Usuário
```bash
curl -X PUT http://localhost:8080/user/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Santos",
    "email": "joao.santos@email.com"
  }'
```

### Deletar Usuário
```bash
curl -X DELETE http://localhost:8080/user/1
```

## 📚 Conceitos MyBatis Demonstrados

- **Mapeamento XML**: Queries definidas em arquivos XML separados
- **ResultMap**: Mapeamento customizado de resultados
- **Parâmetros**: Uso de `#{parameter}` para binding seguro
- **Chaves Geradas**: `useGeneratedKeys="true"` para IDs auto-incrementais
- **Integração Spring**: Uso da anotação `@Mapper`

## 📝 Notas Adicionais

- O projeto utiliza mapeamento XML ao invés de anotações para demonstrar a flexibilidade do MyBatis
- As queries comentadas no `UserMapper.java` mostram como seria a implementação com anotações
- A estrutura segue o padrão MVC com separação clara de responsabilidades

## 👨‍💻 Desenvolvedor

**Pedro** - *Desenvolvedor Java* 

📧 Email: [pedro.cavalcante0515@gmail.com]
🐙 GitHub: [[PedroVictor-PV](https://github.com/PedroVictor-PV)]

---

*Projeto desenvolvido para fins educacionais e estudo do framework MyBatis*
