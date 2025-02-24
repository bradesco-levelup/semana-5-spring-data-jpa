package br.com.alura.clientelo.menu;

import org.springframework.stereotype.Component;

@Component
public class SairCommand implements FuncionalidadeCommand {

    @Override
    public void executa() {
        System.out.println("Saindo do sistema...");
        System.exit(0);
    }

    @Override
    public String getDescricao() {
        return "SAIR";
    }
}
