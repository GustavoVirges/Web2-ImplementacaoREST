# Web2 – Implementação REST (DAO + MVC)

API REST de **Jogadores** e **Itens** (Spring Boot 3, JPA/Hibernate, MySQL).

## Arquitetura (requisito c)

| Camada MVC / DAO | Pacote | Responsabilidade |
|---|---|---|
| **Model** | `org.example.model` | Entidades JPA (`Jogador`, `Item`) e enums |
| **View** | `org.example.dto` | Representação JSON exposta ao cliente (Request/Response) |
| **Controller** | `org.example.controller` | Recebe HTTP, valida (`@Valid`) e delega ao service |
| **Service** | `org.example.service` | Regras de negócio e transações |
| **DAO** | `org.example.dao` | Único ponto de acesso ao banco (`EntityManager`) |

Fluxo: `Controller -> Service -> DAO (interface) -> DaoJpa (implementação) -> MySQL`

Padrão DAO (um DAO por entidade):
- `JogadorDao` / `ItemDao`: interfaces com o CRUD (`insert`, `update`, `delete`, `findById`, `findAll`) e consultas específicas (`existsByNome`, `existsByNomeAndJogador`)
- `JogadorDaoJpa` / `ItemDaoJpa`: implementações `@Repository` que usam o `EntityManager`

## Endpoints

`/jogadores` e `/itens`: `POST`, `GET`, `GET /{id}`, `PUT /{id}`, `DELETE /{id}`

```
POST /jogadores  {"nome":"Henrique","nivel":10,"cla":"Alpha","classe":"ESPADA"}
POST /itens      {"nome":"Espada de Fogo","raridade":"RARO","quantidade":1,"jogadorId":1}
```

## Executar
```
export DB_USER=root DB_PASSWORD=root
mvn spring-boot:run
```
