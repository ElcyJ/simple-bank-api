# Simples API de Banco

O desafio envolve a implementação de uma API Restful genérica para serviços
bancários. Dentre os serviços, a api deverá apresentar:
* Cadastro de Usuários
* Autenticação
* Cadastro de Contas pelos usuários
* Transferências
* Exibição do Saldo corrente

## Tecnologias usadas
* [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
* [Maven/Spring Boot](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.3.RELEASE&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo))
* [PostgreSQL](https://www.postgresql.org/download/)

## Rodar aplicação através do arquivo .jar
Baixe o arquivo e no mesmo diretório escreva:
```bash
java -jar bank-0.0.1-SNAPSHOT.jar
```
## Como usar a API
### Endpoints:

**Cadastrar de Usuário** - localhost:8080/users 
<br/>
>{
>    "email":"email@email.com",
>    "password":"123",
>    "name":"maria"
>}
<br/>

**Fazer autenticação** - localhost:8080/auth
<br/>
>{
>    "username":"email@email.com",
>    "password":"123"
>}
<br/>

* (inserir token gerado pela autenticação no hearders dos endpoints em diante)
<br/>

**Criar conta bancária** - localhost:8080/accounts
<br/>

>{
>    "number":"10",
>    "balance":"100"
>}
<br/>

**Fazer transferência** - localhost:8080/accounts/transfer
<br/>

>{
>    "sourceAccountNumber":"10",
>    "destinationAccountNumber":"20",
>    "amount": "20"
>}
<br/>

**Visualizar saldo da conta** - localhost:8080/accounts/balance
<br/>

>{
>    "accountNumber":"10"
>}
<br/>
<br/>

Obrigada!
