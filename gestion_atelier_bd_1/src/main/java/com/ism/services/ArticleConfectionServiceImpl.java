package com.ism.services;

import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;

import java.util.ArrayList;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {
     private ITables<ArticleConfection> articleConfectionRepository;
       //Injection de dépendance via le constructeur
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
    }
    //Injection de dépendance via le setter
    public void setCategoriesRepository(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
    }

    @Override
    public int add(ArticleConfection articleConfection) {
        return articleConfectionRepository.insert(articleConfection);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        // TODO Auto-generated method stub
        return articleConfectionRepository.findAll();
    }


    @Override
    public int update(ArticleConfection data) {
        return articleConfectionRepository.update(data);
    }
    @Override
    public ArticleConfection show(int id) {
        return articleConfectionRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return  articleConfectionRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }
}
