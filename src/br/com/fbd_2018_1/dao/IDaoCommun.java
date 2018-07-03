/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.dao;

import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Contato;
import br.com.fbd_2018_1.entidade.Endereco;
import br.com.fbd_2018_1.exceptions.DaoException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IDaoCommun {

    public void salvarEndereco(Endereco endereco) throws DaoException;

    public int getCurrentValorTabela(String nomeTabela) throws DaoException;

    public void salvarContato(Contato contato, int idAluno) throws DaoException;

    public List<Contato> getContatos(Integer id) throws DaoException;

}
