# GitHub User Search

Projeto de prática em React para buscar usuários na API pública do GitHub, exibir perfil e top repositórios.

## O que faz

- Busca um usuário do GitHub pelo username (busca disparada por botão)
- Exibe avatar, nome, bio e estatísticas (repositórios públicos, gists, seguidores, seguindo)
- Lista os 5 repositórios com mais estrelas do usuário buscado
- Trata estados de loading e erro (usuário não encontrado)

## Tecnologias

- React 18
- Vite
- Fetch API (sem biblioteca externa de requisição)
- CSS puro

## Como rodar

```bash
npm install
npm run dev
```

## O que pratiquei

- Custom hook (`useFetch`) reutilizável para requisições com loading e erro
- `useCallback` para memoizar a função de requisição e evitar recriação a cada render
- `useEffect` com dependência correta (`repoUrl`) para re-buscar dados quando o usuário muda
- Tratamento de erro da API (usuário não encontrado)
- Ordenação de array sem mutar o estado (`toSorted` em vez de `sort`)
- Renderização condicional de componentes com base em estado (erro, dados, loading)
- Composição de componentes: App orquestra estado, SearchBar dispara busca, UserCard e RepoList só exibem
