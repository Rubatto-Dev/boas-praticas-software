# Boas Práticas e Controle de Versão

Atividade prática da disciplina **Manutenção e Configuração de Software** — Aula 6:
normas de configuração, boas práticas de codificação e uso do Git.

O projeto parte de um pequeno sistema de boletim escolar que funcionava, mas era
difícil de ler e de manter, e aplica sobre ele as boas práticas estudadas em aula.

## Como executar

```bash
javac -encoding UTF-8 Sistema.java
java Sistema
```

Saída esperada:

```
Aluno: Carlos
Média: 7.5
Situação: Aprovado
```

## Histórico de versões

| Branch | Conteúdo |
| --- | --- |
| `main` | Código original recebido, sem alterações |
| `melhoria-boas-praticas` | Versão refatorada com nomes descritivos, modularização e padronização |

As melhorias foram integradas à `main` por meio de um Pull Request, conforme o
fluxo de controle de versão estudado na aula.

## Questões finais

### 1. Qual era o principal problema do código original?

O código funcionava corretamente, mas não comunicava a própria intenção. Todas as
variáveis usavam nomes de uma letra (`n`, `a`, `b`, `c`), o que obrigava quem lesse
o programa a reconstruir mentalmente o significado de cada valor. Além disso, toda a
lógica estava concentrada dentro do método `main`: leitura dos dados, cálculo da
média, decisão sobre a aprovação e exibição do resultado ocupavam o mesmo bloco, sem
separação de responsabilidades. O número `6`, que representa a média mínima de
aprovação, aparecia solto no meio de um `if`, sem nome que explicasse o que ele
significa nem lugar único para ser alterado.

Esse conjunto de problemas não gera erro de execução, mas eleva o custo de
manutenção: qualquer mudança futura exige entender o programa inteiro antes de
alterar uma linha.

### 2. Quais melhorias você realizou?

- **Nomes descritivos:** `n` passou a `nomeDoAluno`, `a` e `b` a `primeiraNota` e
  `segundaNota`, e `c` a `mediaFinal`.
- **Constantes nomeadas:** o valor `6` virou a constante `MEDIA_MINIMA_APROVACAO`, e
  os textos de situação viraram `SITUACAO_APROVADO` e `SITUACAO_REPROVADO`. Mudar a
  regra de aprovação agora exige alterar um único ponto do código.
- **Modularização:** a lógica foi dividida em três métodos com responsabilidades
  específicas — `calcularMedia`, `verificarSituacao` e `apresentarResultado`. O
  `main` passou a apenas orquestrar a sequência.
- **Código auto comentado:** os nomes escolhidos explicam o que cada trecho faz, e os
  comentários foram reservados para documentar o propósito de cada método, sem
  repetir o que o código já diz.
- **Padronização:** nomes de classe em `PascalCase`, métodos e variáveis em
  `camelCase`, constantes em `UPPER_SNAKE_CASE`, indentação de quatro espaços e
  formatação consistente em todo o arquivo.
- **Apresentação do resultado:** a média passou a ser exibida com uma casa decimal
  via `printf`, e a situação recebeu um rótulo explícito na saída.

### 3. Como a modularização facilitou a organização do código?

Com cada responsabilidade isolada em seu próprio método, o `main` passou a ser um
resumo legível do que o programa faz: calcula a média, verifica a situação e
apresenta o resultado. Quem precisa alterar a regra de aprovação vai direto a
`verificarSituacao`, sem ler o restante do programa — o que reduz a chance de
introduzir um defeito em uma parte não relacionada.

A modularização também prepara o sistema para evoluir. Passar a aceitar três notas,
aplicar peso diferente a cada uma ou trocar a exibição no console por uma interface
gráfica são mudanças que atingem um método por vez, e não o programa inteiro. É a
mesma ideia discutida em aula: módulos com responsabilidade específica facilitam o
entendimento, permitem reúso e reduzem a complexidade do projeto.

### 4. Como o Git ajudou a controlar as alterações realizadas no sistema?

O Git transformou a refatoração em um processo rastreável em vez de uma substituição
de arquivo. O primeiro commit preservou o código original, de modo que a versão
anterior continua recuperável mesmo depois das melhorias — o que corresponde ao
rollback discutido nas aulas de configuração de software.

A branch `melhoria-boas-praticas` isolou o trabalho da versão principal, permitindo
experimentar as alterações sem colocar em risco o código que já funcionava. Cada
commit registrou arquivos modificados, mensagem descritiva, autor e data, formando um
histórico que responde *o que mudou, quem mudou e quando mudou*.

O Pull Request criou um ponto formal de revisão antes da integração, e o merge
devolveu as melhorias à `main` de forma controlada. Na prática, o controle de versão
funcionou aqui como a ferramenta que apoia a gerência de mudanças: o processo define
que toda alteração seja registrada, avaliada e rastreável, e o Git é o instrumento
que torna isso possível no dia a dia.
