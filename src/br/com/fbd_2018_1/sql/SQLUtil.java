/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.sql;

/**
 *
 * @author prof Heldon
 */
public class SQLUtil {

    public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/aulafbd";
    public static String USUARIO_POSTGRES = "postgres";
    public static String SENHA_POSTGRES = "postgres";

    public static class Aluno {

        public static String INSERT_ALL = "insert into aluno (nome,cpf,sexo,active,data_nascimento,endereco_id) "
                + "values (?,?,?,?,?,?) ";
        
        public static String EDITAR_ALL = "update aluno set nome =?, cpf=?, .... WHERE id = ?";
        
         public static final String SELECT_ALUNO_ENDERO_CPF = "select * from aluno a, endereco e where a.endereco_id=e.id and cpf = ?";

    }

    public static class Endereco {

        public static String INSERT_ALL = "insert into endereco (rua, numero,bairro,cidade,estado) "
                + "values (?,?,?,?,?) ";
    }
    public static class Contato {

        public static String INSERT_ALL = "insert into contato (tipocontato, descricao,aluno_id) "
                + "values (?,?,?) ";
        public static String SELECT_CONTATO_ALUNO = "select * from contato where aluno_id = ?";
    }

    public static class Curso {

        public static final String INSERT_ALL = "insert into curso (nome, codigo, carga_horaria) "
                + "values (?,?,?) ";

        public static final String SELECT_ID = "select * from curso where id = ?";

    }

    private SQLUtil() {

    }

}
