package cinema.model;

import java.math.BigDecimal;


public class IngressoVIP extends Ingresso {
    public IngressoVIP(Filme filme, String horario, int quantidadeInteira, int quantidadeMeia) {
        super(filme, horario, quantidadeInteira, quantidadeMeia);
    }

    @Override
    public BigDecimal calcularTotal() {
        BigDecimal precoInteiraVIP = new BigDecimal("48.00");
        BigDecimal precoMeiaVIP = new BigDecimal("24.00");
        BigDecimal totalInteiraVIP = precoInteiraVIP.multiply(new BigDecimal(getQuantidadeInteira()));
        BigDecimal totalMeiaVIP = precoMeiaVIP.multiply(new BigDecimal(getQuantidadeMeia()));

        return totalInteiraVIP.add(totalMeiaVIP);
    }

    @Override
    public void acessoLanchonete() {
        System.out.println("Lanchonete do cinema liberada.");
    }
}