package com.rv.entities;
import java.util.ArrayList;

import com.rv.entities.enums.Type;

public class Patient extends Personne {
    private String address;
    private String tel;
    
    public Patient() {
    }
    public Patient( String nomComplet, String address, String tel, Type typePersonne ) {
        super( nomComplet);
        this.address = address;
        this.tel = tel;
        this.typePersonne = Type.PATIENT;
    }
    public Patient(String address, String tel , Type typePersonne) {
        this.address = address;
        this.tel = tel;
         this.typePersonne = Type.PATIENT;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    @Override
    public String toString() {
        return super.toString()+"Patient [address=" + address + ", tel=" + tel + "]";
    }
      // OneToMany
      ArrayList<Rv> rvs=new ArrayList<>();

    public void addRv(Rv rv){
        rvs.add(rv);
    }
    
}
