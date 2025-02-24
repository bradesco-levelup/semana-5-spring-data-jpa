package br.com.alura.clientelo.pedido;

import java.math.BigDecimal;

public interface ResumoDeVendaPorCategoria {

    String getNome();
    Integer getQuantidadeVendida();
    BigDecimal getMontante();
}
