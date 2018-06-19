/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.business;

import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.exceptions.BusinessException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
 public interface IBusinessCurso {

    public void salvarOuEditar(Curso curso) throws BusinessException;

    public Curso buscarPorId(int id)throws BusinessException;

    public Curso buscarPorCodigo(String codigo);

    public List<Curso> buscarPorBusca(String busca);
}
