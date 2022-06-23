package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Db {
    public static List<DbObject> list;

    public static List<DbObject> getDb(){
        if(list == null){
            list = new ArrayList<>();
        }
        return list;
    }

}
