package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.relatorio.RelatorioSintetico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class RelatorioSinteticoCommand implements FuncionalidadeCommand {

    private PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public void executa() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        RelatorioSintetico relatorioSintetico = RelatorioSintetico.geraRelatorio(pedidos);
        relatorioSintetico.exibir();
    }

    @Override
    public String getDescricao() {
        return "Relatório sintético";
    }
}
