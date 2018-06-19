/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.fachada;

import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.exceptions.BusinessException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IFachada {

    public void salvarOuEditarCurso(Curso curso)  throws BusinessException;

    public Curso buscarCursoPorId(int id) throws BusinessException;

    public Curso buscarCursoPorCodigo(String codigo);

    public List<Curso> buscarCursoPorBusca(String busca);

    public void salvarOuEditarAluno(Aluno aluno);

    public Aluno buscarAlunoPorId(int id);

    public Aluno buscarAlunoPorCpf(String cpf);

    public List<Aluno> buscarAlunoPorBusca(String busca);

}
