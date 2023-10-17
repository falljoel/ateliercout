package com.rv.repositories.bd.impl;

import java.util.ArrayList;




import com.rv.entities.AbstractEntities;

import com.rv.repositories.bd.core.IRopsitory;

public class RepositoryImpl<T extends  AbstractEntities> implements IRopsitory<T> {

    private  ArrayList<T> tables = new ArrayList<>();

    @Override
    public int insert(T data) {
        tables.add(data);
        return 1;
    }


    @Override
    public ArrayList<T> findAll() {
        return tables;
    }

    @Override
    public int delete(T data) {
        int pos = indexOf(data);
        if (pos != -1) {
            tables.remove(pos);
            return 1;
        }
        return 0;
    }

    @Override
    public int indexOf(T date) {
        int pos = 0;
        for (T rendezVous : tables) {
            if (rendezVous.getDate().equals(date)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }


}
