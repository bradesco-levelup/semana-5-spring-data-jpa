package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.cliente.Cliente;
import br.com.alura.clientelo.produto.Categoria;
import br.com.alura.clientelo.produto.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDePedido> itens = new ArrayList<>();

    public Pedido(LocalDate data, Cliente cliente) {
        this.cliente = cliente;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValorTotal() {
        return itens.stream()
                .map(ItemDePedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public boolean isMaisBaratoQue(Pedido outroPedido) {
        return getValorTotal().compareTo(outroPedido.getValorTotal()) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {
        return getValorTotal().compareTo(outroPedido.getValorTotal()) > 0;
    }

    public int getQuantidadeDeProdudosVendidos() {
        return itens.stream()
                .mapToInt(ItemDePedido::getQuantidade)
                .sum();
    }

    public Collection<String> getCategorias() {
        return itens.stream()
                .map(ItemDePedido::getProduto)
                .map(Produto::getCategoria)
                .map(Categoria::getNome)
                .collect(Collectors.toSet());
    }

    public ItemDePedido adicionaItem(Produto produto, int quantidade) {
        ItemDePedido item = new ItemDePedido(this, produto, quantidade);
        itens.add(item);

        return item;
    }
}
