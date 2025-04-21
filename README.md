# 📘 Desafio DevOps - Gerenciamento de Trânsito com Java Spring

Este documento apresenta a implementação completa do desafio proposto na fase "Navegando pelo mundo DevOps" do curso, utilizando como base um projeto Java Spring Boot com o tema de Cidades Inteligentes. Todas as práticas solicitadas foram aplicadas com sucesso, desde o desenvolvimento local até o deploy em produção no Azure.

---

## 🔧 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.3.5**
- **PostgreSQL** (ambiente local)
- **Flyway** (versionamento de banco de dados)
- **Docker** e **Docker Compose**
- **GitHub Actions** (CI/CD)
- **Azure App Service** (ambiente de produção)
- **Postman** (testes manuais da API)

---

## 🏗️ Estrutura do Projeto
O projeto foi construído utilizando o padrão de camadas:
- **Controller**: expõe os endpoints REST
- **Service**: contém a lógica de negócios
- **Repository**: interface com o banco de dados
- **Model**: entidades JPA
- **Security**: autenticação e autorização com JWT

Além disso, foi criado um endpoint `/health` para integração com o Azure Health Check.

---

## 👨‍💻 Desenvolvimento Local
O projeto foi desenvolvido e testado localmente com:
- Banco de dados PostgreSQL local
- Configuração completa do `application.properties`
- Execução via `mvn spring-boot:run`
- Versionamento com Flyway
- Testes manuais realizados via Postman

---

## 🔁 CI/CD com GitHub Actions
Foram criadas duas pipelines:
- `ci-cd.yml`: responsável por compilar e construir a imagem Docker
- `deploy-prod.yml`: faz o deploy da imagem para o Azure App Service

Cada commit na branch `main` dispara o build e o deploy automático.

---

## 📦 Containerização e Orquestração
A aplicação foi containerizada com Docker utilizando:
- `Dockerfile` para build da aplicação
- `docker-compose.yml` para ambiente local
- `docker-compose.prod.yml` para ambiente de produção

---

## ☁️ Deploy no Microsoft Azure
Foram criados os seguintes recursos no Azure:
- **App Service Plan (Linux)**
- **App Service (gerenciamento-transito-new)**

O deploy foi realizado com sucesso via GitHub Actions.

Foi configurado também o Health Check apontando para `/health`, além de permissões de "Contribuidor" no recurso.

---

## ✅ Conclusão
Todos os requisitos do desafio foram atendidos:
- CI/CD automatizado com GitHub Actions
- Imagem Docker construída com sucesso
- Deploy automatizado no Azure App Service
- Orquestração com Docker Compose
- Documentação clara com prints

Este projeto simula com fidelidade um ambiente real de DevOps para aplicações modernas baseadas em microserviços.

## Exemplo de Funcionamento

![](/assets/Gerenciamento-transito.gif)
