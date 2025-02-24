package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "item_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDePedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    @Column(name = "preco_compra")
    private BigDecimal preco;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    public ItemDePedido(Pedido pedido, Produto produto, int quantidade) {
        this(null,quantidade, produto.getPreco(), pedido, produto);
    }

    public BigDecimal getValorTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
