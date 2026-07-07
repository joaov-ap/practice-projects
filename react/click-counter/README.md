# Click Counter

Projeto de prática em React focado em hooks fundamentais, persistência com localStorage e manipulação do DOM com useRef.

## O que faz

- Incrementar, decrementar e resetar um contador
- Animação de cor no número ao mudar de valor (verde ao incrementar, vermelho ao decrementar)
- Histórico dos últimos 10 valores
- Persistência do contador no localStorage — não perde ao recarregar a página

## Tecnologias

- React 18
- Vite
- CSS puro

## Como rodar

```bash
npm install
npm run dev
```

## O que pratiquei

- `useState` com lazy initialization para ler o localStorage na inicialização
- `useEffect` para sincronizar estado com localStorage e gerenciar o histórico
- `useRef` para acessar o DOM diretamente e manipular classes CSS
- `useRef` para guardar o id do setTimeout e cancelar com clearTimeout
- Separação de responsabilidades: App gerencia estado, Counter exibe e dispara ações, History só exibe
- Evitar mutação direta do estado (slice em vez de shift)
- Ignorar a primeira execução do useEffect com useRef flag
