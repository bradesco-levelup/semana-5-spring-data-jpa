package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientesMaisFieisCommand implements FuncionalidadeCommand {

    private PedidoRepository pedidoRepository;

    @Override
    public void executa() {
        pedidoRepository.listaClientesMaisFieis()
                .forEach(clienteFiel -> {
                    System.out.println("Nº DE PEDIDOS: " + clienteFiel.getQuantidadeDePedidosFeitos());
                    System.out.println("NOME: " + clienteFiel.getNome());
                    System.out.println();
                });
    }

    @Override
    public String getDescricao() {
        return "Clientes mais fieis";
    }
}
