package com.rv.entities;


import java.util.Date;


public class Rv extends AbstractEntities{
    // ManyToOne
    private Patient patient;
   
    public Rv(  Date date ) {
        
        this.date = date;

        
    }
    
    private Date date;
    
    

    public Patient getPatient() {
        return patient;
    }

    private Medecin medecin;
    

    
    public Medecin getMedecin() {
        return medecin;
    }
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
        medecin.addRv(this);

    }
    public void setPatient(Patient patient) {
        // lien de rv vers patient
        this.patient = patient;
        patient.addRv(this);
    }
    public Rv() {
    }
   
   
    public Rv(Date date, Patient patient, Medecin medecin) {
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
  
  
     @Override
    public String toString() {
        return super.toString()+ ", date=" + date +  "]";
    
    }

 
}
