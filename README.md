\# Tools Challenge API



API REST desenvolvida em Java com Spring Boot para gerenciamento de transações financeiras, incluindo processamento de pagamentos, consulta e estorno.



\---



\## Autor



Desenvolvido por: Iraê Azevedo Silva



\---



\## Tecnologias utilizadas



\* Java 21

\* SpringBoot

\* Lombok

\* MapStruct

\* Maven



\---



\## Estrutura do projeto



```

controller  → Camada de entrada (REST API)

service     → Regras de negócio

dto         → Objetos de transferência (request/response)

mapper      → Conversão entre entidades e DTOs

config      → Configurações gerais (futuro)

```



\---



\## Como executar o projeto



\### Pré-requisitos



\* Java 21 ou superior

\* Maven instalado



\### Executando



```bash

mvn spring-boot:run



A aplicação irá subir em:



http://localhost:8080



\---



\## Endpoints da API



\### Criar transação



\*\*POST\*\* `/transacoes`



\#### Exemplo de request:



```json

{

&#x20; "transacao": {

&#x20;   "cartao": "1234-5678",

&#x20;   "descricao": {

&#x20;     "valor": "100.00",

&#x20;     "dataHora": "2024-04-22 10:00:00",

&#x20;     "estabelecimento": "Loja Teste"

&#x20;   },

&#x20;   "formaPagamento": {

&#x20;     "tipo": "AVISTA",

&#x20;     "parcelas": "1"

&#x20;   }

&#x20; }

}

```



\---



\### Estornar transação



\*\*POST\*\* `/transacoes/{id}/estorno`



\---



\### Buscar transação por ID



\*\*GET\*\* `/transacoes/{id}`



\---



\### Listar todas as transações



\*\*GET\*\* `/transacoes`



\---



\## Tratamento de erros



A API retorna mensagens de erro padronizadas para:



\* Transação não encontrada

\* Dados inválidos na requisição

\* Regras de negócio violadas



\---



\## Regras de negócio



\* Transações do tipo \*\*AVISTA\*\* não podem ter mais de 1 parcela

\* Cada transação recebe:

&#x20; \* ID único gerado automaticamente

&#x20; \* NSU (Número Sequencial Único)

\* Transações podem ser estornadas



\---



\## Testes



Os endpoints podem ser testados utilizando:



\* Postman

\* Insomnia

\* Curl

