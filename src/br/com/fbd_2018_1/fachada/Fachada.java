/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.fachada;

import br.com.fbd_2018_1.business.BusinessAluno;
import br.com.fbd_2018_1.business.BusinessCurso;
import br.com.fbd_2018_1.business.IBusinessAluno;
import br.com.fbd_2018_1.business.IBusinessCurso;
import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.exceptions.BusinessException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class Fachada implements IFachada {

    private IBusinessAluno businessAluno;
    private IBusinessCurso businessCurso;

    private static Fachada fachada;

    public static Fachada getInstance() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    private Fachada() {
        businessAluno = new BusinessAluno();
        businessCurso = new BusinessCurso();
    }

    @Override
    public void salvarOuEditarCurso(Curso curso) throws BusinessException {
        this.businessCurso.salvarOuEditar(curso);
    }

    @Override
    public Curso buscarCursoPorId(int id) throws BusinessException {
        return this.businessCurso.buscarPorId(id);
    }

    @Override
    public Curso buscarCursoPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> buscarCursoPorBusca(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno salvarOuEditarAluno(Aluno aluno) throws BusinessException{

        return this.businessAluno.salvarOuEditar(aluno);

    }

    @Override
    public Aluno buscarAlunoPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno buscarAlunoPorCpf(String cpf) throws BusinessException {
           return businessAluno.buscarPorCpf(cpf);
    
    }

    @Override
    public List<Aluno> buscarAlunoPorBusca(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
