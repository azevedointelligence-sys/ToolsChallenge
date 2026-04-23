# Tools Challenge API

API REST desenvolvida em Java com Spring Boot para gerenciamento de transações financeiras, incluindo processamento de pagamentos, consulta e estorno.

---

## Autor

Desenvolvido por: Iraê Azevedo Silva

---

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Lombok
* MapStruct
* Maven

---

## Estrutura do projeto

```
controller  → Camada de entrada (REST API)
service     → Regras de negócio
dto         → Objetos de transferência (request/response)
mapper      → Conversão entre entidades e DTOs
config      → Configurações gerais
```

---

## Como executar o projeto

### Pré-requisitos

* Java 21
* Maven instalado

### Executando

```bash
mvn spring-boot:run
```

A aplicação irá subir em:

```
http://localhost:8080/api/v1
```

---

## Endpoints da API

Base URL:

```
http://localhost:8080/api/v1
```

---

### Criar transação

**POST** `/transacoes`

#### Exemplo de request:

```json
{
  "transacao": {
    "cartao": "1234-5678",
    "descricao": {
      "valor": "100.00",
      "dataHora": "2024-04-22 10:00:00",
      "estabelecimento": "Loja Teste"
    },
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    }
  }
}
```

---

### Estornar transação

**POST** `/transacoes/{id}/estorno`

---

### Buscar transação por ID

**GET** `/transacoes/{id}`

---

### Listar todas as transações

**GET** `/transacoes`

---

## Tratamento de erros

A API retorna mensagens de erro padronizadas para:

* Transação não encontrada
* Dados inválidos na requisição
* Regras de negócio violadas

---

## Regras de negócio

* Transações do tipo **AVISTA** não podem ter mais de 1 parcela
* Cada transação recebe:

    * ID único gerado automaticamente
    * NSU (Número Sequencial Único)
* Transações podem ser estornadas

---

## Testes

Os endpoints podem ser testados utilizando:

* Postman
* Insomnia
* Curl
