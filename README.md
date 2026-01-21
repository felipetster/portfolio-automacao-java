CrediFlow – Automação de Testes E2E

Projeto de automação de testes End-to-End (ponta a ponta) voltado à validação de um sistema de gestão de crédito, cobrindo desde a autenticação do usuário até a solicitação e análise de empréstimos.
O objetivo é garantir a qualidade dos fluxos críticos do negócio, prevenir regressões e validar regras essenciais de concessão de crédito.

Escopo do Projeto

Os testes automatizados validam o fluxo completo de crédito, incluindo:

Autenticação do usuário

Simulação e solicitação de empréstimo

Validação de regras de negócio para aprovação e negação de crédito

O foco está em cenários de alto impacto para o negócio, priorizando estabilidade, confiabilidade e qualidade das entregas.

Tecnologias Utilizadas

Java 17+

Selenium WebDriver

TestNG

Maven

Page Object Model (POM)

Allure Report

Cenários Automatizados
Login

Deve realizar login com sucesso com credenciais válidas

Validação de credenciais inválidas (planejado)

Solicitação de Empréstimo (Data Driven)

Deve aprovar empréstimo para valores dentro da política de crédito

Deve negar a solicitação quando o valor ultrapassar o limite permitido, validando regra de negócio crítica

Os cenários utilizam abordagem data-driven para ampliar a cobertura e facilitar testes de regressão.

Arquitetura de Testes

Aplicação do padrão Page Object Model para separação de responsabilidades

Centralização das interações com a interface

Estrutura organizada visando manutenção, legibilidade e escalabilidade dos testes

Como Executar o Projeto
Pré-requisitos

Java JDK 17 ou superior

Maven instalado e configurado no PATH

Execução
# Executar todos os testes
mvn clean test

# Gerar e abrir o relatório Allure
mvn allure:serve
