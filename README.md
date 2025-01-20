# Jogo de Adivinhação

  Este é um simples jogo de adivinhação onde o jogador tenta adivinhar um número secreto gerado aleatoriamente pelo sistema. O objetivo do jogo é adivinhar o número em um número limitado de tentativas, com a ajuda de dicas fornecidas a cada palpite.

## Requisitos

  Antes de rodar o projeto, tenha certeza de que você tem:

  - **Java 11** ou superior instalado em sua máquina.
  - Acesso à Internet para clonar o repositório.

## Como rodar o projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/eziocdl/jogo-adivinhacao.git

2. **Acesso ao repositório:**

   ```bash
   cd jogo-adivinhacao

3. **Compile e execute o projeto:**

   ```bash

   Compilando:

    javac -d bin src/projeto_jogo_adivinhacao/model/Jogo.java

   Executando:

   java -cp bin projeto_jogo_adivinhacao.model.Jogo


  ## Funcionalidades

- Iniciar um novo jogo: O jogo começa com a geração de um número secreto aleatório.

- Fazer palpites: O jogador tenta adivinhar o número, recebendo dicas após cada palpite.

- Reiniciar o jogo: O jogador pode reiniciar o jogo sempre que desejar.

- Pontuação: O jogador acumula pontos com base no número de tentativas restantes.

 ## Como jogar

  - O sistema gera um número secreto aleatório entre 1 e 100.
  - O jogador tem 7 tentativas para adivinhar o número.
  - Após cada palpite, o sistema informa se o número secreto é maior ou menor que o palpite.
  - Quando o jogador acerta o número secreto, ele recebe a pontuação final, que depende do número de tentativas restantes.
  - O jogo termina quando o jogador adivinha o número ou esgota todas as tentativas.
  
 ## Exemplo de execução

    1. Bem-vindo ao Jogo de Adivinhação!
    2. Digite seu palpite: 50
       - Errado! Menor
       - Restam 6 tentativas.
    
    3. Digite seu palpite: 30
       - Errado! Maior
       - Restam 5 tentativas.
    
    4. Digite seu palpite: 45
       - Parabéns! Você acertou o número secreto.
       - Sua pontuação final é: 12

 ## Tecnologias utilizadas

  - Java: Linguagem de programação usada para implementar o jogo.
  - SLF4J: Biblioteca de logging para registrar as ações realizadas no jogo.

## Contribuindo

  Se você deseja contribuir para o desenvolvimento deste projeto, siga os seguintes passos:
  
  1. Faça um fork do projeto.
  2. Crie uma branch para suas alterações (git checkout -b feature/nova-funcionalidade).
  3. Faça as alterações e commit (git commit -am 'Adicionando nova funcionalidade').
  4. Envie as alterações para o seu fork (git push origin feature/nova-funcionalidade).
  5. Abra um Pull Request para que suas mudanças sejam avaliadas.
