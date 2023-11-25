package cinema;
import cinema.controller.MenuController;
import cinema.model.Filme;
import cinema.model.Ingresso;
import cinema.model.IngressoVIP;

public class Bilheteria {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();

        menuController.exibirSaudacao();

        int resposta = menuController.obterResposta();

        if (resposta == 1) {
            int escolhaTipoIngresso = menuController.selecionarTipoIngresso();

            if (escolhaTipoIngresso == 1) {

                int escolhaFilme = menuController.selecionarFilme();
                int escolhaHorario = menuController.selecionarHorario();

                Filme filmeEscolhido = obterFilmePorIndice(escolhaFilme);
                String horarioEscolhido = obterHorarioPorIndice(escolhaHorario);

                Ingresso ingresso = menuController.comprarIngresso(filmeEscolhido, horarioEscolhido);

                menuController.exibirResumo(ingresso);
            } else if (escolhaTipoIngresso == 2) {
                int escolhaFilme = menuController.selecionarFilme();
                int escolhaHorario = menuController.selecionarHorario();

                Filme filmeEscolhido = obterFilmePorIndice(escolhaFilme);
                String horarioEscolhido = obterHorarioPorIndice(escolhaHorario);

                IngressoVIP ingressoVIP = menuController.comprarIngressoVIP(filmeEscolhido, horarioEscolhido);

                menuController.exibirResumo(ingressoVIP);
                    } else {
                        System.out.println("Opção inválida para tipo de ingresso.");
                    }
                } else if (resposta == 2) {
                    menuController.despedida();
                    System.exit(0);
                } else {
                    System.out.println("Resposta inválida. Por favor, digite 1 para 'sim' ou 2 para 'não'.");
                }

            menuController.fecharScanner();
        }

    public static Filme obterFilmePorIndice(int indice) {
        Filme filme = null;
    
        switch (indice) {
            case 1:
                filme = new Filme("Matrix Revolution", "Lana Wachowski, Lilly Wachowski", "Em um futuro distópico, Neo luta contra máquinas que escravizaram a humanidade.", "Ação", 150, false);
                break;
            case 2:
                filme = new Filme("Constantine", "Francis Lawrence", "Um exorcista tenta ganhar sua entrada no céu, mas acaba combatendo forças demoníacas.", "Fantasia", 130, false);
                break;
            case 3:
                filme = new Filme("Harry Potter e a Pedra Filosofal", "Chris Columbus", "Um jovem bruxo descobre seu destino enquanto estuda em uma escola de magia.", "Fantasia", 152, false);
                break;
            case 4:
                filme = new Filme("Sete Vidas", "Gabriele Muccino", "Um homem comete um ato heroico e busca redenção ao mudar a vida de sete pessoas.", "Drama", 118, false);
                break;
            default:
                System.out.println("Opção inválida para filme.");
        }
    
        return filme;
    }
    
    private static String obterHorarioPorIndice(int indice) {
        String horario = null;
    
        switch (indice) {
            case 1:
                horario = "17:40";
                break;
            case 2:
                horario = "19:30";
                break;
            case 3:
                horario = "21:20";
                break;
            default:
                System.out.println("Opção inválida para horário.");
        }
    
        return horario;
    }
    
}
