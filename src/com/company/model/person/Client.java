package com.company.model.person;

import com.company.enums.ObjectType;
import com.company.service.IPayments;

public class Client extends Person implements IPayments {

    private boolean loyaltyCard;
    private int sumOfAllFees;

    public Client(String name, String date, ObjectType objectType, double balanceOfPayments, boolean loyaltyCard) {
        super(name, date, objectType, balanceOfPayments);
        this.loyaltyCard = loyaltyCard;
        this.sumOfAllFees += balanceOfPayments;
        setObjectType(ObjectType.CLIENT);
    }

    public boolean getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public int getSumOfAllFees() {
        return sumOfAllFees;
    }

    public void setSumOfAllFees(int sumOfAllFees) {
        this.sumOfAllFees = sumOfAllFees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Identyfikator obiektu: ").append(getId());
        sb.append("\nTyp obiektu: Klient");
        sb.append("\nImię i nazwisko klienta: ").append(getName());
        sb.append("\nData przyjęcia klienta:  ").append(getDate());
        sb.append("\nSaldo płatności:  ").append(getBalanceOfPayments());
        sb.append("\nCzy klient posiada karte stałego klienta: ").append(getLoyaltyCard());
        sb.append("\nSuma poniesionych kosztów w warsztacie:  ").append(getSumOfAllFees()).append("\n");
        return sb.toString();
    }

    @Override
    public void settlePayment() {
        setBalanceOfPayments(0);
        System.out.println("Płatności wobe Klienta zostały uregulowane");
    }
}
