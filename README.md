# CrediFlow – Automação de Testes E2E

Projeto de automação de testes End-to-End (ponta a ponta) voltado à validação de um sistema de gestão de crédito, cobrindo desde a autenticação do usuário até a solicitação e análise de empréstimos.

O objetivo principal é garantir a qualidade dos fluxos críticos do negócio, prevenir regressões e validar regras essenciais de concessão de crédito.

## Escopo do Projeto

Os testes automatizados validam o fluxo completo de crédito, priorizando cenários de alto impacto para o negócio:

* **Autenticação:** Validação de acesso seguro ao sistema.
* **Simulação de Crédito:** Fluxo de solicitação de empréstimos.
* **Regras de Negócio:** Validação automática de aprovação e negação com base na saúde financeira do usuário.

## Tecnologias Utilizadas

O projeto foi construído sobre uma arquitetura robusta utilizando as seguintes ferramentas:

* **Java 17+**: Linguagem base do projeto.
* **Selenium WebDriver**: Interação e manipulação dos elementos web.
* **TestNG**: Framework de testes e orquestração da suíte.
* **Maven**: Gerenciamento de dependências e build.
* **Page Object Model (POM)**: Padrão de projeto para manutenção e escalabilidade.
* **Allure Report**: Relatórios visuais detalhados de execução.

## Cenários Automatizados

### Login
- [x] Deve realizar login com sucesso com credenciais válidas.
- [ ] Validação de credenciais inválidas (Planejado).

### Solicitação de Empréstimo (Data Driven)
A abordagem **Data Driven** foi utilizada para ampliar a cobertura de testes sem repetição de código.

- [x] Deve aprovar empréstimo para valores dentro da política de crédito.
- [x] Deve negar a solicitação quando o valor ultrapassar o limite permitido (**Teste Negativo**).

## Arquitetura de Testes

O projeto segue o padrão **Page Object Model (POM)**, garantindo:
* **Separação de Responsabilidades:** A lógica do teste é separada da interação com a página.
* **Manutenibilidade:** Alterações na UI requerem ajustes apenas nas classes de Page, sem quebrar os testes.
* **Legibilidade:** O código dos testes foca nas regras de negócio e asserções.

## Como Executar o Projeto

### Pré-requisitos
* Java JDK 17 ou superior.
* Maven instalado e configurado no PATH.

### Comandos de Execução

Abra o terminal na raiz do projeto e execute os comandos abaixo:

**1. Executar todos os testes:**
```bash
mvn clean test
