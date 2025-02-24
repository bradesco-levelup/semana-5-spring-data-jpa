package br.com.alura.clientelo.menu;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private RelatorioSinteticoCommand relatorioSinteticoCommand;

    @Autowired
    private ProdutosMaisVendidosCommand produtosMaisVendidosCommand;

    @Autowired
    private SairCommand sairCommand;

    @Autowired
    private VendasPorCategoriaCommand vendasPorCategoriaCommand;

    @Autowired
    private ProdutosMaisCarosPorCategoriaCommand produtosMaisCarosPorCategoriaCommand;

    @Autowired
    private ClientesMaisFieisCommand clientesMaisFieisCommand;

    @Autowired
    private ClientesMaisLucrativosCommand clientesMaisLucrativosCommand;

    @Autowired
    private CadastrarPedidoCommand cadastrarPedidoCommand;

    @Autowired
    private ExcluirPedidoCommand excluirPedidoCommand;

    @Autowired
    private Scanner scanner;

    private int opcaoAtual = -1;
    private Map<Integer, FuncionalidadeCommand> opcoes = new LinkedHashMap<>();

    @PostConstruct
    public void inicializaOpcoes() {
        opcoes.put(1, relatorioSinteticoCommand);
        opcoes.put(2, produtosMaisVendidosCommand);
        opcoes.put(3, vendasPorCategoriaCommand);
        opcoes.put(4, produtosMaisCarosPorCategoriaCommand);
        opcoes.put(5, clientesMaisFieisCommand);
        opcoes.put(6, clientesMaisLucrativosCommand);
        opcoes.put(7, cadastrarPedidoCommand);
        opcoes.put(8, excluirPedidoCommand);
        opcoes.put(0, sairCommand);
    }

    public FuncionalidadeCommand opcaoEscolhida() {
        opcoes.forEach((key, value) -> {
            System.out.println(key + " - " + value.getDescricao());
        });

        System.out.print("Digite a opção desejada: ");
        opcaoAtual = scanner.nextInt();

        scanner.nextLine();
        return opcoes.getOrDefault(opcaoAtual, new OpcaoInvalidaCommand());
    }

    public boolean saiu() {
        return opcaoAtual == 0;
    }
}
