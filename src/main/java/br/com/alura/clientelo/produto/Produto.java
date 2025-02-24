package br.com.alura.clientelo.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Produto {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;

    @ManyToOne
    private Categoria categoria;
}
