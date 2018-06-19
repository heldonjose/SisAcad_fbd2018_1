/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.dao;

import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.exceptions.DaoException;
import br.com.fbd_2018_1.sql.SQLConnection;
import br.com.fbd_2018_1.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class DaoCurso implements IDaoCurso {

    private Connection conexao;
    private PreparedStatement statement;

    @Override
    public void salvar(Curso curso) throws DaoException {
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Curso.INSERT_ALL);

            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getCodigo());
            statement.setInt(3, curso.getCargaHoraria());
            statement.execute();
            this.conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO SALVAR CURSO - Contate o ADM");
        }
    }

    @Override
    public void editar(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso buscarPorId(int id) throws DaoException {
//            select * from curso2  where id = 1
        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Curso.SELECT_ID);
            this.statement.setInt(1, id);

            ResultSet result = this.statement.executeQuery();
            Curso curso;
            if (result.next()) {
                curso = new Curso();
                curso.setId(result.getInt(1));
                curso.setNome(result.getString(2));
                curso.setCodigo(result.getString(3));
                curso.setCargaHoraria(result.getInt(4));
            } else {
                throw new DaoException("CURSO NÃO EXISTE");
            }
            this.conexao.close();
            return curso;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
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

}
