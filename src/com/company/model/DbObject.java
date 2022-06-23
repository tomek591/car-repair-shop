package com.company.model;

import com.company.enums.ObjectType;
import com.company.enums.Position;

public abstract class DbObject {

    public static long idBase = 1000000;
    private long id;
    private String name;
    private String date;
    private ObjectType objectType;


    public DbObject(String name, String date, ObjectType objectType) {
        this.id = idBase++;
        this.name = name;
        this.date = date;
        this.objectType = ObjectType.CAR;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
