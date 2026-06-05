# CSV Manipulator

Projeto de prática em Java puro para leitura, filtragem e escrita de arquivos CSV.

## O que faz

- Lê um CSV de vendas e mapeia cada linha para um objeto `Sale`
- Filtra vendas por categoria e gera um novo CSV com o resultado
- Agrupa e soma o total de vendas por categoria
- Lista as top 5 vendas por valor

## Tecnologias

- Java 21
- Sem frameworks ou dependências externas

## Como rodar

Clone o repositório e compile pelo terminal:

```bash
javac -d out src/main/java/dev/joaov/**/*.java
java -cp out main.java.dev.joaov.Main
```

O arquivo de entrada deve estar em `src/data/input/retail_sales_dataset.csv`.  
O resultado filtrado é gerado em `src/data/output/`.

## O que pratiquei

- `BufferedReader` e `BufferedWriter` para I/O de arquivos
- `Stream API`: `filter`, `sorted`, `limit`, `groupingBy`, `summingDouble`
- `Enum` para representar categorias
- Separação de responsabilidades: leitura, processamento e escrita em classes distintas