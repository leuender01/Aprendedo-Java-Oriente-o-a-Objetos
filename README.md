# ☕ Aprendendo Java

Repositório de estudos com o objetivo de consolidar a linguagem **Java** e os
fundamentos de **Orientação a Objetos**, com foco no caminho de
desenvolvimento **backend**.

Aqui você encontra desde exercícios básicos (variáveis, strings, conversões)
até um mini-sistema bancário em console, organizados por tema.

## 📁 Estrutura do repositório

```
aprendendo_java/
├── Basico/          # Fundamentos: variáveis, strings, conversões, funções
├── Arrays/          # Arrays, ordenação, comparação, hashCode
├── OPP/             # Orientação a Objetos: getters/setters, coleções
├── Algoritimos/      # Algoritmos clássicos (ex: sequência de Fibonacci)
├── Imports/         # Organização de classes em pacotes e imports
├── CriarArquivos/   # Manipulação de arquivos (leitura/escrita)
├── Gaficos/         # Introdução a interfaces gráficas em Java
├── Projeto_01/      # Calculadora
├── Projeto_02/      # Gerador de números
└── Bank/            # 🏦 Mini sistema bancário via terminal

PROJETOS_E_DESAFIOS.md  # Roteiro de desafios e projetos para evoluir os estudos
```

## 🏦 Destaque: Sistema Bancário (`Bank`)

Aplicação de console que simula operações bancárias básicas:

- Criação de contas
- Login/sessão por conta
- Saque e depósito
- Extrato (statement) da conta
- Consulta do saldo total do banco

Classes principais em [`aprendendo_java/Bank/classes`](aprendendo_java/Bank/classes):
`Account`, `Banck`, `Log`, `Menu` e `StatmentAccount`.

## 🧭 Próximos passos

O arquivo [`PROJETOS_E_DESAFIOS.md`](PROJETOS_E_DESAFIOS.md) reúne uma
progressão sugerida de desafios e projetos (sistema de contas, validador de
pedidos, autenticação, API REST, etc.) para evoluir do Java puro até
**Spring Boot** com persistência em banco de dados.

## ▶️ Como executar um exemplo

Compile e execute qualquer classe com `javac`/`java`. Exemplo para o sistema
bancário:

```bash
cd aprendendo_java/Bank
javac -d src classes/*.java App.java
java -cp src App
```

## 🛠️ Tecnologias

- Java (SE)

---
