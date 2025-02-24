package br.com.alura.clientelo.pedido;

import br.com.alura.clientelo.cliente.ClienteFiel;
import br.com.alura.clientelo.cliente.ClienteLucrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("""
            select i.produto.nome as nome, sum(i.quantidade) as quantidade
            from ItemDePedido i
            group by i.produto.nome
            order by sum(i.quantidade) desc
            limit 3
           """)
    List<ProdutoMaisVendido> listaProdutosMaisVendidos();

    @Query("""
            select p.categoria.nome as nome, 
                   sum(i.quantidade) as quantidadeVendida, 
                   sum(i.quantidade * i.preco) as montante
            from ItemDePedido i
            join i.produto p
            group by p.categoria.nome
            order by p.categoria.nome
           """)
    List<ResumoDeVendaPorCategoria> resumeVendasPorCategoria();

    @Query("""
            select c.nome as nome,
                   count(p) as quantidadeDePedidosFeitos
            from Pedido p
            join p.cliente c
            group by c.nome
            order by count(p) desc, c.nome
           """)
    List<ClienteFiel> listaClientesMaisFieis();

    @Query("""
            select c.nome as nome,
                   count(p) as numeroDePedidos,
                   sum(i.preco * i.quantidade) as montanteGasto
            from ItemDePedido i
            join i.pedido p
            join p.cliente c
            group by c.nome
            order by sum(i.preco * i.quantidade) desc
           """)
    List<ClienteLucrativo> listaClientesMaisLucrativos();
}
