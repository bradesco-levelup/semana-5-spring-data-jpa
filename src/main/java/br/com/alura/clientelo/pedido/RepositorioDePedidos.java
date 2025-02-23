package br.com.alura.clientelo.pedido;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDePedidos {

    private static final List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> listaTodos() {
        return pedidos;
    }

    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido excluiPorIndice(int indice) {
        if (indice < 0 || indice >= pedidos.size()) {
            throw new IllegalArgumentException("Índice inválido!");
        }

        return pedidos.remove(indice);
    }
}
