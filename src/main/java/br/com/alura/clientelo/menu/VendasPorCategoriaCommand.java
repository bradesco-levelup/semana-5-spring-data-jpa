package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class VendasPorCategoriaCommand implements FuncionalidadeCommand {

    private PedidoRepository pedidoRepository;

    @Override
    public void executa() {
        pedidoRepository.resumeVendasPorCategoria()
                .forEach(resumo -> {
                    System.out.println("CATEGORIA: " + resumo.getNome());
                    System.out.println("QUANTIDADE VENDIDA: " + resumo.getQuantidadeVendida());
                    System.out.println("MONTANTE: " + FormatUtils.formataParaReal(resumo.getMontante()));
                    System.out.println();
                });
    }

    @Override
    public String getDescricao() {
        return "Vendas por categoria";
    }


}
