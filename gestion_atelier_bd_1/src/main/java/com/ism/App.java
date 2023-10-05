package com.ism;


import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import com.ism.repositories.bd.ArticleConfectionRepository;
import com.ism.repositories.list.TableArticleConfections;
import com.ism.repositories.list.TableCategories;
import com.ism.services.ArticleConfectionService;
import com.ism.services.ArticleConfectionServiceImpl;
import com.ism.services.CategorieServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ITables<Categorie> categorieRepository = new TableCategories();
        CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl(categorieRepository);

        ITables<ArticleConfection> articleRepository = new TableArticleConfections();
        ArticleConfectionServiceImpl articleServiceImpl = new ArticleConfectionServiceImpl(articleRepository);

        int choix1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1- Catégorie");
            System.out.println("2- Article Confection");
            choix1 = scanner.nextInt();

            int choix;

            if (choix1 == 1) {
                // Categorie
                do {
                    System.out.println("1- Ajouter");
                    System.out.println("2- Lister");
                    System.out.println("3- Supprimer");
                    System.out.println("4- Modifier");
                    System.out.println("5- Quitter");
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1:
                            System.out.println("Entrez le libelle");
                            Categorie categorie = new Categorie(scanner.nextLine());
                            categorieServiceImpl.add(categorie);
                            break;
                        case 2:
                            categorieServiceImpl.getAll().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Entreer l'id a supprimer...");
                            int id = scanner.nextInt();
                            if (categorieServiceImpl.show(id) != null) {
                                categorieServiceImpl.remove(id);
                                scanner.nextLine();
                            }
                            break;
                        case 4:
                            System.out.println("Entrez l'ID de la catégorie à modifier : ");
                            int id1 = scanner.nextInt();
                            scanner.nextLine();

                            Categorie cate_mod = categorieServiceImpl.show(id1);
                            if (cate_mod != null) {
                                System.out.println("Entrez le nouveau nom de la catégorie : ");
                                String nouveauLibelle = scanner.nextLine();
                                cate_mod.setLibelle(nouveauLibelle);
                                categorieServiceImpl.update(cate_mod);
                                System.out.println("La catégorie a été modifiée avec succès !");
                            } else {
                                System.out.println("La catégorie n'existe pas !");
                            }
                            break;
                        default:
                            break;
                    }
                } while (choix != 5);
            } else if (choix1 == 2) {
                // Article Confection
                do {
                    System.out.println("1- Ajouter");
                    System.out.println("2- Lister");
                    System.out.println("3- Supprimer");
                    System.out.println("4- Modifier");
                    System.out.println("5- Quitter");
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1:
                            System.out.println("Entrez le nom de l'article : ");
                            String nomArticle = scanner.nextLine();

                            System.out.println("Entrez le prix de l'article : ");
                            double prixArticle = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.println("Entrez la taille de l'article : ");
                            String tailleArticle = scanner.nextLine();

                            ArticleConfection article = new ArticleConfection();
                            articleServiceImpl.add(article);
                            break;
                        case 2:
                            articleServiceImpl.getAll().forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Entreer l'id a supprimer...");
                            int id = scanner.nextInt();
                            if (articleServiceImpl.show(id) != null) {
                                articleServiceImpl.remove(id);
                                scanner.nextLine();
                            }
                            break;
                        case 4:
                            System.out.println("Entrez l'ID de l'article à modifier : ");
                            int id1 = scanner.nextInt();
                            scanner.nextLine();

                            ArticleConfection article_mod = articleServiceImpl.show(id1);
                            if (article_mod != null) {
                                System.out.println("Entrez le nouveau nom de l'article : ");
                                String nouveauNomArticle = scanner.nextLine();

                                System.out.println("Entrez le nouveau prix de l'article : ");
                                double nouveauPrixArticle = scanner.nextDouble();
                                scanner.nextLine();

                                System.out.println("Entrez la nouvelle taille de l'article : ");
                                String nouvelleTailleArticle = scanner.nextLine();

                                article_mod.setLibelle(nouveauNomArticle);
                                article_mod.setPrix(nouveauPrixArticle);
                                article_mod.setLibelle(nouvelleTailleArticle);

                                articleServiceImpl.update(article_mod);
                                System.out.println("L'article a été modifié avec succès !");
                            } else {
                                System.out.println("L'article n'existe pas !");
                            }
                            break;
                        default:
                            break;
                    }
                } while (choix != 5);
            }
        } while (choix1 != 3);
    }
}
