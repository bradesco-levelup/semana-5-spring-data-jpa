package br.com.alura.clientelo.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
public class Categoria {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

}
