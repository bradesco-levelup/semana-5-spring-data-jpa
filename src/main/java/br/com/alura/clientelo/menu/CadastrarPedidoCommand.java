package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.cliente.Cliente;
import br.com.alura.clientelo.cliente.ClienteRepository;
import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import br.com.alura.clientelo.produto.Produto;
import br.com.alura.clientelo.produto.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class CadastrarPedidoCommand implements FuncionalidadeCommand {

    private Scanner scanner;

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;

    @Transactional
    @Override
    public void executa() {
        Produto produto = escolheProduto();
        Cliente cliente = escolheCliente();

        int quantidade = escolheQuantidade();
        LocalDate data = escolheData();

        Pedido novoPedido = new Pedido(data, cliente);
        novoPedido.adicionaItem(produto, quantidade);

        Pedido salvo = pedidoRepository.save(novoPedido);
        System.out.println("Pedido cadastrado com sucesso! ID: " + salvo.getId());
    }

    private LocalDate escolheData() {
        System.out.print("Data (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(scanner.nextLine(), formatter);
        return data;
    }

    private int escolheQuantidade() {
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());
        return quantidade;
    }

    private Cliente escolheCliente() {
        System.out.print("Informe o código do cliente: ");
        Long codigoDoCliente = scanner.nextLong();
        scanner.nextLine();

        Cliente cliente = clienteRepository.findById(codigoDoCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));

        System.out.println("Cliente escolhido: " + cliente.getNome());
        return cliente;
    }

    private Produto escolheProduto() {
        System.out.print("Informe o código do produto: ");
        Long codigoDoProduto = scanner.nextLong();
        scanner.nextLine();

        Produto produto = produtoRepository.findById(codigoDoProduto)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado!"));

        System.out.println("Produto escolhido: " + produto.getNome());
        return produto;
    }

    @Override
    public String getDescricao() {
        return "Cadastrar pedido";
    }

}
