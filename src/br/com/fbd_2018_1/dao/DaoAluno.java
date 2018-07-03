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
import br.com.fbd_2018_1.entidade.enums.Sexo;
import br.com.fbd_2018_1.exceptions.DaoException;
import br.com.fbd_2018_1.sql.SQLConnection;
import br.com.fbd_2018_1.sql.SQLUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class DaoAluno implements IDaoAluno {

    private Connection conexao;
    private PreparedStatement statement;
    private IDaoCommun communDao = new DaoCommun();
    private ResultSet result;

    @Override
    public Aluno salvar(Aluno aluno) throws DaoException {

        try {

            communDao.salvarEndereco(aluno.getEndereco());
            int id_endereco = communDao.getCurrentValorTabela("endereco");

            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Aluno.INSERT_ALL);

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCpf());
            statement.setString(3, aluno.getSexo().getDescricao());
            statement.setBoolean(4, aluno.getActivo());
            statement.setDate(5, new Date(aluno.getDataNascimento().getTime()));
            statement.setInt(6, id_endereco);

            statement.execute();

            int id_aluno = communDao.getCurrentValorTabela("aluno");
            for (Contato c : aluno.getContatos()) {
                communDao.salvarContato(c, id_aluno);
            }

            this.conexao.close();

            aluno.setId(id_aluno);
            aluno.getEndereco().setId(id_endereco);
            return aluno;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO SALVAR Aluno - Contate o ADM");
        }

    }

    @Override
    public Aluno buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Aluno buscarPorCpf(String cpf) throws DaoException {

        try {
            this.conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
            this.statement = conexao.prepareStatement(SQLUtil.Aluno.SELECT_ALUNO_ENDERO_CPF);
            this.statement.setString(1, cpf);

            result = this.statement.executeQuery();
            Aluno aluno;
            Endereco end;
            if (result.next()) {
                aluno = new Aluno();

                aluno.setId(result.getInt(1));
                aluno.setCpf(result.getString(2));
                aluno.setNome(result.getString(3));
                aluno.setDataNascimento(result.getDate(4));
                aluno.setSexo(Sexo.getSexo(result.getString(5)));
                aluno.setActivo(result.getBoolean(6));
                end = new Endereco();
                end.setId(result.getInt(7));
                end.setBairro(result.getString(9));
                end.setCidade(result.getString(10));
                end.setRua(result.getString(11));
                end.setEstado(result.getString(12));
                end.setNumero(result.getString(13));
                aluno.setEndereco(end);
            } else {
                throw new DaoException("ALUNO NÃO EXISTE");
            }
            this.conexao.close();

            List<Contato> contatos = communDao.getContatos(aluno.getId());
            aluno.setContatos(contatos);
            return aluno;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR CURSO - Contate o ADM");
        }

    }

    @Override
    public List<Aluno> buscarPorBusca(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
