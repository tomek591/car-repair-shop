package com.company.model.person;

import com.company.model.DbObject;
import com.company.enums.ObjectType;

public abstract class Person extends DbObject {

    private double balanceOfPayments;

    public Person(String name, String date, ObjectType objectType, double balanceOfPayments) {
        super(name, date, objectType);
        this.balanceOfPayments = balanceOfPayments;
    }

    public double getBalanceOfPayments() {
        return balanceOfPayments;
    }

    public void setBalanceOfPayments(double balanceOfPayments) {
        this.balanceOfPayments = balanceOfPayments;
    }

}
