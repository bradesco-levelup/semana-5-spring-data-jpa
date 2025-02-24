package br.com.alura.clientelo;

import br.com.alura.clientelo.menu.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class ClienteloApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ClienteloApplication.class);

    @Autowired
    private RelatorioSinteticoCommand relatorioSinteticoCommand;

    @Autowired
    private Menu menu;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClienteloApplication.class, args);
    }

    public void run(String... args) throws Exception {
        while (!menu.saiu()) {
            FuncionalidadeCommand comando = menu.opcaoEscolhida();
            comando.executa();

            System.out.println("========");
            System.out.println();
        }
    }

}

