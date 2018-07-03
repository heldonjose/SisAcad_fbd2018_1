/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.entidade;

import br.com.fbd_2018_1.entidade.enums.TipoContato;

/**
 *
 * @author prof Heldon
 */
public class Contato {
    
    private Integer id;
    //EMAIL, TELEFONE, FACEBOOk...
    private TipoContato tipoContato;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", tipoContato=" + tipoContato + ", descricao=" + descricao + '}';
    }
    
    
    
    
}
