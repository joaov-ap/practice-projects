# Streams Pipeline

Projeto de prática em Java puro focado exclusivamente na Stream API.  
Sem frameworks, sem banco de dados, sem I/O — só processamento de dados em memória.

## O que faz

Quatro pipelines que processam uma lista de `Product` com diferentes operações:

- **FilterPipeline** — filtra produtos por status, preço, categoria, estoque e combinações
- **TransformPipeline** — extrai nomes, converte preços para dólar, formata exibição e extrai tags únicas com `flatMap`
- **AggregatePipeline** — agrupa e agrega por categoria: preço médio, produto mais caro, total de estoque e contagem de ativos
- **AdvancedPipeline** — valor total do inventário com `reduce`, divisão caro/barato com `partitioningBy`, ordenação com `Comparator` encadeado e `takeWhile`

## Tecnologias

- Java 21
- Sem frameworks ou dependências externas

## Como rodar

```bash
# Compilar
javac -d out src/main/java/dev/joaov/model/*.java \
             data/DataGenerator.java \
             src/main/java/dev/joaov/pipeline/*.java \
             src/main/java/dev/joaov/Main.java

# Executar
java -cp out main.java.dev.joaov.Main
```

## O que pratiquei

- `filter`, `map`, `sorted`, `limit`, `distinct`
- `flatMap` para achatar listas aninhadas
- `reduce` com acumulador de tipo diferente dos elementos (3 argumentos)
- `Collectors.groupingBy` com downstream collectors: `averagingDouble`, `summingInt`, `counting`, `maxBy`, `collectingAndThen`
- `Collectors.partitioningBy`
- `Comparator.comparing` com `thenComparing` e direções diferentes por critério
- `takeWhile` em stream ordenada
- Utility class: `final class` com construtor privado
