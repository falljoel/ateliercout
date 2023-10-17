package com.rv.services;

import java.util.ArrayList;

public interface IService <T> {
     int  add(T data);
    ArrayList<T> getAll();
    
    
}
