/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.dao;

import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.exceptions.DaoException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IDaoAluno {

    public Aluno salvar(Aluno aluno) throws DaoException;

    public void editar(Aluno aluno);

    public Aluno buscarPorId(int id);

    public Aluno buscarPorCpf(String cpf) throws DaoException;

    public List<Aluno> buscarPorBusca(String busca);

}
