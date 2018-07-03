/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.entidade.enums;

import static br.com.fbd_2018_1.entidade.enums.Sexo.FEMININO;
import static br.com.fbd_2018_1.entidade.enums.Sexo.MASCULINO;
import static br.com.fbd_2018_1.entidade.enums.Sexo.OUTROS;

/**
 *
 * @author prof Heldon
 */
public enum TipoContato {

    EMAIL("EMAIL"),
    TELEFONE("TELEFONE"),
    FACEBOOK("FACEBOOK");

    public static TipoContato getContato(String string) {

        switch (string) {
            case "EMAIL":
                return EMAIL;
            case "TELEFONE":
                return TELEFONE;
            case "FACEBOOK":
                return FACEBOOK;
        }
        return null;

    }

    private String descricao;

    private TipoContato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
