package com.example.dev.fretex;

/**
 * Created by dev on 26/03/2018.
 */

public class Usuario {
    private  String nome;
    private String cpf;
    private Cadastro cadastro;

    public Usuario(String nome,String cpf, Cadastro cadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.cadastro = cadastro;
    }
}
