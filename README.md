# Sistema de Reserva de Ingressos de Cinema (Bilheteria)

## Visão Geral

O **Sistema de Reserva de Ingressos de Cinema (Bilheteria)** é uma aplicação Java que facilita o processo de compra de ingressos de cinema. O programa oferece uma interface amigável para a seleção de filmes, horários de exibição e especificação da quantidade de ingressos normais e com desconto. Calcula o custo total com base nas escolhas do usuário e apresenta um resumo da transação.

## Proposta da Disciplina

A proposta da disciplina de Programação Orientada a Objetos com Java, sob a orientação do nosso professor, é explorar os princípios fundamentais da programação orientada a objetos na prática. Através do desenvolvimento deste sistema de reserva de ingressos de cinema, buscamos aplicar conceitos como encapsulamento, herança, polimorfismo e abstração, proporcionando uma compreensão mais aprofundada desses conceitos essenciais.

## Etapas

## Etapa 1

### Passo 1: Usar Estrutura de Decisão e/ou Repetição
A estrutura de decisão foi empregada para direcionar o fluxo do programa com base nas escolhas do usuário. A escolha do filme, horário e quantidade de ingressos são decisões fundamentais para o funcionamento do sistema. A estrutura de repetição não foi necessária nesta etapa, pois as interações com o usuário ocorrem apenas uma vez durante a execução do programa.

### Passo 2: Usar vetor ou ArrayList
O vetor ou ArrayList não foi necessário nesta etapa, pois as escolhas do usuário foram tratadas individualmente sem a necessidade de armazenamento em estruturas de dados mais complexas.

### Passo 3: Implementar todas funcionalidades
Todas as funcionalidades básicas do sistema foram implementadas, incluindo a seleção de filme, escolha de horário, alocação de sala de cinema, especificação da quantidade de ingressos, cálculo do custo total e exibição de um resumo da transação.

### Passo 4: Comentar como foi sua experiência com a linguagem
Minha experiência com a linguagem Java foi positiva. A orientação a objetos proporcionou uma estrutura organizada para o desenvolvimento do sistema. A facilidade de manipulação de strings, estruturas de controle e utilização de classes e métodos tornaram o desenvolvimento mais eficiente. A compilação e execução do código foram diretas, facilitando o processo de depuração.

## Etapa 2

### Passo 1: Crie uma classe MenuController
A classe MenuController foi criada para centralizar as operações de interação do usuário. Métodos como `exibirSaudacao()`, `obterResposta()`, `selecionarFilme()`, `selecionarHorario()`, `comprarIngresso()`, `exibirResumo()` e `fecharScanner()` foram encapsulados nesta classe.

### Passo 2: Crie uma classe Filme
A classe Filme foi criada com atributos como nome, diretor, descrição, gênero, duração e um indicador para verificar se é um filme 3D. Isso proporciona uma representação mais completa e flexível das informações relacionadas a um filme.

## Etapa 3

### Passo 1: Ajustar classe Filme
A classe Filme foi ajustada para incluir informações adicionais como diretor, descrição, gênero e duração, fornecendo uma representação mais completa de um filme.

### Passo 2: Adicione polimorfismo ao seu projeto
Polimorfismo foi introduzido nas classes Ingresso e IngressoVIP com a implementação do método `calcularTotal()`. As classes agora têm versões específicas desse método, permitindo comportamentos diferentes para cada tipo de ingresso.

### Passo 3: Trabalhe o conceito de herança no seu projeto
O conceito de herança foi aplicado com a criação da classe IngressoVIP, que herda da classe base Ingresso. Isso permite reutilização de código e extensibilidade do projeto.


## Recursos

1. **Saudação com Base no Horário:** O aplicativo saúda o usuário com base no horário atual - manhã, tarde ou noite.

2. **Seleção de Filme:** Os usuários podem escolher entre uma lista de filmes disponíveis, cada um identificado por um número.

3. **Seleção de Horário de Exibição:** Após selecionar um filme, os usuários podem escolher um horário de exibição entre as opções disponíveis.

4. **Alocação e Seleção de Quantidade:** O programa determina a sala de cinema para o filme selecionado e solicita que o usuário informe a quantidade de ingressos normais e com desconto.

5. **Cálculo do Custo Total e Resumo:** O aplicativo calcula o custo total com base na quantidade de ingressos normais e com desconto, exibindo um resumo detalhado das escolhas do usuário.

6. **Validação de Entrada:** O programa inclui métodos de validação de entrada para garantir que os usuários forneçam respostas válidas.

7. **Mapeamento de Sala de Exibição:** Os filmes são mapeados para salas de cinema específicas para uma experiência de reserva mais realista.

8. **Cálculo de Custo:** O sistema calcula o custo total, considerando tanto os preços dos ingressos normais quanto dos ingressos com desconto.

## Como Começar

### Pré-requisitos

- Kit de Desenvolvimento Java (JDK) instalado em sua máquina.

### Como Executar

1. Clone este repositório em sua máquina local.

    ```bash
    git clone https://github.com/sandromatiass/EASPOO-CESMAC.git
    ```

2. Navegue até o diretório do projeto.

    ```bash
    cd EASPOO-CESMAC/cinema
    ```

3. Compile e execute o programa Java.

    ```bash
    java Bilheteria.java
    java Bilheteria
    ```

4. Siga as instruções na tela para navegar pelo processo de reserva de ingressos.

## Diretrizes de Contribuição

Se deseja contribuir para o projeto, siga estas diretrizes:

- Faça um fork do repositório.
- Crie um novo branch para sua feature ou correção de bug.
- Faça suas alterações e envie uma solicitação pull.
- Descreva claramente o propósito da solicitação pull e quaisquer alterações feitas.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).