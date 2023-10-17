package com.rv.repositories.bd.core;

import java.util.ArrayList;


import com.rv.entities.AbstractEntities;


public interface IRopsitory<T extends AbstractEntities> {

    int insert(T data);

    ArrayList<T> findAll();
    int delete (T data);
    int indexOf(T date);

    
}
