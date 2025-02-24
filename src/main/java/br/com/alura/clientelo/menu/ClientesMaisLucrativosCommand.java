package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientesMaisLucrativosCommand implements FuncionalidadeCommand {

    private PedidoRepository pedidoRepository;

    @Override
    public void executa() {

        pedidoRepository.listaClientesMaisLucrativos()
                .forEach(clienteRelatorio -> {
                    System.out.println("NOME: " + clienteRelatorio.getNome());
                    System.out.println("Nº DE PEDIDOS: " + clienteRelatorio.getNumeroDePedidos());
                    System.out.println("MONTANTE GASTO: " + FormatUtils.formataParaReal(clienteRelatorio.getMontanteGasto()));
                    System.out.println();
                });
    }

    @Override
    public String getDescricao() {
        return "Clientes mais lucrativos";
    }
}
