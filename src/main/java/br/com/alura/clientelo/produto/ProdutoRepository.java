package br.com.alura.clientelo.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("""
            select p
            from Produto p
            join fetch p.categoria c
            where p.preco = (select max(p2.preco) from Produto p2 where p2.categoria = p.categoria)
            order by p.categoria.nome
           """)
    List<Produto> listaProdutosMaisCarosPorCategoria();
}
