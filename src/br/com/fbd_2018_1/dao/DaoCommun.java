/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.dao;

import br.com.fbd_2018_1.entidade.Aluno;
import br.com.fbd_2018_1.entidade.Contato;
import br.com.fbd_2018_1.entidade.Curso;
import br.com.fbd_2018_1.entidade.Endereco;
import br.com.fbd_2018_1.entidade.enums.TipoContato;
import br.com.fbd_2018_1.exceptions.DaoException;
import br.com.fbd_2018_1.sql.SQLConnection;
import br.com.fbd_2018_1.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class DaoCommun implements IDaoCommun {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvarEndereco(Endereco endereco) throws DaoException {

        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT_ALL);
            statement.setString(1, endereco.getRua());
            statement.setString(2, endereco.getNumero());
            statement.setString(3, endereco.getBairro());
            statement.setString(4, endereco.getCidade());
            statement.setString(5, endereco.getEstado());
            statement.execute();
            this.conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO SALVAR ENDERECO - Contate o ADM");
        }
    }

    @Override
    public int getCurrentValorTabela(String nomeTabela) throws DaoException {

        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement("select id from " + nomeTabela + " order by id desc limit 1");

            result = this.statement.executeQuery();
            int id;
            if (result.next()) {
                id = result.getInt(1);
            } else {
                throw new DaoException("Não há registro nessa tabela");
            }
            this.conexao.close();
            return id;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR " + nomeTabela + " - Contate o ADM");
        }

    }

    @Override
    public void salvarContato(Contato contato, int idAluno) throws DaoException {

        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Contato.INSERT_ALL);
            statement.setString(1, contato.getTipoContato().getDescricao());
            statement.setString(2, contato.getDescricao());
            statement.setInt(3, idAluno);
            statement.execute();
            this.conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO SALVAR ENDERECO - Contate o ADM");
        }

    }

    @Override
    public List<Contato> getContatos(Integer id) throws DaoException {

        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Contato.SELECT_CONTATO_ALUNO);
            this.statement.setInt(1, id);

            result = this.statement.executeQuery();
            List<Contato> contatos = new ArrayList<>();
            Contato contato;
            while (result.next()) {

                contato = new Contato();
                contato.setId(result.getInt(1));
                contato.setTipoContato(TipoContato.getContato(result.getString(2)));
                contato.setDescricao(result.getString(3));
                contatos.add(contato);
            }
            this.conexao.close();

            return contatos;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR CONTATOS - Contate o ADM");
        }

    }
}
