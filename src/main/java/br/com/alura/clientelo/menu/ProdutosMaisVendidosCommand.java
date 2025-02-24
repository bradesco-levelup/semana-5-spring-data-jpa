package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.pedido.ProdutoMaisVendido;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class ProdutosMaisVendidosCommand implements FuncionalidadeCommand {

    private final PedidoRepository pedidoRepository;

    @Transactional
    @Override
    public void executa() {
        pedidoRepository.listaProdutosMaisVendidos()
                .forEach(produtoMaisVendido -> {
                    System.out.println("PRODUTO: " + produtoMaisVendido.getNome());
                    System.out.println("QUANTIDADE: " + produtoMaisVendido.getQuantidade());
                    System.out.println();
                });
    }

    @Override
    public String getDescricao() {
        return "Produtos mais vendidos";
    }
}
