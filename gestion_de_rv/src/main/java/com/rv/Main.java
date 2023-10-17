package com.rv;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rv.entities.Rv;
import com.rv.entities.Patient;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rv> listeRv = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1. Créer un patient");
            System.out.println("2. Créer un médecin");
            System.out.println("3. Planifier un rendez-vous");
            System.out.println("4. Afficher les rendez-vous du jour");
            System.out.println("5. Afficher les rendez-vous d'un médecin par jour");
            System.out.println("6. Annuler un rendez-vous");
            System.out.println("7. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Vider la ligne

            switch (choix) {
                case 1:
                    // Créer un patient
                    Patient patient = new Patient();
                    System.out.println("Entrez le nom complet du patient :");
                    patient.setNomComplet(scanner.nextLine());
                    System.out.println("Entrez la date de naissance du patient (AAAA-MM-JJ) :");
                    LocalDate dateNaissance = LocalDate.parse(scanner.nextLine());
                    patient.setDateNaissance(dateNaissance);
                    System.out.println("Entrez l'adresse du patient :");
                    patient.setAdresse(scanner.nextLine());
                    System.out.println("Entrez le numéro de téléphone du patient :");
                    patient.setTelephone(scanner.nextLine());
                    System.out.println("Patient créé avec succès !");
                    break;
                case 2:
                    // Créer un médecin
                    Medecin medecin = new Medecin();
                    System.out.println("Entrez le nom complet du médecin :");
                    medecin.setNomComplet(scanner.nextLine());
                    System.out.println("Entrez la spécialité du médecin :");
                    medecin.setSpecialite(scanner.nextLine());
                    System.out.println("Entrez le numéro de téléphone du médecin :");
                    medecin.setTelephone(scanner.nextLine());
                    System.out.println("Médecin créé avec succès !");
                    break;
                case 3:
                    // Planifier un rendez-vous
                    if (listeRv.isEmpty()) {
                        System.out.println("Aucun patient ou médecin disponible pour planifier un rendez-vous.");
                        break;
                    }
                    Rv rv = new Rv();
                    System.out.println("Choisissez le patient pour le rendez-vous :");
                    for (int i = 0; i < listePatients.size(); i++) {
                        System.out.println((i + 1) + ". " + listePatients.get(i).getNomComplet());
                    }
                    int choixPatient = scanner.nextInt();
                    scanner.nextLine(); // Vider la ligne
                    rv.setPatient(listePatients.get(choixPatient - 1));
                    System.out.println("Choisissez le médecin pour le rendez-vous :");
                    for (int i = 0; i < listeMedecins.size(); i++) {
                        System.out.println((i + 1) + ". " + listeMedecins.get(i).getNomComplet());
                    }
                    int choixMedecin = scanner.nextInt();
                    scanner.nextLine(); // Vider la ligne
                    rv.setMedecin(listeMedecins.get(choixMedecin - 1));
                    System.out.println("Entrez la date et l'heure du rendez-vous (AAAA-MM-JJ HH:MM) :");
                    LocalDateTime dateHeure = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    rv.setDateHeure(dateHeure);
                    System.out.println("Entrez la durée du rendez-vous en minutes :");
                    int duree = scanner.nextInt();
                    scanner.nextLine(); // Vider la ligne
                    rv.setDureeMinutes(duree);
                    listeRv.add(rv);
                    System.out.println("Rendez-vous planifié avec succès !");
                    break;
                case 4:
                    // Afficher les rendez-vous du jour
                    LocalDate dateJour = LocalDate.now();
                    System.out.println("Rendez-vous du " + dateJour + " :");
                    for (Rv rvJour : listeRv) {
                        if (rvJour.getDateHeure().toLocalDate().equals(dateJour)) {
                            System.out.println("- " + rvJour.getPatient().getNomComplet() +
                                    " avec le Dr. " + rvJour.getMedecin().getNomComplet() +
                                    " à " + rvJour.getDateHeure().toLocalTime());
                        }
                    }
                    break;
                case 5:
                    // Afficher les rendez-vous d'un médecin par jour
                    System.out.println("Choisissez le médecin :");
                    for (int i = 0; i < listeMedecins.size(); i++) {
                        System.out.println((i + 1) + ". " + listeMedecins.get(i).getNomComplet());
                    }
                    int choixMedecinRv = scanner.nextInt();
                    scanner.nextLine(); // Vider la ligne
                    Medecin medecinRv = listeMedecins.get(choixMedecinRv - 1);
                    System.out.println("Entrez la date du rendez-vous (AAAA-MM-JJ) :");
                    LocalDate dateRv = LocalDate.parse(scanner.nextLine());
                    System.out.println("Rendez-vous du Dr. " + medecinRv.getNomComplet() + " le " + dateRv + " :");
                    for (Rv rvMedecin : listeRv) {
                        if (rvMedecin.getMedecin().equals(medecinRv) && rvMedecin.getDateHeure().toLocalDate().equals(dateRv)) {
                            System.out.println("- " + rvMedecin.getPatient().getNomComplet() +
                                    " à " + rvMedecin.getDateHeure().toLocalTime());
                        }
                    }
                    break;
                case 6:
                    // Annuler un rendez-vous
                    if (listeRv.isEmpty()) {
                        System.out.println("Aucun rendez-vous à annuler.");
                        break;
                    }
                    System.out.println("Choisissez le rendez-vous à annuler :");
                    for (int i = 0; i < listeRv.size(); i++) {
                        Rv rvAnnuler = listeRv.get(i);
                        System.out.println((i + 1) + ". " + rvAnnuler.getPatient().getNomComplet() +
                                " avec le Dr. " + rvAnnuler.getMedecin().getNomComplet() +
                                " à " + rvAnnuler.getDateHeure().toLocalTime());
                    }
                    int choixAnnulation = scanner.nextInt();
                    scanner.nextLine(); // Vider la ligne
                    listeRv.remove(choixAnnulation - 1);
                    System.out.println("Rendez-vous annulé avec succès !");
                    break;
                case 7:
                    // Quitter l'application
                    System.exit(0);
                default:
                  
                }
            }
        }
    }

