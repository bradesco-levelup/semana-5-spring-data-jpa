package br.com.alura.clientelo.menu;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@Component
@AllArgsConstructor
public class ExcluirPedidoCommand implements FuncionalidadeCommand {

    private Scanner scanner;
    private PedidoRepository pedidoRepository;

    @Transactional
    @Override
    public void executa() {
        System.out.print("Digite o id do pedido que deseja excluir: ");
        Long idDoPedido = scanner.nextLong();
        scanner.nextLine();

        try {
            pedidoRepository.deleteById(idDoPedido);
            System.out.println("Pedido excluído!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String getDescricao() {
        return "Excluir pedido";
    }
}
