package com.rv.repositories.bd.impl;

import java.util.ArrayList;
import java.sql.*;

import com.rv.entities.Patient;
import com.rv.entities.Personne;
import com.rv.entities.Rv;
import com.rv.repositories.bd.PatientRepository;
import com.rv.repositories.bd.core.Database;

public class PatientImpl implements PatientRepository {
      //injection de dependence
    private Database database;

    private final String SQL_INSERT = "INSERT INTO `personne` (`id`, `nomComplet`,`type`,`patient`,`specialite`) VALUES (NULL, ?, ?, ?, NULL)";
    private final String SQL_FIND_ALL = "SELECT id,nomComplet,type,patient,specialite FROM personne";
    private final String SQL_DELETE = "DELETE FROM `personne` WHERE id = ?";


    @Override
    public int insert(Personne data) {
        // TODO Auto-generated method stub
      
            int nbrLigne = 0;
            try {
                database.openConnection();
                database.getPs().setString(1,data.getNomComplet());
                 database.getPs().setObject(2,data.getTypePersonne());
                  database.getPs().setObject(3,data.);
                nbrLigne=database.executeUpdate(SQL_INSERT);
                database.getPs().close();
                database.closeConnexion();
            } catch (SQLException e) {
                System.out.printf("Erreur execution de request %s", PatientImplImpl.class);
            }
            return nbrLigne;
        
    }

    @Override
    public ArrayList<Personne> findAll() {
        // TODO Auto-generated method stub
        ArrayList<Patient> patients=new ArrayList<>();
        try {
            database.openConnection();
            ResultSet rs = database.executeSelect(SQL_FIND_ALL);
            while (rs.next()) {
               //ORM == converti une ligne de base de donnes en un objet de type java
               Patient patient=new Patient(
                   //converti le typeBD en type Java
                   rs.getInt("id"),
                   rs.getString("libelle")
               );
               categories.add(categorie);
            }
            database.getPs().close();
            database.closeConnexion();
            rs.close();
        } catch (SQLException e) {
            System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);        }
        return categories;
    }

    @Override
    public int delete(Personne data) {
        // TODO Auto-generated method stub
       
            int nbrLigne = 0;
            try {
                database.openConnection();
                database.getPs().setInt(1,id);
                nbrLigne=database.executeUpdate(SQL_DELETE);
                database.getPs().close();
                database.closeConnexion();
            } catch (SQLException e) {
                System.out.printf("Erreur execution de request %s", CategorieRepositoryImpl.class);        }
            return nbrLigne;
    }

    @Override
    public int indexOf(Personne date) {
        // TODO Auto-generated method stub
        return null; 
}
    
}

