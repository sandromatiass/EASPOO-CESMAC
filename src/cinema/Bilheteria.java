package cinema;
import cinema.controller.MenuController;
import cinema.model.Filme;
import cinema.model.Ingresso;

public class Bilheteria {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();

        menuController.exibirSaudacao();

        int resposta = menuController.obterResposta();

        if (resposta == 1) {
            int escolhaFilme = menuController.selecionarFilme();
            int escolhaHorario = menuController.selecionarHorario();

            Filme filmeEscolhido = obterFilmePorIndice(escolhaFilme);
            String horarioEscolhido = obterHorarioPorIndice(escolhaHorario);

            Ingresso ingresso = menuController.comprarIngresso(filmeEscolhido, horarioEscolhido);

            menuController.exibirResumo(ingresso);
        } else if (resposta == 2) {
            menuController.despedida();
            System.exit(0);
        } else {
            System.out.println("Resposta inválida. Por favor, digite 1 para 'sim' ou 2 para 'não'.");
        }

        menuController.fecharScanner();
    }

    private static Filme obterFilmePorIndice(int indice) {
        Filme filme = null;
    
        switch (indice) {
            case 1:
                filme = new Filme("Matrix Revolution", "Diretor1", "Descrição1", "Ação", 150);
                break;
            case 2:
                filme = new Filme("Constantine", "Diretor2", "Descrição2", "Fantasia", 130);
                break;
            case 3:
                filme = new Filme("Harry Potter e a Pedra Filosofal", "Diretor3", "Descrição3", "Fantasia", 152);
                break;
            case 4:
                filme = new Filme("Sete Vidas", "Diretor4", "Descrição4", "Drama", 118);
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
