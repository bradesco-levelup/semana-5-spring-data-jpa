package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.produto.ProdutoRepository;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProdutosMaisCarosPorCategoriaCommand implements FuncionalidadeCommand {

    private ProdutoRepository produtoRepository;


    @Override
    public void executa() {
        produtoRepository.listaProdutosMaisCarosPorCategoria()
                .forEach(produto -> {
                    System.out.println("CATEGORIA: " + produto.getCategoria().getNome());
                    System.out.println("PRODUTO: " + produto.getNome());
                    System.out.println("PREÇO: " + FormatUtils.formataParaReal(produto.getPreco()));
                    System.out.println();
                });
    }

    @Override
    public String getDescricao() {
        return "Produtos mais caros por categoria";
    }
}
