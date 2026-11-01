# Garbage Collector (GC) em Java

## O que é o Garbage Collector

O **Garbage Collector** (GC) é o mecanismo da JVM responsável por gerenciar automaticamente a memória heap da aplicação Java. Em vez de o programador alocar e liberar memória manualmente (como em C com `malloc`/`free`), a JVM aloca objetos no heap e, periodicamente, identifica quais objetos não estão mais em uso e libera o espaço ocupado por eles.

O GC roda em threads separadas da aplicação e é executado automaticamente, embora possa ser solicitado (não garantido) com `System.gc()`.

---

## Como a memória é organizada no Java

A heap da JVM é dividida principalmente em:

- **Young Generation (Nova Geração)**: onde novos objetos são alocados. É dividida em:
  - **Eden**: destino inicial de quase todo novo objeto.
  - **Survivor 0 e Survivor 1 (S0/S1)**: objetos que sobrevivem a coleções jovens são movidos entre essas regiões.
- **Old Generation (Velha Geração)**: objetos que sobrevivem a várias coleções jovens são promovidos para aqui. Ocupam mais tempo de vida.
- **Metaspace**: armazena metadados de classes (substituiu a antiga PermGen a partir do Java 8).

O fluxo típico é:

```
Novo objeto -> Eden -> (sobrevive) -> S0/S1 -> (sobrevive várias vezes) -> Old Gen
```

Coleções na Young Generation são chamadas de **Minor GC** (rápidas e frequentes). Coleções na Old Generation são chamadas de **Major GC** ou **Full GC** (mais lentas e podem parar a aplicação — STW: Stop-The-World).

---

## Tipos de Garbage Collectors disponíveis no Java

A seguir, os principais coletores existentes nas versões modernas do JDK (Java 8 até Java 21+).

### 1. Serial GC

- **Flag**: `-XX:+UseSerialGC`
- Coleta de forma **sequencial**, em uma única thread.
- Para a aplicação durante toda a coleção (STW).
- Indicado para:
  - Aplicações pequenas.
  - Ambientes com pouca memória e um único núcleo de CPU (ex.: dispositivos embarcados, containers pequenos).
- Não indicado para aplicações de servidor ou com grandes heaps.

### 2. Parallel GC (Throughput Collector)

- **Flag**: `-XX:+UseParallelGC` (padrão em JDK 8)
- Coleta a Young Generation usando **múltiplas threads** em paralelo.
- Foco em **throughput** (quantidade de trabalho processado por unidade de tempo).
- Pode causar pausas STW perceptíveis na Old Generation.
- Indicado para:
  - Aplicações em batch, processamento de dados, workers de background.
  - Cenários onde pausas curtas não são críticas, mas o throughput geral é importante.

### 3. CMS — Concurrent Mark Sweep

- **Flag**: `-XX:+UseConcMarkSweepGC`
- Coleta a Old Generation **concorrentemente** com as threads da aplicação, tentando minimizar pausas STW.
- Fases principais: Mark inicial (STW), Marcação concorrente, Remark (STW), Sweep concorrente, Reset concorrente.
- **Desvantagens**:
  - Pode sofrer com **fragmentação** do heap (não compacta a memória).
  - Pode promover objetos muito rápido para a Old Gen, causando "promotion failed" e Full GC serial.
- **Depreciado desde o Java 9** e **removido no Java 14**.

### 4. G1 GC — Garbage-First

- **Flag**: `-XX:+UseG1GC` (padrão a partir do Java 9)
- Divide o heap em **regiões de tamanho igual** (não separa rigidamente Young/Old em espaços contíguos).
- Coleta regiões com mais "lixo" primeiro (daí o nome Garbage-First).
- Executa coleção jovem e antiga de forma mais equilibrada, com **pausas previsíveis**.
- Meta de pausa configurável: `-XX:MaxGCPauseMillis=200` (padrão 200ms).
- Compacta a memória durante a coleção (evita fragmentação).
- Indicado para:
  - Aplicações com heaps grandes (4 GB+).
  - Servidores web, aplicações empresariais que precisam de baixo tempo de pausa e bom throughput.

### 5. ZGC — Z Garbage Collector

- **Flag**: `-XX:+UseZGC` (experimental no Java 11, estável no Java 15+)
- Coletor de **baixa latência**, projetado para heaps de **terabytes** com pausas na casa dos **milisegundos** (geralmente < 10 ms).
- Faz a maior parte do trabalho **concorrentemente**, incluindo compactação.
- Não separa Young e Old Generation de forma tradicional; usa **colored pointers** e **load barriers**.
- Requer hardware de 64 bits.
- Indicado para:
  - Aplicações com requisitos rígidos de latência (sistemas de tempo real, trading, jogos).
  - Heaps muito grandes (centenas de GB a TB).

### 6. Shenandoah GC

- **Flag**: `-XX:+UseShenandoahGC`
- Similar ao ZGC: coletor de baixa latência com **compactação concorrente**.
- Pausas STW independentes do tamanho do heap (geralmente < 10 ms).
- Desenvolvido inicialmente pela Red Hat (não pela Oracle), disponível em builds OpenJDK e algumas distribuições (ex.: Ubuntu, Red Hat).
- Indicado para:
  - Aplicações sensíveis a pausa com heaps grandes.
  - Ambientes onde ZGC não está disponível.

### 7. Epsilon GC

- **Flag**: `-XX:+UseEpsilonGC` (Java 11+)
- Coletor **no-op**: aloca memória, mas **nunca coleta**.
- Quando o heap se esgota, a JVM encerra com `OutOfMemoryError`.
- Indicado para:
  - Testes de desempenho e análise de overhead do próprio GC.
  - Aplicações com memória finita e tempo de vida curto (job que roda e encerra antes do heap encher).
  - Análise de vazamento de memória (para isolar se o problema está no GC ou na aplicação).

---

## Tabela comparativa rápida

| Coletor | Flag JVM | Pausas STW | Compactação | Heap típico | Melhor uso |
|---------|----------|------------|-------------|-------------|------------|
| Serial | `-XX:+UseSerialGC` | Longas (single-thread) | Sim | Pequeno | Dispositivos com 1 CPU / pouca RAM |
| Parallel | `-XX:+UseParallelGC` | Longas (multi-thread) | Sim | Médio/Grande | Batch, throughput crítico |
| CMS | `-XX:+UseConcMarkSweepGC` | Curtas | Não | Médio/Grande | (Obsoleto — Java 9+ depreciado, Java 14 removido) |
| G1 | `-XX:+UseG1GC` | Curtas e previsíveis | Sim | Grande | Servidores web, apps empresariais (padrão moderno) |
| ZGC | `-XX:+UseZGC` | Mínimas (< 10 ms) | Sim | Muito grande | Baixa latência, heaps de TB |
| Shenandoah | `-XX:+UseShenandoahGC` | Mínimas (< 10 ms) | Sim | Grande/Muito grande | Baixa latência, alternativa ao ZGC |
| Epsilon | `-XX:+UseEpsilonGC` | Nunca (não coleta) | Não | Qualquer | Testes, benchmark, jobs curtos |

---

## Como escolher o coletor

1. **Padrão atual (Java 17, 21)**: use **G1 GC**. É o padrão da Oracle/OpenJDK e equilibra bem throughput e pausas.
2. **Heap pequeno (< 2-4 GB) e pouca CPU**: considere **Serial** ou **Parallel**.
3. **Requisito de pausa < 10 ms e heap grande**: use **ZGC** ou **Shenandoah**.
4. **Aplicação de lote/batch sem requisito de pausa**: **Parallel** costuma entregar melhor throughput.
5. **Nunca use CMS em Java 14+**; ele foi removido.

---

## Exemplos de flags de JVM

```bash
# Serial GC
java -XX:+UseSerialGC -Xmx512m -jar app.jar

# Parallel GC (foco em throughput)
java -XX:+UseParallelGC -Xmx4g -jar app.jar

# G1 GC com meta de pausa de 200 ms
java -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -Xmx8g -jar app.jar

# ZGC (Java 15+)
java -XX:+UseZGC -Xmx16g -jar app.jar

# Shenandoah GC
java -XX:+UseShenandoahGC -Xmx16g -jar app.jar

# Epsilon GC (sem coleta)
java -XX:+UseEpsilonGC -Xmx2g -jar app.jar
```

---

## Boas práticas com GC

- Não chame `System.gc()` em código de produção; deixe a JVM decidir quando coletar.
- Monitore o GC com flags úteis para diagnóstico:
  - `-XX:+PrintGCDetails`
  - `-XX:+PrintGCDateStamps`
  - `-Xlog:gc*` (Java 9+, Unified Logging)
- Use ferramentas como **jstat**, **VisualVM**, **JMC (Java Mission Control)** ou **GCEasy** para analisar logs de GC.
- Evite reter objetos desnecessariamente em coleções estáticas ou caches sem limite (causa vazamento de memória que o GC não consegue limpar).
- Dimensione o heap corretamente: `-Xms` (inicial) e `-Xmx` (máximo). Defini-los iguais evita redimensionamentos da heap em tempo de execução.

---

## Resumo

O Java oferece múltiplos coletores de lixo para diferentes perfis de aplicação:

- **Serial**: simples, single-thread, para ambientes muito restritos.
- **Parallel**: alta capacidade de processamento (throughput), tolera pausas.
- **G1**: padrão moderno, bom equilíbrio, pausas previsíveis, heap grande.
- **ZGC / Shenandoah**: ultra-baixa latência, pausas quase imperceptíveis, heaps massivos.
- **Epsilon**: sem coleta, apenas para testes e cenários especiais.

Escolha o coletor com base no tamanho do heap, na sensibilidade a pausas da sua aplicação e nos recursos de CPU disponíveis.