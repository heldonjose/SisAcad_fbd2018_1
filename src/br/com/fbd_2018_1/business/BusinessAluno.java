/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.business;

import br.com.fbd_2018_1.dao.DaoAluno;
import br.com.fbd_2018_1.dao.IDaoAluno;
import br.com.fbd_2018_1.entidade.Aluno;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class BusinessAluno implements IBusinessAluno {

    private static IDaoAluno dao;

    public BusinessAluno() {
       dao = new DaoAluno();
    }

    @Override
    public void salvarOuEditar(Aluno aluno) {

        if (validarAluno(aluno)) {
            if(aluno.getId()==null){
                
            dao.salvar(aluno);
            }else{
                dao.editar(aluno);
            }

        }

    }

    @Override
    public Aluno buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno buscarPorCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> buscarPorBusca(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validarAluno(Aluno aluno) {
        //Validações
        return true;

    }

}
