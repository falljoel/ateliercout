package com.rv.entities;
import java.util.ArrayList;
import com.rv.entities.enums.Type;

public class Medecin extends Personne{
    

    public Medecin( String nomComplet, Type typePersonne) {
        super(nomComplet);
        this.typePersonne = Type.MEDECIN;
    }

    public Medecin() {
    }

      // OneToMany
      ArrayList<Rv> rvs=new ArrayList<>();

    public void addRv(Rv rv){
        rvs.add(rv);
    }

    @Override
    public String toString() {
        return super.toString()+ "Medecin [specialiste="+ "]";
    }
    
}
