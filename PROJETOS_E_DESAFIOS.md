# Roteiro de Estudos: Orientação a Objetos em Java para Backend

Este documento reúne ideias de **projetos** e **desafios** práticos para consolidar
Orientação a Objetos em Java com foco no caminho de desenvolvimento backend.

A progressão sugerida é: primeiro os **Desafios** (mais curtos, focados em um conceito
de POO por vez) e depois os **Projetos** (mais completos, simulando sistemas reais de backend).

---

## 🧩 Desafios (foco em um conceito de POO por vez)

### 1. Sistema de Contas Bancárias
Modele classes `Conta`, `ContaCorrente` e `ContaPoupanca` (herança), com métodos
`depositar()`, `sacar()` e `aplicarRendimento()`. Trate saldo insuficiente com
exceções customizadas (`SaldoInsuficienteException`).
- **Conceitos:** encapsulamento, herança, polimorfismo, tratamento de exceções.

### 2. Validador de Pedidos de E-commerce
Crie uma cadeia de validação para um `Pedido` (itens, cliente, endereço, forma de
pagamento) usando o padrão **Chain of Responsibility** ou interfaces funcionais.
Cada validador deve poder ser testado isoladamente.
- **Conceitos:** interfaces, composição, princípio de responsabilidade única (SRP).

### 3. API de Fila de Tarefas (Task Queue) em Memória
Implemente uma estrutura que aceita `Tarefa` com prioridade, status (`PENDENTE`,
`EM_EXECUCAO`, `CONCLUIDA`) e permita listar/filtrar por status usando Streams
do Java (`java.util.stream`).
- **Conceitos:** enums, generics, Collections, Stream API.

### 4. Mini Sistema de Autenticação
Construa `Usuario`, `Senha` (com hashing simples via `MessageDigest`) e um
`AutenticadorService` que verifica credenciais e gera um token simples (UUID)
com tempo de expiração.
- **Conceitos:** abstração, composição, tratamento de tempo/data (`java.time`).

### 5. Conversor de Formatos com Design Pattern Strategy
Implemente um conversor de dados (ex: `Pessoa` para JSON, XML e CSV) usando o
padrão **Strategy**, permitindo trocar o formato de saída em tempo de execução
sem alterar a classe principal.
- **Conceitos:** polimorfismo, interfaces, padrões de projeto (Strategy).

---

## 🚀 Projetos (mais completos, simulando backend real)

### 1. API REST de Gerenciamento de Biblioteca
Sistema para cadastro de livros, usuários e empréstimos, com regras de negócio
(limite de empréstimos, multas por atraso). Comece com classes puras em Java
(POO) e depois evolua para **Spring Boot** com persistência em banco relacional.
- **Aprendizados:** modelagem de domínio, camadas (Controller/Service/Repository), DTOs.

### 2. Sistema de Reservas (hotéis, mesas de restaurante ou salas)
Modele `Reserva`, `Recurso` (quarto/mesa/sala) e `Cliente`, com validação de
conflitos de horário/data. Adicione uma camada de API REST com endpoints de
criação, cancelamento e consulta de disponibilidade.
- **Aprendizados:** regras de concorrência simples, validação de regras de negócio complexas.

### 3. Mini Marketplace (Catálogo + Carrinho + Pedido)
Construa entidades `Produto`, `Categoria`, `Carrinho`, `Pedido` e `Pagamento`
(simulado). Trabalhe cálculo de frete, aplicação de descontos e status de
pedido como uma máquina de estados.
- **Aprendizados:** relacionamento entre entidades, agregados, padrão State.

### 4. Sistema de Gerenciamento de Tarefas Colaborativo (estilo Trello simplificado)
API com `Quadro`, `Coluna`, `Cartao` e `Usuario`, permitindo mover cartões entre
colunas, atribuir responsáveis e histórico de alterações (log de auditoria).
- **Aprendizados:** modelagem de hierarquias, versionamento de estado, autenticação/autorização.

### 5. Encurtador de URLs com Métricas de Acesso
API que recebe uma URL longa, gera um código curto único, redireciona e
registra métricas de acesso (quantidade de cliques, data/hora, origem).
Explore geração de identificadores únicos, cache e persistência.
- **Aprendizados:** design de API simples e escalável, uso de cache (ex: `HashMap` → depois Redis),
  boas práticas de versionamento de API.

---

## 📌 Sugestão de Progressão de Estudo

1. Resolver os 5 **desafios** em Java puro (sem frameworks), fixando POO.
2. Escolher 1 ou 2 **projetos** e implementá-los primeiro em Java puro.
3. Evoluir os mesmos projetos usando **Spring Boot**, **JPA/Hibernate** e um banco
   de dados real (PostgreSQL/MySQL), introduzindo testes automatizados (JUnit).
4. Adicionar boas práticas de backend: tratamento de erros centralizado,
   validação de entrada, documentação de API (Swagger/OpenAPI) e logs.

> Dica: mantenha cada desafio/projeto em seu próprio pacote (ex: `br.com.estudos.contabancaria`)
> dentro deste repositório de estudos, para facilitar a organização e revisão futura.
