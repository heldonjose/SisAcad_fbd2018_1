
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fbd_2018_1.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class SQLConnection {

    public static final String NOME_BD_CONNECTION_POSTGRESS = "POSTGRES";
    public static final String NOME_BD_CONNECTION_MYSQL = "MYSQL";

    private static Connection conexao = null;

    private SQLConnection() {
    }

    public static synchronized Connection getConnectionInstance(String bd) {
        try {
            if (conexao == null || conexao.isClosed()) {

                switch (bd) {
                    case NOME_BD_CONNECTION_POSTGRESS: {

                        conexao = DriverManager.getConnection(
                                SQLUtil.URL_POSTGRES,
                                SQLUtil.USUARIO_POSTGRES,
                                SQLUtil.SENHA_POSTGRES
                        );
                    }
                    break;
                    case NOME_BD_CONNECTION_MYSQL:
                        break;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return conexao;

    }

}
