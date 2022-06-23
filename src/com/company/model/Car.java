package com.company.model;

import com.company.enums.PurposeOfArrival;
import com.company.enums.ObjectType;

public class Car extends DbObject {

    private String ownerNameSurname;
    private int yearOfProduction;
    private PurposeOfArrival purposeOfArrival;
    private int cost;

    public static int carCounter;

    public Car(String name, String date, ObjectType objectType, String ownerNameSurname, int yearOfProduction, PurposeOfArrival purposeOfArrival, int cost) {
        super(name, date, objectType);
        this.ownerNameSurname = ownerNameSurname;
        this.yearOfProduction = yearOfProduction;
        this.purposeOfArrival = purposeOfArrival;
        this.cost = cost;
        setObjectType(ObjectType.CAR);
        carCounter++;
    }

    public String getOwnerNameSurname() {
        return ownerNameSurname;
    }

    public void setOwnerNameSurname(String ownerNameSurname) {
        this.ownerNameSurname = ownerNameSurname;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public PurposeOfArrival getPurposeOfArrival() {
        return purposeOfArrival;
    }

    public void setCelPrzyjazdu(PurposeOfArrival purposeOfArrival) {
        this.purposeOfArrival = purposeOfArrival;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Identyfikator obiektu: ").append(getId());
        sb.append("\nTyp obiektu: Samochód");
        sb.append("\nMarka i model samochodu: ").append(getName());
        sb.append("\nImię i nazwisko właściciela: ").append(getOwnerNameSurname());
        sb.append("\nRok produkcji: ").append(getYearOfProduction());
        sb.append("\nCel przyjazdu: ").append(getPurposeOfArrival());
        sb.append("\nData przyjęcia pojazdu: ").append(getDate());
        sb.append("\nKoszt: ").append(getCost()).append("\n");
        return sb.toString();
    }

}
