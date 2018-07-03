/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.entidade.enums;

/**
 *
 * @author prof Heldon
 */
public enum Sexo {

    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    OUTROS("OUTROS");

    public static Sexo getSexo(String string) {

        switch (string) {
            case "MASCULINO":
                return MASCULINO;
            case "FEMININO":
                return FEMININO;
            case "OUTROS":
                return OUTROS;
        }
        return null;

    }

    private String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
