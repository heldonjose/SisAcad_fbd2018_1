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

    public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/aula";
    public static String USUARIO_POSTGRES = "postgres";
    public static String SENHA_POSTGRES = "postgres";

    static class Aluno {
    public static String INSERT_ALL = "insert into aluno (nome, codigo, carga_horaria) "
                + "values (?,?,?) ";
    }

    public static class Curso {

        public static final String INSERT_ALL = "insert into curso2 (nome, codigo, carga_horaria) "
                + "values (?,?,?) ";
        
        public static final String SELECT_ID = "select * from curso2 where id = ?";

    }

    private SQLUtil() {

    }

}
