package com.rv.entities;
import com.rv.entities.enums.Type;

public class Personne extends AbstractEntities {
    protected int id;
    protected String nomComplet;
    protected Type typePersonne;
    

    public Type getTypePersonne() {
        return typePersonne;
    }
    public void setTypePersonne(Type typePersonne) {
        this.typePersonne = typePersonne;
    }
    public Personne( String nomComplet) {
        
        this.nomComplet = nomComplet;
    }
    public Personne() {
    }
   
   
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    @Override
    public String toString() {
        return super.toString()+ ", nomComplet=" + nomComplet + "]";
    }
   
}
