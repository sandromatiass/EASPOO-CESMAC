package cinema.controller;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;
import cinema.model.Filme;
import cinema.model.Ingresso;
import cinema.model.IngressoVIP;
import cinema.Bilheteria;

public class MenuController {
    private Scanner scanner;

    public MenuController() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirSaudacao() {
    LocalTime agora = LocalTime.now();

    if (agora.isAfter(LocalTime.of(6, 0)) && agora.isBefore(LocalTime.of(12, 0))) {
        System.out.println("Bom dia!");
    } else if (agora.isAfter(LocalTime.of(12, 0)) && agora.isBefore(LocalTime.of(18, 0))) {
        System.out.println("Boa tarde!");
    } else {
        System.out.println("Boa noite!");
    }
}

    public int obterResposta() {
        int resposta = 0;

        do {
            try {
                System.out.print("Você deseja comprar um bilhete de cinema? Digite (1) - para 'sim' e (2) - para 'não': ");
                resposta = Integer.parseInt(scanner.nextLine());

                if (resposta != 1 && resposta != 2) {
                    System.out.println("Por favor, digite 1 para 'sim' ou 2 para 'não'.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        } while (true);

        return resposta;
    }

    public int selecionarFilme() {
        System.out.println("Certo, escolha um filme da lista digitando o número correspondente:");
        String[] filmes = {"Matrix Revolution", "Constantine", "Harry Potter e a Pedra Filosofal", "Sete Vidas"};
    
        for (int i = 0; i < filmes.length; i++) {
            Filme filme = Bilheteria.obterFilmePorIndice(i + 1);
            System.out.println((i + 1) + ". " + filme.getNome());
            System.out.println("   Diretor: " + filme.getDiretor());
            System.out.println("   Descrição: " + filme.getDescricao());
            System.out.println("   Gênero: " + filme.getGenero());
            System.out.println("   Duração: " + filme.getDuracao() + " minutos");
        }
    
        return obterEscolha(4, "Escolha o número do filme desejado: ");
    }

    public int selecionarHorario() {
        System.out.println("Escolha um horário da sessão:");
        String[] horarios = {"17:40", "19:30", "21:20"};

        for (int i = 0; i < horarios.length; i++) {
            System.out.println((i + 1) + ". " + horarios[i]);
        }

        return obterEscolha(horarios.length, "Escolha o número do horário desejado: ");
    }

    public int selecionarTipoIngresso() {
        System.out.println("Escolha o tipo de ingresso:");
        System.out.println("1. Ingresso Comum");
        System.out.println("2. Ingresso VIP");
    
        return obterEscolha(2, "Digite o número do tipo de ingresso desejado: ");
    }

    public Ingresso comprarIngresso(Filme filme, String horario) {
        String sala = obterSalaExibicao(filme.getNome());
        System.out.println("O filme está em exibição na sala " + sala + ".");

        int quantidadeInteira = obterQuantidade("O valor da entrada inteira é de 24,00R$, informe a quantidade desejada: ");
        int quantidadeMeia = obterQuantidade("O valor da meia-entrada é de 12,00R$, informe a quantidade desejada: ");

        return new Ingresso(filme, horario, quantidadeInteira, quantidadeMeia);
    }

    public IngressoVIP comprarIngressoVIP(Filme filme, String horario) {
        String sala = obterSalaExibicao(filme.getNome());
        System.out.println("O filme está em exibição na sala " + sala + ".");

        int quantidadeInteira = obterQuantidade("O valor da entrada inteira VIP é de 48,00R$, informe a quantidade desejada: ");
        int quantidadeMeia = obterQuantidade("O valor da meia-entrada VIP é de 24,00R$, informe a quantidade desejada: ");

        return new IngressoVIP(filme, horario, quantidadeInteira, quantidadeMeia);
    }

    public void exibirResumo(Ingresso ingresso) {
        BigDecimal totalPagar = ingresso.calcularTotal();

        System.out.println("Resumo do pedido:");
        System.out.println("Filme: " + ingresso.getFilme().getNome());
        System.out.println("Horário da sessão: " + ingresso.getHorario());
        System.out.println("Sala de exibição: " + obterSalaExibicao(ingresso.getFilme().getNome()));
        System.out.println("Ingressos inteiros: " + ingresso.getQuantidadeInteira());
        System.out.println("Ingressos meia-entrada: " + ingresso.getQuantidadeMeia());
        System.out.println("Total a pagar: R$ " + totalPagar);

        if (ingresso instanceof IngressoVIP) {
            System.out.println("Seu ingresso é VIP, você tem acesso livre a lanchonete.");
        }
    }

    public void despedida() {
        System.out.println("Volte sempre!");
    }

    public void fecharScanner() {
        scanner.close();
    }

    private int obterEscolha(int max, String mensagem) {
        int escolha = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print(mensagem);
                escolha = Integer.parseInt(scanner.nextLine());

                if (escolha >= 1 && escolha <= max) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, digite um número válido no intervalo de 1 a " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        } while (!entradaValida);

        return escolha;
    }

    private int obterQuantidade(String mensagem) {
        int quantidade = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print(mensagem);
                quantidade = Integer.parseInt(scanner.nextLine());

                if (quantidade >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, digite um número não negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        } while (!entradaValida);

        return quantidade;
    }

    private String obterSalaExibicao(String filme) {
        switch (filme) {
            case "Matrix Revolution":
                return "Sala 1B";
            case "Constantine":
                return "Sala 2B";
            case "Harry Potter e a Pedra Filosofal":
                return "Sala 3B";
            case "Sete Vidas":
                return "Sala 4B";
            default:
                return "Sala não especificada";
        }
    }
}
