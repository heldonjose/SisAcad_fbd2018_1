/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.business;

import br.com.fbd_2018_1.dao.DaoCurso;
import br.com.fbd_2018_1.dao.IDaoCurso;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.exceptions.BusinessException;
import br.com.fbd_2018_1.exceptions.DaoException;
import br.com.fbd_2018_1.exceptions.ValidacaoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class BusinessCurso implements IBusinessCurso {

    private IDaoCurso dao;

    public BusinessCurso() {
        this.dao = new DaoCurso();
    }

    @Override
    public void salvarOuEditar(Curso curso) throws BusinessException {
        try {
            validarCurso(curso);
            this.dao.salvar(curso);
        } catch (Exception ex) {
            throw new BusinessException(ex.getMessage());
        }

    }

    @Override
    public Curso buscarPorId(int id) throws BusinessException {
        try {
            Curso c = this.dao.buscarPorId(id);
            return c;
        } catch (DaoException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public Curso buscarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> buscarPorBusca(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarCurso(Curso curso) throws ValidacaoException {
        if (curso.getCodigo().equals("10")) {
            throw new ValidacaoException("Código já existe");
        }

    }

}
