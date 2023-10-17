package com.rv.services;

import java.util.ArrayList;

import com.rv.entities.Personne;
import com.rv.repositories.bd.core.IRopsitory;

public class PersonneServiceImpl implements IpersonneService {

    
    //Couplage faible
    private IRopsitory<Personne> personneRepository;
    //Injection de dépendance via le constructeur
    public PersonneServiceImpl(IRopsitory<Personne> personneRepository) {
        this. personneRepository =  personneRepository;
    }
    //Injection de dépendance via le setter
    public void setPersonneRepository(IRopsitory<Personne> personneRepository) {
        this. personneRepository =  personneRepository;
    }

    @Override
    public int add(Personne data) {
        // TODO Auto-generated method stub
        return personneRepository.insert(data);
       
    }

    @Override
    public ArrayList<Personne> getAll() {
        // TODO Auto-generated method stub
        return personneRepository.findAll();
       
    }
    
}
