package com.rv.repositories.bd.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rv.repositories.bd.core.Database;

public class DatabaseImpl implements Database {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/gestion_rv";
    private final String user = "root";
    private final String password = "";
    private Connection conn = null;


    protected PreparedStatement ps;


    @Override
    public void openConnection() {
        // TODO Auto-generated method stub
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.printf("Erreur de chargement de driver %s");
        }
    }

    @Override
    public void closeConnexion() {
        // TODO Auto-generated method stub
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur de Fermeture de connexion");
            }
        }
    }

    @Override
    public ResultSet executeSelect(String sql) {
        // TODO Auto-generated method stub
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Erreur de execution request");
        }
        return rs;
    
    }

    @Override
    public int executeUpdate(String sql) {
        // TODO Auto-generated method stub
        int nbrLigne=0; try {
            ps=conn.prepareStatement(sql);
            nbrLigne=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur de execution request");
        }
        return nbrLigne;
    }
    

    @Override
    public PreparedStatement getPs() {
        // TODO Auto-generated method stub
        return ps;
    }

}
    

