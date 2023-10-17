package com.rv.services;


import java.util.ArrayList;
import java.util.Date;


import com.rv.entities.Medecin;
import com.rv.entities.Patient;

import com.rv.entities.Rv;
import com.rv.repositories.bd.RvRepository;

public class RvServiceImpl implements IRvService {


 //Couplage faible
    private RvRepository rvRepository;
    //Injection de dépendance via le constructeur
    public RvServiceImpl(RvRepository rvRepository) {
        this. rvRepository =  rvRepository;
    }
    //Injection de dépendance via le setter
    public void setRvRepository(RvRepository rvRepository) {
        this. rvRepository =  rvRepository;
    }


    @Override
    public int add(Rv data) {
        // TODO Auto-generated method stub
        return rvRepository.insert(data);
       
    }

    @Override
    public ArrayList<Rv> getAll() {
        // TODO Auto-generated method stub
       return rvRepository.findAll();
    }
  

    @Override
    public void  planifierRendezVous(Date date, Patient patient, Medecin medecin) {
        // TODO Auto-generated method stub
        Rv rendezVous = new Rv(date, patient, medecin);
        // Ajouter le rendez-vous à la liste des rendez-vous
       rvRepository.insert(rendezVous);
        // Confirmer la planification du rendez-vous
        System.out.println("Le rendez-vous a été planifié pour le " + date + " avec le Dr " + medecin.getNomComplet() + ".");
    }

    @Override
    public ArrayList<Rv> afficherRendezVousParDate(Date date) {
        ArrayList<Rv> rendezVousDuJour = new ArrayList<>();
        ArrayList<Rv> tousLesRendezVous = rvRepository.findAll(); // Récupérer tous les rendez-vous de la base de données
    
        for (Rv rendezVous : tousLesRendezVous) {
            if (rendezVous.getDate().equals(date)) {
                rendezVousDuJour.add(rendezVous);
            }
        }
    
        return rendezVousDuJour;
    }
    

    @Override
    public void annulerRendezVous(Date date, Patient patient, Medecin medecin) {
        ArrayList<Rv> tousLesRendezVous = rvRepository.findAll(); // Récupérer tous les rendez-vous de la base de données

        for (Rv rendezVous : tousLesRendezVous) {
            if (rendezVous.getDate().equals(date) && rendezVous.getPatient().equals(patient) && rendezVous.getMedecin().equals(medecin)) {
                rvRepository.delete(rendezVous); // Supprimer le rendez-vous de la base de données
                System.out.println("Le rendez-vous du " + date + " avec le Dr " + medecin.getNomComplet() + " a été annulé pour le patient " + patient.getNomComplet() + ".");
                return;
            }
        }
    
        System.out.println("Aucun rendez-vous trouvé pour le " + date + " avec le Dr " + medecin.getNomComplet() + " pour le patient " + patient.getNomComplet() + ".");
    }
}


