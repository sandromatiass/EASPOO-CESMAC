package cinema.model;

import java.math.BigDecimal;

public class Ingresso {
    private Filme filme;
    private String horario;
    private int quantidadeInteira;
    private int quantidadeMeia;

    public Ingresso(Filme filme, String horario, int quantidadeInteira, int quantidadeMeia) {
        this.filme = filme;
        this.horario = horario;
        this.quantidadeInteira = quantidadeInteira;
        this.quantidadeMeia = quantidadeMeia;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getQuantidadeInteira() {
        return quantidadeInteira;
    }

    public void setQuantidadeInteira(int quantidadeInteira) {
        this.quantidadeInteira = quantidadeInteira;
    }

    public int getQuantidadeMeia() {
        return quantidadeMeia;
    }

    public void setQuantidadeMeia(int quantidadeMeia) {
        this.quantidadeMeia = quantidadeMeia;
    }

    public BigDecimal calcularTotal() {
        BigDecimal precoInteira = new BigDecimal("24.00");
        BigDecimal precoMeia = new BigDecimal("12.00");
        BigDecimal totalInteira = precoInteira.multiply(new BigDecimal(quantidadeInteira));
        BigDecimal totalMeia = precoMeia.multiply(new BigDecimal(quantidadeMeia));

        return totalInteira.add(totalMeia);
    }
}
