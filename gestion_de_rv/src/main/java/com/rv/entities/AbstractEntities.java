package com.rv.entities;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class AbstractEntities {
    protected int id;
    protected Date date;

    public AbstractEntities(int id, Date date) {
        this.id = id;
        this.date =date;
    }

    public AbstractEntities() {
    }
    
}
