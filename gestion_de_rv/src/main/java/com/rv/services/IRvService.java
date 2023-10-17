package com.rv.services;

import java.util.ArrayList;
import java.util.Date;


import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.Rv;

public interface IRvService extends IService<Rv> {
    void planifierRendezVous(Date date, Patient patient, Medecin medecin);
    ArrayList<Rv> afficherRendezVousParDate(Date date);
    void annulerRendezVous(Date date, Patient patient, Medecin medecin);
    
}
