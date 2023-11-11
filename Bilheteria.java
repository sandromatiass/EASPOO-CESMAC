import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;

public class Bilheteria {
    public static void main(String[] args) {
        LocalTime agora = LocalTime.now();

        if (agora.isAfter(LocalTime.of(6, 0)) && agora.isBefore(LocalTime.of(12, 0))) {
            System.out.println("Bom dia!");
        } else if (agora.isAfter(LocalTime.of(12, 0)) && agora.isBefore(LocalTime.of(18, 0))) {
            System.out.println("Boa tarde!");
        } else {
            System.out.println("Boa noite!");
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int resposta;

            do {
                System.out.print("Você deseja comprar um bilhete de cinema? Digite (1) - para 'sim' e (2) - para 'não': ");
                resposta = obterResposta(scanner);

                System.out.println("Resposta: '" + resposta + "'");

                if (resposta == 1) {
                    System.out.println("Certo, escolha um filme da lista digitando o número correspondente:");

                    String[] filmes = {"Matrix Revolution", "Constantine", "Harry Potter e a Pedra Filosofal", "Sete Vidas"};

                    for (int i = 0; i < filmes.length; i++) {
                        System.out.println((i + 1) + ". " + filmes[i]);
                    }

                    int escolhaFilme = obterEscolha(scanner, filmes.length, "Escolha o número do filme desejado: ");

                    if (escolhaFilme >= 1 && escolhaFilme <= filmes.length) {
                        System.out.println("Você escolheu assistir a " + filmes[escolhaFilme - 1] + ". Bom filme!");

                        LocalTime[] horarios = {LocalTime.of(17, 40), LocalTime.of(19, 30), LocalTime.of(21, 20)};

                        System.out.println("Escolha um horário da sessão:");
                        for (int i = 0; i < horarios.length; i++) {
                            System.out.println((i + 1) + ". " + horarios[i]);
                        }

                        int escolhaHorario = obterEscolha(scanner, horarios.length, "Escolha o número do horário desejado: ");

                        if (escolhaHorario >= 1 && escolhaHorario <= horarios.length) {
                            System.out.println("Você escolheu o horário das " + horarios[escolhaHorario - 1] + ".");

                            String sala = obterSalaExibicao(filmes[escolhaFilme - 1]);
                            System.out.println("O filme está em exibição na sala " + sala + ".");

                            int quantidadeInteira = obterQuantidade(scanner, "O valor da entrada inteira é de 32,00R$, informe a quantidade desejada: ");
                            int quantidadeMeia = obterQuantidade(scanner, "O valor da meia-entrada é de 16,00R$, informe a quantidade desejada: ");

                            BigDecimal totalPagar = calcularTotal(quantidadeInteira, quantidadeMeia);
                            System.out.println("Resumo do pedido:");
                            System.out.println("Filme: " + filmes[escolhaFilme - 1]);
                            System.out.println("Horário da sessão: " + horarios[escolhaHorario - 1]);
                            System.out.println("Sala de exibição: " + sala);
                            System.out.println("Ingressos inteiros: " + quantidadeInteira);
                            System.out.println("Ingressos meia-entrada: " + quantidadeMeia);
                            System.out.println("Total a pagar: R$ " + totalPagar);

                            return;
                        } else {
                            System.out.println("Escolha inválida. Por favor, escolha um número válido para o horário.");
                        }
                    } else {
                        System.out.println("Escolha inválida. Por favor, escolha um número válido para o filme.");
                    }
                } else if (resposta == 2) {
                    System.out.println("Volte sempre!");
                    System.exit(0);
                } else {
                    System.out.println("Resposta inválida. Por favor, digite 1 para 'sim' ou 2 para 'não'.");
                }
            } while (true);
        }
    }

    private static int obterResposta(Scanner scanner) {
        int resposta = 0;

        do {
            try {
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
    private static int obterEscolha(Scanner scanner, int max, String mensagem) {
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

    private static int obterQuantidade(Scanner scanner, String mensagem) {
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

    private static BigDecimal calcularTotal(int quantidadeInteira, int quantidadeMeia) {
        BigDecimal precoInteira = new BigDecimal("32.00");
        BigDecimal precoMeia = new BigDecimal("16.00");
        BigDecimal totalInteira = precoInteira.multiply(new BigDecimal(quantidadeInteira));
        BigDecimal totalMeia = precoMeia.multiply(new BigDecimal(quantidadeMeia));

        return totalInteira.add(totalMeia);
    }

    private static String obterSalaExibicao(String filme) {
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
