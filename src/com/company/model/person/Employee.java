package com.company.model.person;

import com.company.enums.Position;
import com.company.enums.ObjectType;
import com.company.service.IPayments;

public class Employee extends Person implements IPayments {

    private int salary;
    private Position position;

    public Employee(String name, String date, ObjectType objectType, double balanceOfPayments, int salary, Position position) {
        super(name, date, objectType, balanceOfPayments);
        this.salary = salary;
        this.position = position;
        setObjectType(ObjectType.EMPLOYEE);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Identyfikator obiektu: ").append(getId());
        sb.append("\nTyp obiektu: Pracownik");
        sb.append("\nImię i nazwisko pracownika: ").append(getName());
        sb.append("\nData przyjęcia pracownika:  ").append(getDate());
        sb.append("\nSaldo płatności:  ").append(getBalanceOfPayments());
        sb.append("\nPensja: ").append(getSalary());
        sb.append("\nStanowisko pracy:  ").append(getPosition()).append("\n");
        return sb.toString();
    }

    @Override
    public void settlePayment() {
        setBalanceOfPayments(0);
        System.out.println("Płatności wobec pracownika zostały uregulowane");
    }
}
