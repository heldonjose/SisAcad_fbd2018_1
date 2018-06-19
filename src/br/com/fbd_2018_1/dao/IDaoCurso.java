/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.dao;

import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.exceptions.DaoException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IDaoCurso {
    public void salvar(Curso curso) throws DaoException;
    public void editar(Curso curso);
    public Curso buscarPorId(int id)throws DaoException;
    public Curso buscarPorCodigo(String codigo);
    public List<Curso> buscarPorBusca(String busca);
}
