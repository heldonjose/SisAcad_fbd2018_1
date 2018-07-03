/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.business;

import br.com.fbd_2018_1.dao.DaoAluno;
import br.com.fbd_2018_1.dao.IDaoAluno;
import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.exceptions.BusinessException;
import br.com.fbd_2018_1.exceptions.DaoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Aluno salvarOuEditar(Aluno aluno) throws BusinessException{
        try {
            if (validarAluno(aluno)) {
                if (aluno.getId() == null) {
                    
                    aluno = dao.salvar(aluno);
                    
                } else {
                    dao.editar(aluno);
                }
                
            }
            return aluno;
        } catch (DaoException ex) {
            throw new BusinessException(ex.getMessage());
        }
        
    }
    
    @Override
    public Aluno buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Aluno buscarPorCpf(String cpf) throws BusinessException{
  
        try {
            return dao.buscarPorCpf(cpf);
        } catch (DaoException ex) {
          throw new BusinessException(ex.getMessage());
        }
   
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
