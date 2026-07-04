# Functional Calculator

Projeto de prática em Java puro focado em interfaces funcionais, lambdas e method references.  
Sem frameworks, sem I/O — a lógica de cada operação vive num `Map` em vez de blocos `if/switch`.

## O que faz

- Operações básicas: `+`, `-`, `*`, `/`, `%`
- Operações matemáticas: `sqrt` (raiz quadrada) e `pow` (potência) via `Math::pow`
- Histórico de operações salvo automaticamente a cada cálculo
- Encadeamento de transformações no resultado com `Function::andThen`
- Tratamento de operador inválido e divisão por zero

## Tecnologias

- Java 21
- Sem frameworks ou dependências externas

## Como rodar

```bash
# Compilar
javac -d out src/main/java/dev/joaov/model/*.java \
             src/main/java/dev/joaov/calculator/*.java \
             src/main/java/dev/joaov/Main.java

# Executar
java -cp out main.java.dev.joaov.Main
```

## O que pratiquei

- `BiFunction<T, U, R>` como interface funcional principal
- `Map<String, BiFunction>` substituindo if/switch na lógica de operações
- Method reference com `Double::sum` e `Math::pow`
- `Function::andThen` para encadeamento de transformações
- `record` para o modelo `HistoryEntry`
- Tratamento de erro com `getOrDefault` lançando exceção para operadores inválidos
- Dois construtores: um sem histórico, um injetando `OperationHistory`